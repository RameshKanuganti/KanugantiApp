package com.ads.todayoffers;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thrmyr on 18/9/15.
 */
public class MapViewFragment extends Fragment implements LocationListener {
    private MapView mapView;
    private GoogleMap map;
    private static String addressName;
    //private Map<String, List<Brick>> brickMap;
    private List<String> arrayList;
    private List<Address> addressList = null;
    private Address address;
    private Marker marker, marker1;
    private HashMap<Marker, Markers> mMarkersHashMap;
    LocationManager locationManager;
    private static final long MIN_DISTANCE_FOR_UPDATE = 10;
    private static final long MIN_TIME_FOR_UPDATE = 1000 * 60 * 2;
    private Location location;
    private LatLng latLng, currentLatLang;
    private MarkerOptions markerOptions;
    Document document;
    GMapV2GetRouteDirection v2GetRouteDirection;
    ArrayList<Double> distanceArrayList;
    private double time = 0;
    private Markers markers;
    private String addressMapView;

    public static void setAddressName(String name) {
        addressName = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.root_map, container, false);

        addressMapView = MainActivity.deatailsBundle.getString("rootMap");

        locationManager = (LocationManager) getActivity().getSystemService(getActivity().LOCATION_SERVICE);
        Location gpsLocation = getLocation(LocationManager.NETWORK_PROVIDER);
        distanceArrayList = new ArrayList<>();

        v2GetRouteDirection = new GMapV2GetRouteDirection();
        currentLatLang = new LatLng(gpsLocation.getLatitude(), gpsLocation.getLongitude());

        Log.d("Location", "ABCD" + gpsLocation);
        arrayList = new ArrayList<>();
        mMarkersHashMap = new HashMap();
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
       /* brickMap = (Map<String, List<Brick>>) MainActivity.bundle.getSerializable("map");
        Set set = brickMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            ArrayList<Brick> brickList = (ArrayList) me.getValue();
            for (int index = 0; index < brickList.size(); index++) {
                Brick brick = brickList.get(index);
                if (brick.getBrickName().equalsIgnoreCase(addressName)) {
                    arrayList.add(brick.getProviderAddress());
                }
            }
        }*/

        arrayList.add(addressMapView);
        map = mapView.getMap();
        map.setMyLocationEnabled(true);

        Geocoder geocoder = new Geocoder(getActivity());
        for (String string : arrayList) {
            try {
                addressList = geocoder.getFromLocationName(string, 1);

                if (addressList != null) {
                    address = addressList.get(0);
                    Log.d("Each Address", "ABCD" + address);
                    latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    markerOptions = new MarkerOptions()
                            .position(latLng);
                    Double distance = getDistance(latLng, currentLatLang);

                    Double estimatedDriveTimeInMinutes = distance / 50;
                    Double finalValue = Math.round(estimatedDriveTimeInMinutes * 100.0) / 100.0;
                    Double dist = Math.round(distance * 100.0) / 100.0;
                    marker = map.addMarker(markerOptions);
                    markers = new Markers(string, dist, finalValue);
                    mMarkersHashMap.put(marker, markers);
                    marker.showInfoWindow();
                    map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                    map.setInfoWindowAdapter(new PopupAdapter());

                } else {
                    Log.d("addressList List", "pass" + addressList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("AFter First for loop", "ABCD");
        for (String string : arrayList) {
            try {
                addressList = geocoder.getFromLocationName(string, 1);
                if (addressList != null) {
                    address = addressList.get(0);
                    latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    currentLatLang = new LatLng(gpsLocation.getLatitude(), gpsLocation.getLongitude());
                    Log.d("Longitude and Latitude", "ABCD1" + latLng + currentLatLang);
                    GetRouteTask getRoute = new GetRouteTask();
                    getRoute.execute();
                } else {
                    Log.d("addressList List", "pass" + addressList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    private class GetRouteTask extends AsyncTask<String, Void, String> {

        private ProgressDialog Dialog;
        String response = "";

        @Override
        protected void onPreExecute() {
            Dialog = new ProgressDialog(getActivity());
            Dialog.setMessage("Loading route...");
            Dialog.show();
        }

        @Override
        protected String doInBackground(String... urls) {

            document = v2GetRouteDirection.getDocument(currentLatLang, latLng, GMapV2GetRouteDirection.MODE_DRIVING);
            Log.d("Response", "ABCD2" + document);
            response = "Success";
            return response;

        }

        @Override
        protected void onPostExecute(String result) {
            if (response.equalsIgnoreCase("Success")) {

                ArrayList<LatLng> directionPoint = v2GetRouteDirection.getDirection(document);
                int timeDuration = v2GetRouteDirection.getDurationValue(document);
                Log.d("Time", "pass" + timeDuration);
                PolylineOptions rectLine = new PolylineOptions().width(7).color(
                        Color.RED);
                for (int i = 0; i < directionPoint.size(); i++) {
                    rectLine.add(directionPoint.get(i));
                }
                map.addPolyline(rectLine);

            }
            Dialog.dismiss();

        }
    }

    public double getDistance(LatLng LatLng1, LatLng LatLng2) {
        double distance = 0, d = 0;
        Location locationA = new Location("A");
        locationA.setLatitude(LatLng1.latitude);
        locationA.setLongitude(LatLng1.longitude);
        Location locationB = new Location("B");
        locationB.setLatitude(LatLng2.latitude);
        locationB.setLongitude(LatLng2.longitude);
        d = locationA.distanceTo(locationB);

        Log.e("", "AAAAAAAAA" + d);
        distance = d / 1000;
        Log.e("", "BBBBBB" + distance);

        return distance;

    }

    public Location getLocation(String provider) {
        Log.d("Mgr", "ABCD" + locationManager.isProviderEnabled(provider));
        if (locationManager.isProviderEnabled(provider)) {
            locationManager.requestLocationUpdates(provider,
                    MIN_TIME_FOR_UPDATE, MIN_DISTANCE_FOR_UPDATE, this);
            Log.d("Location Manager", "ABCD" + locationManager);
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(provider);
                return location;
            }
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public class PopupAdapter implements GoogleMap.InfoWindowAdapter {
        LayoutInflater inflater = null;
        TextView distanceTextView, timeTextView, textView;

        @Override
        public View getInfoWindow(Marker marker) {
            return (null);

        }

        @Override
        public View getInfoContents(Marker marker) {
            View popup = getActivity().getLayoutInflater().inflate(R.layout.marker_layout, null);
            textView = (TextView) popup.findViewById(R.id.textMarker);
            distanceTextView = (TextView) popup.findViewById(R.id.distance);
            timeTextView = (TextView) popup.findViewById(R.id.time);

            Markers object = mMarkersHashMap.get(marker);
            Log.d("Object", "pass" + object);
            textView.setText(object.getMarkerName());
            distanceTextView.setText(object.getDistance().toString() + "Km");
            timeTextView.setText(object.getTime().toString() + " hrs");

            return (popup);
        }


    }
}
