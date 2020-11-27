package com.example.clientsideopdracht2.Logic;

import com.example.clientsideopdracht2.HUE_Lamp;

public interface HUE_Listener {
    public void onHUEAvailable(HUE_Lamp lamp);
    public void onHUEError(Error error);
}
