package com.example.eduhub.model;

import java.util.List;

public class VideoModel {
    private String id;
    private String title;
    private String thumbnail;
    private String publishedAt;
    private List<String> tags;
    private String url;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }
}
