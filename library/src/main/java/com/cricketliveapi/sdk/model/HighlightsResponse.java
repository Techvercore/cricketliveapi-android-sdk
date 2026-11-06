package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HighlightsResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("total")      public int             total;
        @SerializedName("highlights") public List<Highlight> highlights;
    }

    public static class Highlight {
        @SerializedName("over")     public double over;
        @SerializedName("event")    public String event;
        @SerializedName("bat_team") public String batTeam;
        @SerializedName("batsman")  public String batsman;
        @SerializedName("bowler")   public String bowler;
        @SerializedName("text")     public String text;
        @SerializedName("runs")     public int    runs;
    }
}