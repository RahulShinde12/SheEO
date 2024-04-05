package com.capcun.womenentrepreneur.fetchPosts;

import com.capcun.womenentrepreneur.Chat.msgModelclass;
import com.capcun.womenentrepreneur.DataLeadsNew;
import com.capcun.womenentrepreneur.FetchProfile2;
import com.capcun.womenentrepreneur.FetchUserProfile.FetchProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface fetchAllPosts {


    @GET("getAllPosts.php")
    Call <List<FetchPostModel>> fetchPost();

    @FormUrlEncoded
    @POST("getFollowingsDash.php")
    Call<String> fetchFollow(
            @Field("id") String user_id
    );

    @FormUrlEncoded
    @POST("getUser.php")
    Call<FetchProfile> fetchData(
            @Field("id") String user_id

    );

    @FormUrlEncoded
    @POST("fetch_msg.php")
    Call<List<msgModelclass>>fetchChat(
            @Field("send") String send,
            @Field("rev") String rev
    );

    @FormUrlEncoded
    @POST("store_msg.php")
    Call<String> sendMsg(
            @Field("send") String number,
            @Field("rev") String rev_user_id,
            @Field("msg") String msg
    );


    @FormUrlEncoded
    @POST("getFollowing.php")
    Call<List<FetchProfile2>> fetchFollowing(
            @Field("id") String user_id

    );

    @FormUrlEncoded
    @POST("doFollow.php")
    Call<String> doFollow(
            @Field("own_id") String own_id,
            @Field("follow_id") String follow_id

    );
}
