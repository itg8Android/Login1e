
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class Company extends SugarRecord implements Parcelable
{

    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("comid")
    @Expose
    private String comid;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("RegDate")
    @Expose
    private String RegDate;
    public final static Parcelable.Creator<Company> CREATOR = new Creator<Company>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Company createFromParcel(Parcel in) {
            Company instance = new Company();
            instance.sr = ((String) in.readValue((String.class.getClassLoader())));
            instance.comid = ((String) in.readValue((String.class.getClassLoader())));
            instance.companyName = ((String) in.readValue((String.class.getClassLoader())));
            instance.RegDate = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Company[] newArray(int size) {
            return (new Company[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The sr
     */
    public String getSr() {
        return sr;
    }

    /**
     * 
     * @param sr
     *     The sr
     */
    public void setSr(String sr) {
        this.sr = sr;
    }

    /**
     * 
     * @return
     *     The comid
     */
    public String getComid() {
        return comid;
    }

    /**
     * 
     * @param comid
     *     The comid
     */
    public void setComid(String comid) {
        this.comid = comid;
    }

    /**
     * 
     * @return
     *     The companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *     The companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *     The RegDate
     */
    public String getRegDate() {
        return RegDate;
    }

    /**
     * 
     * @param RegDate
     *     The RegDate
     */
    public void setRegDate(String RegDate) {
        this.RegDate = RegDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sr);
        dest.writeValue(comid);
        dest.writeValue(companyName);
        dest.writeValue(RegDate);
    }

    public int describeContents() {
        return  0;
    }

}
