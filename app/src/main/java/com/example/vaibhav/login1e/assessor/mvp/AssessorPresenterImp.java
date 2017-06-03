package com.example.vaibhav.login1e.assessor.mvp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.vaibhav.login1e.assessor.model.AssessorRegModel;
import com.example.vaibhav.login1e.common.CommomMethod;
import com.example.vaibhav.login1e.common.Presenter;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.StateList;

import java.io.File;
import java.util.List;

/**
 * Created by swapnilmeshram on 29/03/17.
 */

public class AssessorPresenterImp extends Presenter implements AssessorMVP.AssessorPresenter,AssessorMVP.AssessorUploadModel {


    private AssessorMVP.AssessorView view;
    private boolean dontSendToServer;
    AssessorMVP.AssessorModule module;
    private boolean mobileValidate;
    private boolean emailValidate;

    public AssessorPresenterImp(AssessorMVP.AssessorView view) {
        this.view = view;
        module=new AssessorModuleImp();
    }

    @Override
    public void onStoreToDB(AssessorRegModel model, Context context,File photo, File resume) {
        module.onSendToServer(CommomMethod.getController(context),model,this,photo,resume);
    }

    @Override
    public void onValidateFields(AssessorRegModel model) {

    }

    @Override
    public boolean onMobileNumbervalidate(EditText editText) {
        if(!TextUtils.isEmpty(editText.getText().toString()) && editText.getText().toString().length()!=10){
            mobileValidate=false;
            if(hasView(view)){
                view.onMobileNUmberInvalid(editText);
                return false;
            }
        }else {
            return true;
        }
        return false;
    }

    @Override
    public boolean onEmailValidate(EditText editText) {
        return isValidEmail(editText.getText().toString());
    }

     static boolean isValidEmail(CharSequence target) {
         return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
     }

    @Override
    public boolean onValidate(EditText... editTexts) {
        boolean valid=true;
        for(int i=0;i<editTexts.length; i++){
            if (TextUtils.isEmpty(editTexts[i].getText().toString()))
                if(view!=null)
                    {
                        view.onValidationFail(editTexts[i]);
                        valid=false;
                    }

        }
       return valid;
    }

    @Override
    public void onDistroy() {
        module.onDistroy();
    }

    @Override
    public void prepareSpinner() {
        module.prepareAllSpinners(this);
    }

    @Override
    public void onSuccessfulStore(String id) {
        if(hasView(view)){
            view.onSuccessfulRegister(id);
        }
    }

    @Override
    public void onStoreFail(String error) {
        if(hasView(view))
            view.onUnSuccessfulCall(error);
    }

    @Override
    public void onNoInternetConnection() {
        if(hasView(view)){
            view.onNoInternetConnection();
        }
    }

    @Override
    public void onStatelistAvailable(List<StateList> stateLists) {
        if(hasView(view))
            view.onStatelistAvailable(stateLists);
    }

    @Override
    public void onCityListAvaliable(List<CitystateList> citystateLists) {
        if(hasView(view))
            view.onCityListAvailable(citystateLists);
    }

    @Override
    public void initCityByStateId(String ids) {
        module.selectCityByStateId(ids, this);
    }
}
