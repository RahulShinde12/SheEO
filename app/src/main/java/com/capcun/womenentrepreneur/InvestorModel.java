package com.capcun.womenentrepreneur;

//public class package com.capcun.womenentrepreneur.FetchUserProfile;

public class InvestorModel {
    private String user_id;
    private String user_name;
    private String email;
    private String email_status;
    private String password;
    private String profile_img;
    private String phone;
    private String first_name;
    private String last_name;
    private String country;
    private String region;
    private String job_title;
    private String school_college_university;
    private String start_year;
    private String end_year;
    private String age;
    private String bio;
    private String registration_date;
    private String meetup_registered;
    private String user_type;
    private String following;
    private String interested_domain;
    private String interested_subdomain;
    private String feed_interest;

    public InvestorModel() {

    }



    public String getFirst_name() {
        return first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public InvestorModel(String user_id, String user_name, String email, String email_status, String password,
                         String profile_img, String phone, String first_name, String last_name, String country,
                         String region, String job_title, String school_college_university, String start_year,
                         String end_year, String age, String bio, String registration_date, String meetup_registered,
                         String user_type, String following, String interested_domain, String interested_subdomain,
                         String feed_interest) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.email_status = email_status;
        this.password = password;
        this.profile_img = profile_img;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country = country;
        this.region = region;
        this.job_title = job_title;
        this.school_college_university = school_college_university;
        this.start_year = start_year;
        this.end_year = end_year;
        this.age = age;
        this.bio = bio;
        this.registration_date = registration_date;
        this.meetup_registered = meetup_registered;
        this.user_type = user_type;
        this.following = following;
        this.interested_domain = interested_domain;
        this.interested_subdomain = interested_subdomain;
        this.feed_interest = feed_interest;
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

    public String getEmail_status() {
        return email_status;
    }

    public void setEmail_status(String email_status) {
        this.email_status = email_status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getMeetup_registered() {
        return meetup_registered;
    }

    public void setMeetup_registered(String meetup_registered) {
        this.meetup_registered = meetup_registered;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getInterested_domain() {
        return interested_domain;
    }

    public void setInterested_domain(String interested_domain) {
        this.interested_domain = interested_domain;
    }

    public String getInterested_subdomain() {
        return interested_subdomain;
    }

    public void setInterested_subdomain(String interested_subdomain) {
        this.interested_subdomain = interested_subdomain;
    }

    public String getFeed_interest() {
        return feed_interest;
    }

    public void setFeed_interest(String feed_interest) {
        this.feed_interest = feed_interest;
    }
}