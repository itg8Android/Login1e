
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class Jobrole extends SugarRecord implements Parcelable
{

    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("ssc_id")
    @Expose
    private String sscId;
    @SerializedName("jobroleId")
    @Expose
    private String jobroleId;
    @SerializedName("jobrole")
    @Expose
    private String jobrole;
    public final static Parcelable.Creator<Jobrole> CREATOR = new Creator<Jobrole>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Jobrole createFromParcel(Parcel in) {
            Jobrole instance = new Jobrole();
            instance.sr = ((String) in.readValue((String.class.getClassLoader())));
            instance.sscId = ((String) in.readValue((String.class.getClassLoader())));
            instance.jobroleId = ((String) in.readValue((String.class.getClassLoader())));
            instance.jobrole = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Jobrole[] newArray(int size) {
            return (new Jobrole[size]);
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
     *     The sscId
     */
    public String getSscId() {
        return sscId;
    }

    /**
     * 
     * @param sscId
     *     The ssc_id
     */
    public void setSscId(String sscId) {
        this.sscId = sscId;
    }

    /**
     * 
     * @return
     *     The jobroleId
     */
    public String getJobroleId() {
        return jobroleId;
    }

    /**
     * 
     * @param jobroleId
     *     The jobroleId
     */
    public void setJobroleId(String jobroleId) {
        this.jobroleId = jobroleId;
    }

    /**
     * 
     * @return
     *     The jobrole
     */
    public String getJobrole() {
        return jobrole;
    }

    /**
     * 
     * @param jobrole
     *     The jobrole
     */
    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sr);
        dest.writeValue(sscId);
        dest.writeValue(jobroleId);
        dest.writeValue(jobrole);
    }

    public int describeContents() {
        return  0;
    }

}
