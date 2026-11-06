package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ScorecardResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("match_id") public long         matchId;
        @SerializedName("innings")  public List<Innings> innings;
    }

    public static class Innings {
        @SerializedName("bat_team")       public String        batTeam;
        @SerializedName("bat_team_short") public String        batTeamShort;
        @SerializedName("bowl_team")      public String        bowlTeam;
        @SerializedName("score")          public String        score;
        @SerializedName("run_rate")       public double        runRate;
        @SerializedName("batsmen")        public List<Batsman> batsmen;
        @SerializedName("bowlers")        public List<Bowler>  bowlers;
        @SerializedName("extras_detail")  public Extras        extrasDetail;
        @SerializedName("fall_of_wickets") public List<Fow>   fallOfWickets;
    }

    public static class Batsman {
        @SerializedName("player_id") public long   playerId;
        @SerializedName("name")      public String name;
        @SerializedName("runs")      public int    runs;
        @SerializedName("balls")     public int    balls;
        @SerializedName("fours")     public int    fours;
        @SerializedName("sixes")     public int    sixes;
        @SerializedName("strike_rate") public double strikeRate;
        @SerializedName("out_desc")  public String outDesc;
    }

    public static class Bowler {
        @SerializedName("player_id") public long   playerId;
        @SerializedName("name")      public String name;
        @SerializedName("overs")     public double overs;
        @SerializedName("runs")      public int    runs;
        @SerializedName("wickets")   public int    wickets;
        @SerializedName("economy")   public double economy;
        @SerializedName("maidens")   public int    maidens;
    }

    public static class Extras {
        @SerializedName("total")    public int total;
        @SerializedName("byes")     public int byes;
        @SerializedName("leg_byes") public int legByes;
        @SerializedName("wides")    public int wides;
        @SerializedName("no_balls") public int noBalls;
    }

    public static class Fow {
        @SerializedName("wkt_num") public int    wktNum;
        @SerializedName("player")  public String player;
        @SerializedName("runs")    public int    runs;
        @SerializedName("over")    public double over;
    }
}