package com.ian.desson.model;

import java.io.Serializable;

public class Video implements Serializable {

    private String videoUrl;

    public Video() {
        videoUrl = null;
    }

    public Video(String url) {
        videoUrl = url;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String url) {
        videoUrl = url;
    }
}
