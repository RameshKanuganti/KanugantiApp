package com.ads.todayoffers;

/**
 * Created by thrmyr on 18/9/15.
 */
public class Markers {
    String markerName;
    Double distance;
    Double time;

    public Markers(String markerName, Double distance, Double time) {
        this.markerName = markerName;
        this.distance = distance;
        this.time = time;
    }

    public String getMarkerName() {
        return markerName;
    }

    public void setMarkerName(String markerName) {
        this.markerName = markerName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}