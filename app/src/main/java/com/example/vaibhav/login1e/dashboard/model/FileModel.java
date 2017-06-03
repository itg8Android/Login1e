
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FileModel implements Parcelable
{

    @SerializedName("Faqmaster")
    @Expose
    @Valid
    private com.example.vaibhav.login1e.dashboard.model.Faqmaster Faqmaster;
    public final static Parcelable.Creator<FileModel> CREATOR = new Creator<FileModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FileModel createFromParcel(Parcel in) {
            FileModel instance = new FileModel();
            instance.Faqmaster = ((com.example.vaibhav.login1e.dashboard.model.Faqmaster) in.readValue((Faqmaster.class.getClassLoader())));
            return instance;
        }

        public FileModel[] newArray(int size) {
            return (new FileModel[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The Faqmaster
     */
    public com.example.vaibhav.login1e.dashboard.model.Faqmaster getFaqmaster() {
        return Faqmaster;
    }

    /**
     * 
     * @param Faqmaster
     *     The Faqmaster
     */
    public void setFaqmaster(com.example.vaibhav.login1e.dashboard.model.Faqmaster Faqmaster) {
        this.Faqmaster = Faqmaster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(Faqmaster);
    }

    public int describeContents() {
        return  0;
    }

}
