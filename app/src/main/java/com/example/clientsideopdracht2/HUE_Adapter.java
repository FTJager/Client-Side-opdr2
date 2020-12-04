package com.example.clientsideopdracht2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HUE_Adapter extends RecyclerView.Adapter<HUE_Adapter.LampHolder> {
    private static final String tag = HUE_Adapter.class.getSimpleName();

    private Context context;
    private List<HUE_Lamp> lamps;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int clickedPosition);
    }

    class LampHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView LampImageView;
        public final TextView lampTextView;

        public LampHolder (View itemView, HUE_Adapter adapter){
            super(itemView);
            LampImageView = itemView.findViewById(R.id.LampImageView);
            lampTextView = itemView.findViewById(R.id.LampTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPostition = getAdapterPosition();
            Log.i(tag, "item: " + clickedPostition + " was clicked");
            itemClickListener.onItemClick(clickedPostition);
        }
    }

    public HUE_Adapter(Context context, List<HUE_Lamp> lamps, OnItemClickListener itemClickListener) {
        this.context = context;
        this.lamps = lamps;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LampHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(tag, "onCreateViewHolder() called");
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        LampHolder lampHolder = new LampHolder(itemview, this);
        return lampHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LampHolder holder, int position) {
        Log.d(tag, "onBindViewHolder() called for item: " + position);
        HUE_Lamp lamp = lamps.get(position);
            if(lamp.getName() != null) {
              holder.lampTextView.setText(lamp.getName());
            }else{
            Log.d(tag, lamp.getName());
            }
        }

    @Override
    public int getItemCount() {
        return lamps.size();
    }
}
