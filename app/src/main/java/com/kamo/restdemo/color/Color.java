package com.kamo.restdemo.color;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Jeffrey.Mphahlele on 1/20/2018.
 */

public class Color implements Serializable{
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private double id;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
