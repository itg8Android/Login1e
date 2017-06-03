package com.example.vaibhav.login1e.exams;

/**
 * Created by swapnilmeshram on 13/03/17.
 */

interface ExamPresenter {

    void checkExamDetail(ExamFragment fragment);

    void onDetailGathered(RequestExamTaken examTaken);
}
