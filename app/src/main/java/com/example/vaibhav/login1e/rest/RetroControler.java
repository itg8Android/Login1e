package com.example.vaibhav.login1e.rest;

import com.example.vaibhav.login1e.dashboard.model.AllSpinnerDatum;
import com.example.vaibhav.login1e.login.model.LoginModel;
import com.example.vaibhav.login1e.login.model.ResponseLoginModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by vaibhav on 28/2/17.
 */
public interface RetroControler {

//    assLogin[username]:bholeramdddafa
//    assLogin[password]:bholeram

    @FormUrlEncoded
    @POST("lastmile/assesoradmin/classes/classesapp/login.php")
    Call<ResponseBody> login(@Field("assLogin[username]") String username,
                             @Field("assLogin[password]") String password);

    @GET("/lastmile/restassesor/index.php")
    Call<List<AllSpinnerDatum>> allSpinnerData();


//    addAssessorMaster[assesor_name]:nirbhaynaglenew
//    addAssessorMaster[aadharno]:1258
//    applicationType[app]:ganeshganesh
//    addAssessor[username]:bholeramdddafa
//    addAssessor[panNo]:bholeram
//    addAssessor2[contact]:bholeram
//    addAssessor[assesorPass]:bholeram
//    addAssessor2[state]:bholeram
//    addAssessor2[city]:bholeram

    @Multipart
    @POST("lastmile/assesoradmin/classes/classesapp/registerApp.php")
    Call<ResponseBody> sendDataToServer(@Part("addAssessor[username]") RequestBody username,
                                        @Part("addAssessorMaster[assesor_name]") RequestBody ass_name,
                                        @Part("addAssessor[panNo]") RequestBody panNo,
                                        @Part("addAssessor[aadharno]") RequestBody adarNo,
                                        @Part("addAssessor2[contact]") RequestBody contact,
                                        @Part("addAssessor2[assesorPass]") RequestBody assessorPass,
                                        @Part("addAssessor2[state]") RequestBody state,
                                        @Part("addAssessor2[city]") RequestBody city,
                                        @Part("applicationType[app]") RequestBody ganesh,
                                        @Part("photoDoc[0]") MultipartBody.Part photo,
                                        @Part("assResume[0]") MultipartBody.Part resume);


}
