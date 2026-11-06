package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OversResponse {
    @SerializedName("success") public boolean    success;
    @SerializedName("data")    public List<Over> data;

    public static class Over {
        @SerializedName("over_num")  public int         overNum;
        @SerializedName("runs")      public int         runs;
        @SerializedName("wickets")   public int         wickets;
        @SerializedName("balls")     public List<Ball>  balls;
    }

    public static class Ball {
        @SerializedName("ball_num")  public double ball;
        @SerializedName("runs")      public int    runs;
        @SerializedName("is_wicket") public boolean isWicket;
        @SerializedName("is_wide")   public boolean isWide;
        @SerializedName("is_no_ball") public boolean isNoBall;
        @SerializedName("text")      public String text;
    }
}