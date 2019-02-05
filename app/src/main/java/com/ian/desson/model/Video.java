package com.ian.desson.model;

import java.io.Serializable;

public class Video implements Serializable {

    private String videoId;

    public Video() {
        videoId = null;
    }

    public Video(String id) {
        videoId = id;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String id) {
        videoId = id;
    }
}
