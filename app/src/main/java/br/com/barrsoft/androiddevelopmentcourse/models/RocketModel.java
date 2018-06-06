package br.com.barrsoft.androiddevelopmentcourse.models;

import com.google.gson.annotations.SerializedName;

public class RocketModel {

    @SerializedName("launch_year")
    String launchdate;

    @SerializedName("launch_success")
    Boolean launchsuccess;

    @SerializedName("rocket")
    Rocket rocket;

    public String getLaunchdate() {
        return launchdate;
    }

    public void setLaunchdate(String launchdate) {
        this.launchdate = launchdate;
    }

    public Boolean getLaunchsuccess() {
        return launchsuccess;
    }

    public void setLaunchsuccess(Boolean launchsuccess) {
        this.launchsuccess = launchsuccess;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }
}