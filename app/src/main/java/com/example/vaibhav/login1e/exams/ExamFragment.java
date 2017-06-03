package com.example.vaibhav.login1e.exams;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.common.SharedPrefClass;
import com.example.vaibhav.login1e.dashboard.model.Jobrole;
import com.example.vaibhav.login1e.dashboard.model.SectorSsc;
import com.orm.SugarRecord;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vaibhav on 1/3/17.
 */
public class ExamFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.company_id)
    EditText companyId;
    @BindView(R.id.sector_id)
    EditText sectorId;
    @BindView(R.id.job_role_id)
    EditText jobRoleId;
    @BindView(R.id.batch_id)
    EditText batchId;
    @BindView(R.id.center)
    EditText center;
    @BindView(R.id.present_edi_text_exam)
    EditText presentEdiTextExam;
    @BindView(R.id.absent_edi_text_exam)
    EditText absentEdiTextExam;
    @BindView(R.id.linear_view_exam)
    LinearLayout linearViewExam;
    @BindView(R.id.present_viva_edi_text_exam)
    EditText presentVivaEdiTextExam;
    @BindView(R.id.absent_viva_edi_text_exam)
    EditText absentVivaEdiTextExam;
    @BindView(R.id.linear2_exam)
    LinearLayout linear2Exam;
    @BindView(R.id.view)
    CardView view;

    ActivityPresenterListener listener;
    private ExamPresenter examListener;
    private String jobrole;
    private String sector;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);
        sectorId.setOnClickListener(this);
        jobRoleId.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener= (ActivityPresenterListener) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sector_id:
                openSectorList(SugarRecord.listAll(SectorSsc.class));
                break;
            case R.id.job_role_id:
                openJobroleList(SugarRecord.listAll(Jobrole.class));
                break;
        }
    }

    private void openJobroleList(List<Jobrole> list) {
        listener.showJobrole(list);
    }


    private void openSectorList(List<SectorSsc> sectorSscs) {
        listener.showSscSector(sectorSscs);
    }


    public void setItemHasbeenSelected(Jobrole mSelectedata) {
        jobRoleId.setText(mSelectedata.getJobrole());
    }

    public void setItemHasbeenSelected(SectorSsc mSelectedata) {
        sectorId.setText(mSelectedata.getSscName());
    }

    public void setListener(ExamPresenter examPresenter) {
        this.examListener=examPresenter;
    }


    public void checkIfValidate() {
        if(examListener!=null){
            validateData();
        }
    }

    private void validateData() {
        if(validate()){
            RequestExamTaken examTaken=new RequestExamTaken();
            examTaken.setCompText(companyId.getText().toString());
            examTaken.setSscId(sector);
            examTaken.setJobroleId(jobrole);
            examTaken.setBatchid(batchId.getText().toString());
            examTaken.setAssId(SharedPrefClass.getInstance(getActivity()).getPref(SharedPrefClass.USERNAME));
            examTaken.setStuA(absentEdiTextExam.getText().toString());
            examTaken.setStuP(presentEdiTextExam.getText().toString());
            examTaken.setVivaA(absentVivaEdiTextExam.getText().toString());
            examTaken.setVivaP(presentVivaEdiTextExam.getText().toString());
            examListener.onDetailGathered(examTaken);
        }
    }

    private boolean validate() {
        boolean valid=true;
        if(TextUtils.isEmpty(companyId.getText().toString())) {
            companyId.setError("This field cannot be empty");
            valid = false;
        }
        if(sector==null || TextUtils.isEmpty(sector)){
            sectorId.setError("This field cannot be empty");
            valid=false;
        }
        if(jobrole==null || TextUtils.isEmpty(jobrole)){
            jobRoleId.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(batchId.getText().toString()))
        {
            batchId.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(center.getText().toString())){
            center.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(absentEdiTextExam.getText().toString())){
            absentEdiTextExam.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(presentEdiTextExam.getText().toString())){
            presentEdiTextExam.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(absentVivaEdiTextExam.getText().toString())){
            absentVivaEdiTextExam.setError("This field cannot be empty");
            valid=false;
        }
        if(TextUtils.isEmpty(presentVivaEdiTextExam.getText().toString())){
            presentVivaEdiTextExam.setError("This field cannot be empty");
            valid=false;
        }

        return valid;
    }
}
