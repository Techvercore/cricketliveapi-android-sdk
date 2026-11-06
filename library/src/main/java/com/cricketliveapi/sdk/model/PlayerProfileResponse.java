package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class PlayerProfileResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("player_id")       public long              playerId;
        @SerializedName("name")            public String            name;
        @SerializedName("bio")             public Map<String,String> bio;
        @SerializedName("batting_form")    public List<FormEntry>   battingForm;
        @SerializedName("bowling_form")    public List<FormEntry>   bowlingForm;
        @SerializedName("career_timeline") public List<Career>      careerTimeline;
    }

    public static class FormEntry {
        @SerializedName("score")  public String score;
        @SerializedName("oppn")   public String oppn;
        @SerializedName("format") public String format;
        @SerializedName("date")   public String date;
    }

    public static class Career {
        @SerializedName("format") public String format;
        @SerializedName("debut")  public String debut;
        @SerializedName("last")   public String last;
    }
}