package com.rockbass.rickandmortyapp.LocationApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultLocation {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
        public String name;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("created")
    @Expose
    public String created;

    @SerializedName("dimension")
    @Expose
    public String dimension;

    @SerializedName("residents")
    @Expose
    public String[] residents;
}
