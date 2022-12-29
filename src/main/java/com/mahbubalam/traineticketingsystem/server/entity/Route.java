package com.mahbubalam.traineticketingsystem.server.entity;

public class Route {
    private int routeId;
    private String routeName;
    private float totalDistance;

    public Route(String routeName, float totalDistance) {
        this.routeName = routeName;
        this.totalDistance = totalDistance;
    }

    public Route() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", totalDistance=" + totalDistance +
                '}';
    }
}
