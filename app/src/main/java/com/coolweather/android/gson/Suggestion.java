package com.coolweather.android.gson;

import android.media.SoundPool;

import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("comf")
    public Comforf comforf;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comforf{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
