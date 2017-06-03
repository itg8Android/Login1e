package com.example.vaibhav.login1e.exams;

/**
 * Created by swapnilmeshram on 13/03/17.
 */

class ExamPresenterImp implements ExamPresenter {

    private final ExamModelView view;
    private boolean examDataGathered;

    public ExamPresenterImp(ExamModelView view) {
        this.view=view;

    }

    @Override
    public void checkExamDetail(ExamFragment fragment) {
        if(fragment!=null){
            fragment.setListener(this);
            fragment.checkIfValidate();
        }
    }

    @Override
    public void onDetailGathered(RequestExamTaken examTaken) {
        examDataGathered=true;

    }
}
