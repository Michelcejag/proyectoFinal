package com.rockbass.rickandmortyapp.LocationApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface location_interface {
        @GET
        Call<ResultLocation> getLocationByUrl(@Url String url);
}
