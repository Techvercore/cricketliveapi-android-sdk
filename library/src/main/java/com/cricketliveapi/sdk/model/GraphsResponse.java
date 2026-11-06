package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GraphsResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("matchId")            public long            matchId;
        @SerializedName("team1Name")          public String          team1Name;
        @SerializedName("team2Name")          public String          team2Name;
        @SerializedName("runsChartData")      public List<OverPoint> runsChartData;
        @SerializedName("runRateChartData")   public List<OverPoint> runRateChartData;
        @SerializedName("runsPerOverData")    public List<OverPoint> runsPerOverData;
        @SerializedName("winProbability")     public Object          winProbability;
    }

    public static class OverPoint {
        @SerializedName("over")           public double  over;
        @SerializedName("team1")          public double  team1;
        @SerializedName("team2")          public double  team2;
        @SerializedName("isTeam1Wicket")  public boolean isTeam1Wicket;
        @SerializedName("isTeam2Wicket")  public boolean isTeam2Wicket;
    }
}