package com.example.clientsideopdracht2.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.clientsideopdracht2.HUE_Adapter;
import com.example.clientsideopdracht2.HUE_Lamp;
import com.example.clientsideopdracht2.Logic.Api_Manager;
import com.example.clientsideopdracht2.Logic.HUE_Listener;
import com.example.clientsideopdracht2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HUE_Adapter.OnItemClickListener, HUE_Listener {
    private static final String tag = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private ArrayList<HUE_Lamp> lamps;
    private HUE_Adapter adapter;
    Api_Manager api_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lamps = new ArrayList<>();

        this.recyclerView = findViewById(R.id.Lamp_Recycler);
        this.adapter = new HUE_Adapter(this, lamps, this);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.api_manager = new Api_Manager(this, this);
        this.api_manager.getHUE_Data();
    }

    @Override
    public void onItemClick(int clickedPosition) {
        Log.i(tag, "onItemClick() called for position " + clickedPosition);
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra( , lamps.get(clickedPosition)); // finish this part
        startActivity(detailIntent);
    }

    @Override
    public void onHUEAvailable(HUE_Lamp lamp) {
        Log.i(tag, "onHUEAvailable() called");
        this.lamps.add(lamp);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void onHUEError(Error error) {
        Log.e(tag, "Error: " + error.toString());
    }
}