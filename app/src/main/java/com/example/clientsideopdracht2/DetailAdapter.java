package com.example.clientsideopdracht2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {
    private static final String tag = DetailAdapter.class.getSimpleName();


    private Context context;
    private HUE_Lamp lamp;
    private OnItemClickListener itemClickListener;
    private List<String> lampStats;

    public DetailAdapter(Context context, HUE_Lamp lamp, OnItemClickListener itemClickListener){
        this.context = context;
        this.lamp = lamp;
        this.itemClickListener = itemClickListener;

        lampStats.add("on: " + lamp.getOn().toString());
        lampStats.add("Brightness: " + lamp.getBri().toString());
        lampStats.add("Hue: " + lamp.getHue().toString());
        lampStats.add("Saturation: " + lamp.getSat().toString());
        lampStats.add("Effect: " + lamp.getEffect());
        lampStats.add("XY: " + lamp.getXy().toString());
        lampStats.add("Mired colour temperature: " + lamp.getCt().toString());
        lampStats.add("Alert: " + lamp.getAlert());
        lampStats.add("Colour mode: " + lamp.getColormode());
        lampStats.add("Mode: " + lamp.getMode());
        lampStats.add("Reachable: " + lamp.getReachable().toString());
    }

    class DetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public DetailHolder(View itemview, DetailAdapter adapter){
            super(itemview);
            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPostition = getAdapterPosition();
            Log.i(tag, "item: " + clickedPostition + " was clicked");
            itemClickListener.onItemClick(clickedPostition);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int clickedPosition);
    }

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(tag, "onCreateViewHolder() called");
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        DetailHolder detailHolder = new DetailHolder(itemview, this);
        return detailHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        Log.d(tag, "onBindViewHolder() called for item: " + position);
        String text = lampStats.get(position);
    }

    @Override
    public int getItemCount() {
        return lampStats.size();
    }




}
