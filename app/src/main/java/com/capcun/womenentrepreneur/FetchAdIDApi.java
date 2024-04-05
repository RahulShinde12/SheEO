package com.capcun.womenentrepreneur;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FetchAdIDApi {



    @FormUrlEncoded
    @POST("ImageStore.php")
    Call<String> fetchSubBusinessId(
            @Field("id") int id,
            @Field("title") String title,
            @Field("desc") String desc,
            @Field("hashtag") String hashtag,
            @Field("img") String img


    );

    @FormUrlEncoded
    @POST("add_post.php")
    Call<String> addpost(
            @Field("id") int id,
            @Field("title") String title,
            @Field("desc") String desc,
            @Field("hashtag") String hashtag


    );

    @FormUrlEncoded
    @POST("getInvestor.php")
    Call<List<InvestorModel>> fetchinvestor(
            @Field("id") String id


    );


    @FormUrlEncoded
    @POST("getUser.php")
    Call<InvestorModel> getusers(
            @Field("id") String id


    );




    @FormUrlEncoded
    @POST("getMentors.php")
    Call<List<InvestorModel>> fetchmentor(
            @Field("id") String id


    );


    @FormUrlEncoded
    @POST("setConnectionRequest.php")
    Call<String> sendconnectiontoInvestor(
            @Field("user_id") String id_user,
            @Field("receiver_id") String id_investor,
            @Field("desc") String desc


    );

    @FormUrlEncoded
    @POST("getConnectionRequests.php")
    Call<List<InvestorModel>> fetchConnectionRequest(
            @Field("user_id") String id_user


    );


    @FormUrlEncoded
    @POST("cancelConnectionRequest.php")
    Call<String> cancelConnectionRequest(
            @Field("user_id") String id_user,
            @Field("receiver_id") String id_investor

    );


    @FormUrlEncoded
    @POST("okConncetionRequest.php")
    Call<String> okConnectionRequest(
            @Field("user_id") String id_user,
            @Field("receiver_id") String id_investor

    );






}
