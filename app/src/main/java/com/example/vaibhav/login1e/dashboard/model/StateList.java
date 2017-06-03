
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
public class StateList implements Parcelable
{
    //If you declare as transient that field will be never serialized.
    private transient Long id;

    @SerializedName("id")
    @Expose
    private String ids;
    @SerializedName("state")
    @Expose
    private String state;
    public final static Parcelable.Creator<StateList> CREATOR = new Creator<StateList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StateList createFromParcel(Parcel in) {
            StateList instance = new StateList();
            instance.ids = ((String) in.readValue((String.class.getClassLoader())));
            instance.state = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public StateList[] newArray(int size) {
            return (new StateList[size]);
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ids);
        dest.writeValue(state);
    }

    public int describeContents() {
        return  0;
    }

}
