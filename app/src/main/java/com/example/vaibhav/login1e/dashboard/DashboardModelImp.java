package com.example.vaibhav.login1e.dashboard;

import android.util.Log;

import com.example.vaibhav.login1e.dashboard.model.AllSpinnerDatum;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.Company;
import com.example.vaibhav.login1e.dashboard.model.Jobrole;
import com.example.vaibhav.login1e.dashboard.model.SectorSsc;
import com.example.vaibhav.login1e.dashboard.model.StateList;
import com.example.vaibhav.login1e.rest.RetroControler;
import com.google.gson.Gson;
import com.orm.SugarRecord;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashboardModelImp implements DashboardPresenter.DashboardModel{


    @Override
    public void downloadAllMasters(final DashboardPresenter listener, RetroControler controler) {
        Call<List<AllSpinnerDatum>> call=controler.allSpinnerData();
        call.enqueue(new Callback<List<AllSpinnerDatum>>() {
            @Override
            public void onResponse(Call<List<AllSpinnerDatum>> call, Response<List<AllSpinnerDatum>> response) {
                Log.d("Dashboard",response.body().size()+" size , "+new Gson().toJson(response.body()));
                if(response.isSuccessful()){
                 listener.onSuccessfulDownloadMasters(true);
                    arrangeAllDataBySpinnerDownloaded(response.body());
                }else {
                    listener.onFailToLoad(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<AllSpinnerDatum>> call, Throwable t) {
                t.printStackTrace();
                String fData="onfailure : "+t.getMessage();
                listener.onFailToLoad(fData);
            }
        });
    }

    private void arrangeAllDataBySpinnerDownloaded(List<AllSpinnerDatum> body) {
        if(body!=null && body.size()>2){
            List<SectorSsc> sectorSscList=body.get(0).getSectorSsc();
            if(sectorSscList!=null && !sectorSscList.isEmpty()){
                if(!SugarRecord.listAll(SectorSsc.class).isEmpty()){
                    SugarRecord.deleteAll(SectorSsc.class);
                }
                SugarRecord.saveInTx(sectorSscList);
            }
            List<Jobrole> jobroleList=body.get(1).getJobrole();
            if(jobroleList!=null && !jobroleList.isEmpty()){
                if(!SugarRecord.listAll(Jobrole.class).isEmpty()){
                    SugarRecord.deleteAll(Jobrole.class);
                }
                SugarRecord.saveInTx(jobroleList);
            }
            List<Company> companies=body.get(2).getCompany();
            if(companies!=null && !companies.isEmpty()){
                if(SugarRecord.listAll(Company.class).isEmpty()){
                    SugarRecord.deleteAll(Company.class);
                }
                SugarRecord.saveInTx(companies);
            }

            List<StateList> stateLists=body.get(3).getStateList();
            if(stateLists!=null && !stateLists.isEmpty()){
                if(!SugarRecord.listAll(StateList.class).isEmpty()){
                    SugarRecord.deleteAll(StateList.class);
                }
                SugarRecord.saveInTx(stateLists);
            }
            List<CitystateList> citystateLists=body.get(4).getCitystateList();
            if(citystateLists!=null && !citystateLists.isEmpty()){
                if(!SugarRecord.listAll(CitystateList.class).isEmpty()){
                    SugarRecord.deleteAll(CitystateList.class);
                }
                SugarRecord.saveInTx(citystateLists);
            }
        }
    }
}
