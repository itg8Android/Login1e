
package com.example.vaibhav.login1e.dashboard.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class AllSpinnerDatum implements Parcelable
{

    @SerializedName("sector_ssc")
    @Expose
    @Valid
    private List<SectorSsc> sectorSsc = new ArrayList<SectorSsc>();
    @SerializedName("jobrole")
    @Expose
    @Valid
    private List<Jobrole> jobrole = new ArrayList<Jobrole>();
    @SerializedName("company")
    @Expose
    @Valid
    private List<Company> company = new ArrayList<Company>();
    @SerializedName("state_list")
    @Expose
    @Valid
    private List<StateList> stateList = new ArrayList<StateList>();
    @SerializedName("citystate_list")
    @Expose
    @Valid
    private List<CitystateList> citystateList = new ArrayList<CitystateList>();
    public final static Parcelable.Creator<AllSpinnerDatum> CREATOR = new Creator<AllSpinnerDatum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AllSpinnerDatum createFromParcel(Parcel in) {
            AllSpinnerDatum instance = new AllSpinnerDatum();
            in.readList(instance.sectorSsc, (com.example.vaibhav.login1e.dashboard.model.SectorSsc.class.getClassLoader()));
            in.readList(instance.jobrole, (com.example.vaibhav.login1e.dashboard.model.Jobrole.class.getClassLoader()));
            in.readList(instance.company, (com.example.vaibhav.login1e.dashboard.model.Company.class.getClassLoader()));
            in.readList(instance.stateList, (com.example.vaibhav.login1e.dashboard.model.StateList.class.getClassLoader()));
            in.readList(instance.citystateList, (com.example.vaibhav.login1e.dashboard.model.CitystateList.class.getClassLoader()));
            return instance;
        }

        public AllSpinnerDatum[] newArray(int size) {
            return (new AllSpinnerDatum[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The sectorSsc
     */
    public List<SectorSsc> getSectorSsc() {
        return sectorSsc;
    }

    /**
     * 
     * @param sectorSsc
     *     The sector_ssc
     */
    public void setSectorSsc(List<SectorSsc> sectorSsc) {
        this.sectorSsc = sectorSsc;
    }

    /**
     * 
     * @return
     *     The jobrole
     */
    public List<Jobrole> getJobrole() {
        return jobrole;
    }

    /**
     * 
     * @param jobrole
     *     The jobrole
     */
    public void setJobrole(List<Jobrole> jobrole) {
        this.jobrole = jobrole;
    }

    /**
     * 
     * @return
     *     The company
     */
    public List<Company> getCompany() {
        return company;
    }

    /**
     * 
     * @param company
     *     The company
     */
    public void setCompany(List<Company> company) {
        this.company = company;
    }

    /**
     * 
     * @return
     *     The stateList
     */
    public List<StateList> getStateList() {
        return stateList;
    }

    /**
     * 
     * @param stateList
     *     The state_list
     */
    public void setStateList(List<StateList> stateList) {
        this.stateList = stateList;
    }

    /**
     * 
     * @return
     *     The citystateList
     */
    public List<CitystateList> getCitystateList() {
        return citystateList;
    }

    /**
     * 
     * @param citystateList
     *     The citystate_list
     */
    public void setCitystateList(List<CitystateList> citystateList) {
        this.citystateList = citystateList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(sectorSsc);
        dest.writeList(jobrole);
        dest.writeList(company);
        dest.writeList(stateList);
        dest.writeList(citystateList);
    }

    public int describeContents() {
        return  0;
    }

}
