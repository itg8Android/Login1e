package com.example.vaibhav.login1e.assessor.mvp;

import android.content.Context;
import android.widget.EditText;

import com.example.vaibhav.login1e.assessor.model.AssessorRegModel;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.StateList;
import com.example.vaibhav.login1e.rest.RetroControler;

import java.io.File;
import java.util.List;

/**
 * Created by swapnilmeshram on 29/03/17.
 */

public class AssessorMVP {
    public interface AssessorView{
        void onValidationFail(EditText editText);
        void onMobileNUmberInvalid(EditText editText);
        void onPasswordValidateFail(EditText editText);
        void onPincodeNotValid(EditText editText);

        void onSuccessfulRegister(String id);

        void onUnSuccessfulCall(String error);

        void onNoInternetConnection();

        void prepareModelClass();

        void onStatelistAvailable(List<StateList> stateLists);

        void onCityListAvailable(List<CitystateList> citystateLists);
    }
    public interface AssessorPresenter{
        void onStoreToDB(AssessorRegModel model, Context baseContext,File photo, File resume);
        void onValidateFields(AssessorRegModel model);
        boolean onMobileNumbervalidate(EditText editText);
        boolean onEmailValidate(EditText editText);
        boolean onValidate(EditText... editTexts);

        void onDistroy();

        void prepareSpinner();

        void initCityByStateId(String ids);
    }

    public interface AssessorUploadModel{
        void onSuccessfulStore(String id);
        void onStoreFail(String error);
        void onNoInternetConnection();

        void onStatelistAvailable(List<StateList> stateLists);

        void onCityListAvaliable(List<CitystateList> citystateLists);
    }
    public interface AssessorModule{
        void onSendToServer(RetroControler controler, AssessorRegModel data, AssessorUploadModel model, File photo, File resume);

        void onDistroy();

        void prepareAllSpinners(AssessorUploadModel listener);

        void selectCityByStateId(String ids, AssessorUploadModel listener);
    }
}
