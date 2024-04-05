package com.capcun.womenentrepreneur;


//public class package com.capcun.womenentrepreneur.FetchUserProfile;

public class InvestorModel {

    private int userId;
    private String userName;
    private String email;
    private int emailStatus;
    private String password;
    private String profileImg;
    private String phone;
    private String firstName;
    private String lastName;
    private String country;
    private String region;
    private String jobTitle;
    private String schoolCollegeUniversity;
    private int startYear;
    private int endYear;
    private int age;
    private String bio;
    private String registrationDate;
    private boolean meetupRegistered;
    private String userType;
    private String following;
    private String interestedDomain;
    private String interestedSubdomain;
    private String feedInterest;

    public InvestorModel(int userId, String userName, String email, int emailStatus, String password, String profileImg, String phone, String firstName, String lastName, String country, String region, String jobTitle, String schoolCollegeUniversity, int startYear, int endYear, int age, String bio, String registrationDate, boolean meetupRegistered, String userType, String following, String interestedDomain, String interestedSubdomain, String feedInterest) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.emailStatus = emailStatus;
        this.password = password;
        this.profileImg = profileImg;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.region = region;
        this.jobTitle = jobTitle;
        this.schoolCollegeUniversity = schoolCollegeUniversity;
        this.startYear = startYear;
        this.endYear = endYear;
        this.age = age;
        this.bio = bio;
        this.registrationDate = registrationDate;
        this.meetupRegistered = meetupRegistered;
        this.userType = userType;
        this.following = following;
        this.interestedDomain = interestedDomain;
        this.interestedSubdomain = interestedSubdomain;
        this.feedInterest = feedInterest;
    }

    // Getters and setters for all fields

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(int emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSchoolCollegeUniversity() {
        return schoolCollegeUniversity;
    }

    public void setSchoolCollegeUniversity(String schoolCollegeUniversity) {
        this.schoolCollegeUniversity = schoolCollegeUniversity;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isMeetupRegistered() {
        return meetupRegistered;
    }

    public void setMeetupRegistered(boolean meetupRegistered) {
        this.meetupRegistered = meetupRegistered;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getInterestedDomain() {
        return interestedDomain;
    }

    public void setInterestedDomain(String interestedDomain) {
        this.interestedDomain = interestedDomain;
    }

    public String getInterestedSubdomain() {
        return interestedSubdomain;
    }

    public void setInterestedSubdomain(String interestedSubdomain) {
        this.interestedSubdomain = interestedSubdomain;
    }

    public String getFeedInterest() {
        return feedInterest;
    }

    public void setFeedInterest(String feedInterest) {
        this.feedInterest = feedInterest;
    }

    public String getFirst_name() {
        return firstName;
    }


    public String getLast_name() {
        return lastName;
    }

}