package com.example.vaibhav.login1e.dashboard;

import android.content.Context;

import com.example.vaibhav.login1e.rest.Retro;


class DashboardPresenterImp implements DashboardPresenter {


    @SuppressWarnings("FieldCanBeLocal")
    private final Context context;
    private DashboardView view;

     DashboardPresenterImp(DashboardView view, Context context) {
        this.context=context;
        this.view = view;
         DashboardModelImp model = new DashboardModelImp();
         model.downloadAllMasters(this, Retro.getInstance().getRetrofit());
    }

    @Override
    public void getTotalExamTaken(int exams) {
        if(hasView()){
            view.getTotalExamTaken(exams);
        }
    }

    private boolean hasView() {
        return view!=null;
    }

    @Override
    public void onUpCommingExam(int exam) {
        if(hasView()){
            view.onUpCommingExam(exam);
        }
    }

    @Override
    public void onExpenditureGet() {
        if(hasView()){
            view.onExpenditureGet();
        }
    }

    @Override
    public void onSuccessfulDownloadMasters(boolean status) {
        if(hasView()){
            view.onSuccessfulDownloadMasters(status);
        }
    }

    @Override
    public void onFailToLoad(String msg) {
        if(hasView()){
            view.onFailToLoad(msg);
        }
    }


}
