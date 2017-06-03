package com.example.vaibhav.login1e.dashboard;

/**
 * Created by swapnilmeshram on 05/03/17.
 */

public interface DashboardView {
    void getTotalExamTaken(int exams);
    void onUpCommingExam(int exam);
    void onExpenditureGet();
    void onSuccessfulDownloadMasters(boolean status);
    void onFailToLoad(String msg);


}
