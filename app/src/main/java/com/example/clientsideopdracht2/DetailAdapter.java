package com.example.clientsideopdracht2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
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
        this.lampStats = new ArrayList<>();

        Log.d(tag, lamp.getState().getOn().toString());

        lampStats.add("on: " + lamp.getState().getOn().toString());
        lampStats.add("Brightness: " + lamp.getState().getBri().toString());
        lampStats.add("Hue: " + lamp.getState().getHue().toString());
        lampStats.add("Saturation: " + lamp.getState().getSat().toString());
        lampStats.add("Effect: " + lamp.getState().getEffect());
        //lampStats.add("XY: " + lamp.getState().getXy().toString());
        lampStats.add("Mired colour temperature: " + lamp.getState().getCt().toString());
        lampStats.add("Alert: " + lamp.getState().getAlert());
        lampStats.add("Colour mode: " + lamp.getState().getColormode());
        lampStats.add("Reachable: " + lamp.getState().getReachable().toString());
    }

    class DetailHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView detailTextView;

        public DetailHolder(View itemview, DetailAdapter adapter){
            super(itemview);
            itemview.setOnClickListener(this);
            this.detailTextView = itemview.findViewById(R.id.detailTextView);
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
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_item, parent, false);
        DetailHolder detailHolder = new DetailHolder(itemview, this);
        return detailHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        Log.d(tag, "onBindViewHolder() called for item: " + position);
        String text = lampStats.get(position);
        holder.detailTextView.setText(text);
    }

    @Override
    public int getItemCount() {
        return lampStats.size();
    }




}
