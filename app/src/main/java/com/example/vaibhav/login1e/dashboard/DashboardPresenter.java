package com.example.vaibhav.login1e.dashboard;

import com.example.vaibhav.login1e.rest.RetroControler;

/**
 * Created by swapnilmeshram on 05/03/17.
 */

public interface DashboardPresenter {
    void getTotalExamTaken(int exams);
    void onUpCommingExam(int exam);
    void onExpenditureGet();
    void onSuccessfulDownloadMasters(boolean status);
    void onFailToLoad(String msg);
    interface DashboardModel{
        void downloadAllMasters(DashboardPresenter listener, RetroControler controler);
    }
}
