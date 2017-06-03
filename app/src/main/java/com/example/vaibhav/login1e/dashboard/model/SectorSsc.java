
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class SectorSsc extends SugarRecord implements Parcelable
{

    @SerializedName("sr")
    @Expose
    private String sr;
    @SerializedName("ssc_id")
    @Expose
    private String sscId;
    @SerializedName("ssc_name")
    @Expose
    private String sscName;
    public final static Parcelable.Creator<SectorSsc> CREATOR = new Creator<SectorSsc>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SectorSsc createFromParcel(Parcel in) {
            SectorSsc instance = new SectorSsc();
            instance.sr = ((String) in.readValue((String.class.getClassLoader())));
            instance.sscId = ((String) in.readValue((String.class.getClassLoader())));
            instance.sscName = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SectorSsc[] newArray(int size) {
            return (new SectorSsc[size]);
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
     *     The sscName
     */
    public String getSscName() {
        return sscName;
    }

    /**
     * 
     * @param sscName
     *     The ssc_name
     */
    public void setSscName(String sscName) {
        this.sscName = sscName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sr);
        dest.writeValue(sscId);
        dest.writeValue(sscName);
    }

    public int describeContents() {
        return  0;
    }

}
