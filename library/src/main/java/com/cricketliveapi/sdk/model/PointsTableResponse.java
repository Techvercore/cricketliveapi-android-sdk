package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PointsTableResponse {
    @SerializedName("success") public boolean    success;
    @SerializedName("data")    public List<Team> data;

    public static class Team {
        @SerializedName("team_id")    public long   teamId;
        @SerializedName("team_name")  public String teamName;
        @SerializedName("team_short") public String teamShort;
        @SerializedName("matches")    public int    matches;
        @SerializedName("wins")       public int    wins;
        @SerializedName("losses")     public int    losses;
        @SerializedName("ties")       public int    ties;
        @SerializedName("no_result")  public int    noResult;
        @SerializedName("points")     public int    points;
        @SerializedName("nrr")        public double nrr;
    }
}