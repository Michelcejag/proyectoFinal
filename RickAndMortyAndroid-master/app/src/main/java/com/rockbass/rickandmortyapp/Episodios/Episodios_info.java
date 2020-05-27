package com.rockbass.rickandmortyapp.Episodios;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import com.rockbass.rickandmortyapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Episodios_info extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private ProgressDialog mprocessingdialog;
    private static String url = "https://rickandmortyapi.com/api/episode";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episodes_expandablelist);


        mprocessingdialog = new ProgressDialog(this);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.Expandable_episodios);

        // preparing list data
        new DownloadJason().execute();

    }

    private class DownloadJason extends AsyncTask<Void, Void, Void> {




        @Override
        protected Void doInBackground(Void... voids) {

            JSONParser jp = new JSONParser();
            String jsonstr = jp.makeServiceCall(url);
            Log.d("Response = ", jsonstr);

            if (jsonstr != null) {
//            For Header title Arraylist
                listDataHeader = new ArrayList<String>();
//                Hashmap for child data key = header title and value = Arraylist (child data)
                listDataChild = new HashMap<String, List<String>>();


                try {
                    JSONObject jobj = new JSONObject(jsonstr);
                    JSONArray jarray = jobj.getJSONArray("results");
                    for (int hk = 0; hk < jarray.length(); hk++) {
                        JSONObject d = jarray.getJSONObject(hk);
                        listDataHeader.add(d.getString("episode"));

                        List<String> lease_offer = new ArrayList<String>();
                        lease_offer.add(d.getString("name"));
                        lease_offer.add(d.getString("air_date"));

                        listDataChild.put(listDataHeader.get(hk), lease_offer);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }else{
                Toast.makeText(getApplicationContext(),
                        "Please Check internet Connection", Toast.LENGTH_SHORT)
                        .show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            mprocessingdialog.dismiss();
            //call constructor
            listAdapter = new com.rockbass.rickandmortyapp.Episodios.ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);

        }
    }
    }



