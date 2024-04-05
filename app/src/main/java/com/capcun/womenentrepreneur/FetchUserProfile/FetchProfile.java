package com.capcun.womenentrepreneur.FetchUserProfile;

public class FetchProfile {

    String user_id,user_name,email,phone,first_name,last_name,country,region,job_title,school_college_university,start_year,end_year,bio,user_type;

    public FetchProfile(String user_id, String user_name, String email, String phone, String first_name, String last_name, String country, String region, String job_title, String school_college_university, String start_year, String end_year, String bio, String user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country = country;
        this.region = region;
        this.job_title = job_title;
        this.school_college_university = school_college_university;
        this.start_year = start_year;
        this.end_year = end_year;
        this.bio = bio;
        this.user_type = user_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getSchool_college_university() {
        return school_college_university;
    }

    public void setSchool_college_university(String school_college_university) {
        this.school_college_university = school_college_university;
    }

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    public String getEnd_year() {
        return end_year;
    }

    public void setEnd_year(String end_year) {
        this.end_year = end_year;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
