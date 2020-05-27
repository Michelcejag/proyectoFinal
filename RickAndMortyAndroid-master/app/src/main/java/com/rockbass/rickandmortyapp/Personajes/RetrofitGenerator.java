package com.rockbass.rickandmortyapp.Personajes;


import com.rockbass.rickandmortyapp.LocationApi.location_interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGenerator {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    private static Character character;

    public static Character getCharacterService(){
        if (character == null){
            character = retrofit.create(Character.class);
        }

        return character;
    }

    private static location_interface location;

    public static location_interface getLocationService(){
        if (location == null){
            location = retrofit.create(location_interface.class);
        }

        return location;
    }

}
