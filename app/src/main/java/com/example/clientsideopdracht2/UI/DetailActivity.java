package com.example.clientsideopdracht2.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.clientsideopdracht2.DetailAdapter;
import com.example.clientsideopdracht2.HUE_Lamp;
import com.example.clientsideopdracht2.R;

public class DetailActivity extends AppCompatActivity implements DetailAdapter.OnItemClickListener{
    private static final String tag = DetailActivity.class.getSimpleName();
    public static final String EXTRA_HUE = "Hue_extra";

    private RecyclerView recyclerView;
    private HUE_Lamp lamp;
    private DetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.lamp = (HUE_Lamp) getIntent().getSerializableExtra(EXTRA_HUE);

        this.recyclerView = findViewById(R.id.detailRecycler);
        this.adapter = new DetailAdapter(this, lamp, this);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int clickedPosition) {
        Log.i(tag, "onItemClick() called for position: " + clickedPosition);
    }

}