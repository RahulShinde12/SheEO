package com.capcun.womenentrepreneur;


import android.util.Log;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MentorMapping {

    // Function to extract keywords from bio
    private static List<String> extractKeywords(String bio) {
        // Splitting the bio into words
        String[] words = bio.split("\\s+");
        List<String> keywords = new ArrayList<>();
        // Adding non-trivial words to keywords list
        for (String word : words) {
            if (word.length() > 3) {
                keywords.add(word.toLowerCase());
            }
        }
        return keywords;
    }

    // Function to check if two lists share any common element
    private static boolean hasCommonElement(List<String> list1, List<String> list2) {
        for (String element : list1) {
            if (list2.contains(element)) {
                return true;
            }
        }
        return false;
    }

    // Function to find mentors based on interest domain, subdomain, and bio
    public static List<Integer> findMentors(int id, String interestDomains, String interestSubdomains, String bio, JSONArray users) throws JSONException {
        List<Integer> mentorIds = new ArrayList<>();

        // Extract keywords from bio
        List<String> bioKeywords = extractKeywords(bio);

        // Splitting CSV strings into lists
        List<String> domains = Arrays.asList(interestDomains.split(", "));
        List<String> subdomains = Arrays.asList(interestSubdomains.split(", "));

        Log.d("nait", "Domains: " + domains);
        Log.d("nait", "Subdomains: " + subdomains);

        Log.d("nait", "users: " + users);

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            int userId = user.getInt("user_id");
            if (userId != id) { // Exclude the current user
                String userType = user.getString("user_type");
                String userInterestDomains = user.getString("interested_domain");
                String userInterestSubdomains = user.getString("interested_subdomain");
                String userBio = user.getString("bio");

                // Check if the user matches the criteria
                if (userType.equals("investor") || userType.equals("entrepreneur") || userType.equals("student")) {
                    List<String> userDomains = Arrays.asList(userInterestDomains.split(", "));
                    List<String> userSubdomains = Arrays.asList(userInterestSubdomains.split(", "));
                    if (hasCommonElement(domains, userDomains) &&
                            hasCommonElement(subdomains, userSubdomains) &&
                            hasCommonElement(bioKeywords, extractKeywords(userBio))) {
                        mentorIds.add(userId);
                    }
                }
            }
        }

        return mentorIds;
    }

//    public static void main(String[] args) {
//        // Sample usage
//        JSONArray userData = new JSONArray(/* Your JSON data here */);
//        int studentId = 1; // Example student ID
//        String interestDomains = "Technology, Retail and E-commerce";
//        String interestSubdomains = "Software Development, E-commerce Marketing";
//        String studentBio = "Passionate about coding and building innovative software solutions.";
//
//        List<Integer> mentors = findMentors(studentId, interestDomains, interestSubdomains, studentBio, userData);
//        System.out.println("Mentors for the student:");
//        for (int mentorId : mentors) {
//            System.out.println("Mentor ID: " + mentorId);
//        }
//    }


    public static InvestorModel getUserById(JSONArray jsonArray, String userId) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject userObject = jsonArray.getJSONObject(i);
                InvestorModel userModel = new InvestorModel();
                try {
                    userModel.setUser_id(userObject.getString("user_id"));
                    userModel.setUser_name(userObject.getString("user_name"));
                    userModel.setEmail(userObject.getString("email"));
                    userModel.setPassword(userObject.getString("password"));
                    userModel.setProfile_img(userObject.getString("profile_img"));
                    userModel.setPhone(userObject.getString("phone"));
                    userModel.setFirst_name(userObject.getString("first_name"));
                    userModel.setLast_name(userObject.getString("last_name"));
                    userModel.setCountry(userObject.getString("country"));
                    userModel.setJob_title(userObject.getString("job_title"));
                    userModel.setSchool_college_university(userObject.getString("school_college_university"));
                    userModel.setStart_year(userObject.getInt("start_year")+"");
                    userModel.setEnd_year(userObject.getInt("end_year")+"");
                    userModel.setAge(userObject.getInt("age")+"");
                    userModel.setBio(userObject.getString("bio"));
                    userModel.setRegistration_date(userObject.getString("registration_date"));
                    userModel.setMeetup_registered(userObject.getBoolean("meetup_registered")+"");
                    userModel.setUser_type(userObject.getString("user_type"));
                    userModel.setFollowing(userObject.getString("following"));
                    userModel.setInterested_domain(userObject.getString("interested_domain"));
                    userModel.setInterested_subdomain(userObject.getString("interested_subdomain"));
                    userModel.setFeed_interest(userObject.getString("feed_interest"));
                    // Parse and set other attributes similarly
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null; // Return null if parsing fails
                }
                String currentUserId = userObject.optString("user_id");

                if (currentUserId.equals(userId)) {
                    return userModel;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null; // User not found
    }


    public static List<InvestorModel> findMentors(int id, String interestDomains, String interestSubdomains, String bio, List<InvestorModel> users) {
        List<InvestorModel> mentorUsers = new ArrayList<>();

        // Extract keywords from bio
        List<String> bioKeywords = extractKeywords(bio);

        // Splitting CSV strings into lists
        List<String> domains = Arrays.asList(interestDomains.split(", "));
        List<String> subdomains = Arrays.asList(interestSubdomains.split(", "));

        for (InvestorModel user : users) {
            String userId = user.getUser_id(); // Assuming user_id is stored as String
            if (!userId.equals(String.valueOf(id))) { // Exclude the current user
                String userType = user.getUser_type();
                String userInterestDomains = user.getInterested_domain();
                String userInterestSubdomains = user.getInterested_subdomain();
                String userBio = user.getBio();

                // Check if the user matches the criteria
                if (userType.equals("investor") || userType.equals("entrepreneur") || userType.equals("student")) {
                    List<String> userDomains = Arrays.asList(userInterestDomains.split(", "));
                    List<String> userSubdomains = Arrays.asList(userInterestSubdomains.split(", "));
                    if (hasCommonElement(domains, userDomains) &&
                            hasCommonElement(subdomains, userSubdomains) &&
                            hasCommonElement(bioKeywords, extractKeywords(userBio))) {
                        mentorUsers.add(user);
                    }
                }
            }
        }

        return mentorUsers;
    }

}