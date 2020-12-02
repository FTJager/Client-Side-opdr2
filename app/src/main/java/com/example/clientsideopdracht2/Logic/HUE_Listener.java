package com.example.clientsideopdracht2.Logic;

import com.example.clientsideopdracht2.HUE_Lamp;

public interface HUE_Listener {
    void onHUEAvailable(HUE_Lamp lamp);
    void onHUEError(Error error);
}
