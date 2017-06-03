package com.example.vaibhav.login1e.exams;

/**
 * Created by swapnilmeshram on 13/03/17.
 */

interface ExamModelView {
    void onValidate();
    void onValidationFail();
    void onSuccessfulAdded();
    void onFailToStoreOnServer();
}
