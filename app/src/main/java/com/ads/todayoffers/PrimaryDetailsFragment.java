package com.ads.todayoffers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by thrmyr on 9/9/15.
 */
public class PrimaryDetailsFragment extends Fragment {

    TextView offerTitle, offetDescription, rootMap;
    ImageView offerImage;

    String rootMapValue;

    SuperInterface mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.offer_details, container, false);


        String description = MainActivity.deatailsBundle.getString("detailsname", "No Data");
        int image = MainActivity.deatailsBundle.getInt("detailsimage", 0);

        offerImage = (ImageView) v.findViewById(R.id.imageViewOfferDesc);
        offerTitle = (TextView) v.findViewById(R.id.textViewOfferTitle);
        offetDescription = (TextView) v.findViewById(R.id.textViewDescription);
        rootMap = (TextView) v.findViewById(R.id.textViewDescriptionMap);

        rootMapValue = offetDescription.getText().toString();


        rootMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.deatailsBundle.putString("rootMap", rootMapValue);

                PrimaryDetailsFragment.this.mListener.mapView();
            }
        });

        offerTitle.setText(description);
        offerImage.setImageResource(image);


        return v;
    }

    @Override
    public void onAttach(final Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        try {
            this.mListener = (SuperInterface) activity;
        } catch (final ClassCastException e) {
            throw new ClassCastException(
                    "Activity must implement RequestedListener.");
        }

    }

}
