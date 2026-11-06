package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeriesResponse {
    @SerializedName("success") public boolean success;
    @SerializedName("data")    public Data    data;

    public static class Data {
        @SerializedName("category") public String        category;
        @SerializedName("total")    public int           total;
        @SerializedName("months")   public List<Month>   months;
    }

    public static class Month {
        @SerializedName("month")  public String        month;
        @SerializedName("series") public List<Series>  series;
    }

    public static class Series {
        @SerializedName("id")         public long   id;
        @SerializedName("name")       public String name;
        @SerializedName("start_date") public String startDate;
        @SerializedName("end_date")   public String endDate;
    }
}