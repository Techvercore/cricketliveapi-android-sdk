package com.cricketliveapi.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SeriesArchiveApiResponse {
    @SerializedName("success") public boolean      success;
    @SerializedName("year")    public int          year;
    @SerializedName("total")   public int          total;
    @SerializedName("data")    public List<Series> data;

    public static class Series {
        @SerializedName("id")         public long   id;
        @SerializedName("name")       public String name;
        @SerializedName("start_date") public String startDate;
        @SerializedName("end_date")   public String endDate;
        @SerializedName("category")   public String category;
    }
}