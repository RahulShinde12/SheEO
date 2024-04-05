package com.capcun.womenentrepreneur.fetchPosts;

public class FetchPostModel {

    String  post_id,sender_user_id,title,content_text,content_images,likes,comments,visibility,created_at,hashtag,user_name,job_title,user_type;

    public FetchPostModel(String post_id, String sender_user_id, String title, String content_text, String content_images, String likes, String comments, String visibility, String created_at, String hashtag, String user_name, String job_title, String user_type) {
        this.post_id = post_id;
        this.sender_user_id = sender_user_id;
        this.title = title;
        this.content_text = content_text;
        this.content_images = content_images;
        this.likes = likes;
        this.comments = comments;
        this.visibility = visibility;
        this.created_at = created_at;
        this.hashtag = hashtag;
        this.user_name = user_name;
        this.job_title = job_title;
        this.user_type = user_type;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getSender_user_id() {
        return sender_user_id;
    }

    public void setSender_user_id(String sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_images() {
        return content_images;
    }

    public void setContent_images(String content_images) {
        this.content_images = content_images;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
