
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

@Generated("org.jsonschema2pojo")
@Table
public class CitystateList implements Parcelable
{
    //If you declare as transient that field will be never serialized.
    private transient Long id;

    //    @Ignore
    @SerializedName("id")
    @Expose
    private String ids;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    public final static Parcelable.Creator<CitystateList> CREATOR = new Creator<CitystateList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CitystateList createFromParcel(Parcel in) {
            CitystateList instance = new CitystateList();
            instance.ids = ((String) in.readValue((String.class.getClassLoader())));
            instance.city = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            instance.stateCode = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public CitystateList[] newArray(int size) {
            return (new CitystateList[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The id
     */
    public String getIds() {
        return ids;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setIds(String id) {
        this.ids = id;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The stateCode
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * 
     * @param stateCode
     *     The stateCode
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ids);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(stateCode);
    }

    public int describeContents() {
        return  0;
    }

}
