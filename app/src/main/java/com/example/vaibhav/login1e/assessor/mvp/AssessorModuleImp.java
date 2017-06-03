package com.example.vaibhav.login1e.assessor.mvp;

import android.util.Log;

import com.example.vaibhav.login1e.assessor.model.AssessorRegModel;
import com.example.vaibhav.login1e.common.AbstactModule;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.StateList;
import com.example.vaibhav.login1e.rest.RetroControler;
import com.google.gson.Gson;
import com.orm.SugarRecord;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by swapnilmeshram on 29/03/17.
 */

public class AssessorModuleImp extends AbstactModule implements AssessorMVP.AssessorModule {

    public static final String TAG = AssessorModuleImp.class.getSimpleName();
    private static final String GANESH = "ganeshganesh";
    Call<ResponseBody> call;

    @Override
    public void onSendToServer(RetroControler controler, AssessorRegModel data, final AssessorMVP.AssessorUploadModel listener, File photo, File resume) {

        RequestBody aadhar=getRequestBody(data.getAdahar());
        RequestBody name=getRequestBody(data.getName());
        RequestBody pan=getRequestBody(data.getPan());
        RequestBody mobileNo=getRequestBody(data.getMobileNumber());
        RequestBody password=getRequestBody(data.getPass());
        RequestBody state=getRequestBody(data.getState());
        RequestBody city=getRequestBody(data.getCity());
        RequestBody ganesh=getRequestBody(GANESH);
        MultipartBody.Part rPhoto = getPhotoRequest(photo);
        MultipartBody.Part rResume = getPhotoRequest(resume);
        call = controler.sendDataToServer(aadhar,name,pan,aadhar,mobileNo,password,state,city,ganesh,rPhoto,rResume);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG,"raw:"+new Gson().toJson(response.raw()));
                if (response.isSuccessful()) {
                    String resp="";
                    try {
                        resp = response.body().string();
                        int userId=Integer.parseInt(resp);
                        listener.onSuccessfulStore(String.valueOf(userId));
                        Log.d(TAG, "response:" + resp);
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                        if(e instanceof NumberFormatException){
                            listener.onStoreFail(resp);
                        }
                    }

                } else {
                    listener.onStoreFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                if (hasNoInternet(t)) {
                    listener.onNoInternetConnection();
                } else {
                    listener.onStoreFail(t.getMessage());
                }
            }
        });
    }

    private MultipartBody.Part getPhotoRequest(File photo) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), photo.getAbsolutePath());

        MultipartBody.Part multipartBody =MultipartBody.Part.createFormData("file",photo.getName(),requestFile);

        return multipartBody;
    }

    private RequestBody getRequestBody(String s) {
        MediaType stringType=MediaType.parse("text/plain");
        return RequestBody.create(stringType,s);
    }

    @Override
    public void onDistroy() {
        if (call != null && !call.isCanceled())
            call.cancel();
    }

    @Override
    public void prepareAllSpinners(AssessorMVP.AssessorUploadModel listener) {
        if(!SugarRecord.listAll(StateList.class).isEmpty()){
            listener.onStatelistAvailable(SugarRecord.listAll(StateList.class));
        }

    }

    @Override
    public void selectCityByStateId(String ids, AssessorMVP.AssessorUploadModel listener) {
        if(!SugarRecord.listAll(CitystateList.class).isEmpty()){
            listener.onCityListAvaliable(SugarRecord.find(CitystateList.class,"STATE_CODE=?",ids));
        }
    }
}
