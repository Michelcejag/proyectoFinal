package com.rockbass.rickandmortyapp.Personajes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rockbass.rickandmortyapp.LocationApi.location_activity;
import com.rockbass.rickandmortyapp.R;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<ResultCharacter.Result> results;
    private Context context;


    public void addResults(List<ResultCharacter.Result> results){
        this.results.addAll(results);
        notifyDataSetChanged();
    }
    public CharacterAdapter(Context context){
        results=new ArrayList<>();
        this.context=context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View card = inflater.inflate(R.layout.character_card, parent, false);
        return new CharacterViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        ResultCharacter.Result result = results.get(position);
        holder.bind(result);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(ResultCharacter.Result result){
            ImageView imageViewProfile = itemView.findViewById(R.id.imageview_profile);
            TextView textViewName, textViewGender, textViewStatus, textViewSpecies, textViewType,textViewid, textViewLocation;
            textViewName = itemView.findViewById(R.id.textview_name);
            textViewGender = itemView.findViewById(R.id.textView_gender);
            textViewSpecies = itemView.findViewById(R.id.textView_species);
            textViewStatus = itemView.findViewById(R.id.textView_status);
            textViewType = itemView.findViewById(R.id.textView_type);
            textViewid=itemView.findViewById(R.id.textView_Earth);

            textViewid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), location_activity.class);
                    intent.putExtra("url",result.location.getUrl());
                    v.getContext().startActivity(intent);
                }
            });
            textViewName.setText(result.name);
            textViewGender.setText(result.gender);
            textViewSpecies.setText(result.species);
            textViewStatus.setText(result.status);

            if(result.type.equals("")){
                textViewType.setVisibility(View.GONE);
            }
            textViewType.setText(result.type);

            Glide.with(itemView)
                    .load(result.image)
                    .into(imageViewProfile);
        }
    }



}
