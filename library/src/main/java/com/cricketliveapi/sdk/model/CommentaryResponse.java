package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CommentaryResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("match_id")   public long              matchId;
        @SerializedName("miniscore")  public Miniscore         miniscore;
        @SerializedName("commentary") public List<Commentary>  commentary;
    }

    public static class Miniscore {
        @SerializedName("bat_team_score")   public int    batTeamScore;
        @SerializedName("bat_team_wickets") public int    batTeamWickets;
        @SerializedName("overs")            public double overs;
        @SerializedName("target")           public int    target;
        @SerializedName("status")           public String status;
    }

    public static class Commentary {
        @SerializedName("text")       public String text;
        @SerializedName("innings_id") public int    inningsId;
        @SerializedName("over")       public double over;
        @SerializedName("runs")       public int    runs;
        @SerializedName("is_wicket")  public boolean isWicket;
    }
}