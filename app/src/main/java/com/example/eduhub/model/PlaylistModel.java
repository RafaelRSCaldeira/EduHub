package com.example.eduhub.model;

import java.util.List;

public class PlaylistModel {
    private int id;
    private String title;
    private String thumbnail;
    private String data;
    private List<String> tags;
    private String url;
    private List<VideoModel> videos;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getData() {
        return data;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public List<VideoModel> getVideos() {
        return videos;
    }
}
