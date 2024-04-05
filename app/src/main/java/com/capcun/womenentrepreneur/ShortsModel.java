package com.capcun.womenentrepreneur;

public class ShortsModel {

    String videoUrl;
    int profile;
    String name,desc;

    public ShortsModel(String videoUrl, int profile, String name, String desc) {
        this.videoUrl = videoUrl;
        this.profile = profile;
        this.name = name;
        this.desc = desc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
