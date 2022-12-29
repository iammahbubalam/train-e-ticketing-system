package com.mahbubalam.traineticketingsystem.server.entity;

public class Station {
    private int stationId;
    private int routeId;
    private String stationName;
    private float distanceFromStart;

    public Station(int routeId, String stationName, float distanceFromStart) {
        this.routeId = routeId;
        this.stationName = stationName;
        this.distanceFromStart = distanceFromStart;
    }

    public Station() {
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public float getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(float distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", routeId=" + routeId +
                ", stationName='" + stationName + '\'' +
                ", distanceFromStart=" + distanceFromStart +
                '}';
    }
}
