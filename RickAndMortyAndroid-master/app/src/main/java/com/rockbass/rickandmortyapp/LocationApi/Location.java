package com.rockbass.rickandmortyapp.LocationApi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;



public class Location {
    private String name;
    private String url;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
