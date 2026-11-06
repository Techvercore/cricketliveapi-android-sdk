package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WtcPointsTableResponse {
    @SerializedName("success") public boolean    success;
    @SerializedName("data")    public List<Team> data;

    public static class Team {
        @SerializedName("team_id")    public long   teamId;
        @SerializedName("team_name")  public String teamName;
        @SerializedName("team_short") public String teamShort;
        @SerializedName("matches")    public int    matches;
        @SerializedName("wins")       public int    wins;
        @SerializedName("losses")     public int    losses;
        @SerializedName("draws")      public int    draws;
        @SerializedName("points")     public int    points;
        @SerializedName("pct")        public double pct;
    }
}