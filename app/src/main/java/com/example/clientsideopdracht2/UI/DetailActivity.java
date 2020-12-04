package com.example.clientsideopdracht2.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.example.clientsideopdracht2.DetailAdapter;
import com.example.clientsideopdracht2.HUE_Lamp;
import com.example.clientsideopdracht2.Logic.Api_Manager;
import com.example.clientsideopdracht2.Logic.HUE_Listener;
import com.example.clientsideopdracht2.R;

import java.util.Random;

public class DetailActivity extends AppCompatActivity implements HUE_Listener {
    private static final String tag = DetailActivity.class.getSimpleName();
    public static final String EXTRA_HUE = "Hue_extra";

    private Api_Manager api;

    private RecyclerView recyclerView;
    private HUE_Lamp lamp;
    private DetailAdapter adapter;

    private Button button;
    private SwitchCompat lightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.lamp = (HUE_Lamp) getIntent().getSerializableExtra(EXTRA_HUE);

        this.recyclerView = findViewById(R.id.detailRecycler);
        this.adapter = new DetailAdapter(this, lamp);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.colourPickerButton);
        lightSwitch = findViewById(R.id.activationSwitch);

        this.api = new Api_Manager(this, this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(v);
            }
        });
        lightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckChanged(buttonView, isChecked);
            }
        });

    }


    public void onItemClick(View v) {
        Log.i(tag, "weeeeeeeeeeeeeeeeeeeee onItemClick");
        int hue = new Random().nextInt();
        api.changeColor(lamp.getId() ,56536);
    }


    public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
        Log.i(tag, "weeeeeeeeeeeeeeeeeeeee oncheckChanged");
        api.changeOnOff(lamp.getId(), isChecked);
    }


    @Override
    public void onHUEAvailable(HUE_Lamp lamp) {

    }

    @Override
    public void onHUEError(Error error) {

    }
}