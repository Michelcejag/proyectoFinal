package com.rockbass.rickandmortyapp.LocationApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rockbass.rickandmortyapp.LocationApi.ResultLocation;
import com.rockbass.rickandmortyapp.Personajes.RetrofitGenerator;
import com.rockbass.rickandmortyapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class location_activity extends AppCompatActivity {
    ResultLocation resultLocation;
    TextView textViewName, textViewStatus, textViewType;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_activity);
        Intent intent = getIntent();

        textViewName = this.findViewById(R.id.textview_name);
        textViewStatus = this.findViewById(R.id.textView_dimension);
        textViewType = this.findViewById(R.id.textView_type);

        String url = intent.getStringExtra("url");

        ObtenerLocation(url);
    }


    public void ObtenerLocation(String url)  {

        RetrofitGenerator.getLocationService().getLocationByUrl(url)
                .enqueue(new Callback<ResultLocation>() {


                    @Override
                    public void onResponse(Call<ResultLocation> call, Response<ResultLocation> response) {

                        if (response.isSuccessful()){

                            if(response.body()!=null) {
                                textViewName.setText(response.body().name);
                                textViewStatus.setText(response.body().dimension);
                                textViewType.setText(response.body().type);
                            }}
                    }

                    @Override
                    public void onFailure(Call<ResultLocation> call, Throwable t) {

                    }
                });
    }


}
