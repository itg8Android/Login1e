package com.example.vaibhav.login1e.exams;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.common.DialogListFragmentListener;
import com.example.vaibhav.login1e.dashboard.model.Jobrole;
import com.example.vaibhav.login1e.dashboard.model.SectorSsc;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExamExpActivity extends AppCompatActivity implements ExamModelView,ActivityPresenterListener, View.OnClickListener, DialogListFragmentListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.container)
    ViewPager container;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    private TabPagerAdapter adapter;
    ExamFragment fragment=new ExamFragment();
    ExamPresenter presenter;
    private Fragment examFragment=new ExamExpFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_exp);
        ButterKnife.bind(this);
      //  setSupportActionBar(toolbar);
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        adapter= new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragment,"Exam");
        adapter.addFragment(examFragment,"Expense");
        container.setAdapter(adapter);
        tabs.setupWithViewPager(container);
        presenter=new ExamPresenterImp(this);
        fab.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showSscSector(List<SectorSsc> list) {
        ListDataFragment.getInstance(list,"Search Sector List").show(getSupportFragmentManager(),"SECTOR");
    }


    @Override
    public void showJobrole(List<Jobrole> list) {
        ListDataFragment.getInstance(list,"Search Jobrole List").show(getSupportFragmentManager(),"JOB ROLE");
    }


    @Override
    public void getSelectedItem(Object mSelectedata) {
        if(mSelectedata instanceof Jobrole)
            fragment.setItemHasbeenSelected((Jobrole)mSelectedata);
        else if(mSelectedata instanceof SectorSsc)
            fragment.setItemHasbeenSelected((SectorSsc) mSelectedata);

    }

    @Override
    public void onValidate() {

    }

    @Override
    public void onValidationFail() {

    }

    @Override
    public void onSuccessfulAdded() {

    }

    @Override
    public void onFailToStoreOnServer() {

    }

    @Override
    public void onClick(View view) {
        presenter.checkExamDetail(fragment);
    }

    public class TabPagerAdapter extends FragmentPagerAdapter{

        ArrayList<Fragment> FList= new ArrayList<>();
        ArrayList<String> SList= new ArrayList<>();


        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Exam";
                case 1:
                    return "Expence";


            }
            return SList.get(position);
        }

        @Override
        public int getCount() {
            return FList.size();
        }

        public void addFragment(Fragment fragment,String title){

            FList.add(fragment);
            SList.add(title);


        }
    }
}
