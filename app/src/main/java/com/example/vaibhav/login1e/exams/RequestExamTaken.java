
package com.example.vaibhav.login1e.exams;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class RequestExamTaken implements Parcelable
{

    @SerializedName("ass_id")
    @Expose
    private String assId;
    @SerializedName("comp_text")
    @Expose
    private String compText;
    @SerializedName("batchid")
    @Expose
    private String batchid;
    @SerializedName("ssc_id")
    @Expose
    private String sscId;
    @SerializedName("jobrole_id")
    @Expose
    private String jobroleId;
    @SerializedName("tp_text")
    @Expose
    private String tpText;
    @SerializedName("stu_p")
    @Expose
    private String stuP;
    @SerializedName("stu_a")
    @Expose
    private String stuA;
    @SerializedName("viva_p")
    @Expose
    private String vivaP;
    @SerializedName("viva_a")
    @Expose
    private String vivaA;
    @SerializedName("method")
    @Expose
    private String method;
    public final static Parcelable.Creator<RequestExamTaken> CREATOR = new Creator<RequestExamTaken>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RequestExamTaken createFromParcel(Parcel in) {
            RequestExamTaken instance = new RequestExamTaken();
            instance.assId = ((String) in.readValue((String.class.getClassLoader())));
            instance.compText = ((String) in.readValue((String.class.getClassLoader())));
            instance.batchid = ((String) in.readValue((String.class.getClassLoader())));
            instance.sscId = ((String) in.readValue((String.class.getClassLoader())));
            instance.jobroleId = ((String) in.readValue((String.class.getClassLoader())));
            instance.tpText = ((String) in.readValue((String.class.getClassLoader())));
            instance.stuP = ((String) in.readValue((String.class.getClassLoader())));
            instance.stuA = ((String) in.readValue((String.class.getClassLoader())));
            instance.vivaP = ((String) in.readValue((String.class.getClassLoader())));
            instance.vivaA = ((String) in.readValue((String.class.getClassLoader())));
            instance.method = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public RequestExamTaken[] newArray(int size) {
            return (new RequestExamTaken[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The assId
     */
    public String getAssId() {
        return assId;
    }

    /**
     * 
     * @param assId
     *     The ass_id
     */
    public void setAssId(String assId) {
        this.assId = assId;
    }

    /**
     * 
     * @return
     *     The compText
     */
    public String getCompText() {
        return compText;
    }

    /**
     * 
     * @param compText
     *     The comp_text
     */
    public void setCompText(String compText) {
        this.compText = compText;
    }

    /**
     * 
     * @return
     *     The batchid
     */
    public String getBatchid() {
        return batchid;
    }

    /**
     * 
     * @param batchid
     *     The batchid
     */
    public void setBatchid(String batchid) {
        this.batchid = batchid;
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
     *     The jobrole_id
     */
    public void setJobroleId(String jobroleId) {
        this.jobroleId = jobroleId;
    }

    /**
     * 
     * @return
     *     The tpText
     */
    public String getTpText() {
        return tpText;
    }

    /**
     * 
     * @param tpText
     *     The tp_text
     */
    public void setTpText(String tpText) {
        this.tpText = tpText;
    }

    /**
     * 
     * @return
     *     The stuP
     */
    public String getStuP() {
        return stuP;
    }

    /**
     * 
     * @param stuP
     *     The stu_p
     */
    public void setStuP(String stuP) {
        this.stuP = stuP;
    }

    /**
     * 
     * @return
     *     The stuA
     */
    public String getStuA() {
        return stuA;
    }

    /**
     * 
     * @param stuA
     *     The stu_a
     */
    public void setStuA(String stuA) {
        this.stuA = stuA;
    }

    /**
     * 
     * @return
     *     The vivaP
     */
    public String getVivaP() {
        return vivaP;
    }

    /**
     * 
     * @param vivaP
     *     The viva_p
     */
    public void setVivaP(String vivaP) {
        this.vivaP = vivaP;
    }

    /**
     * 
     * @return
     *     The vivaA
     */
    public String getVivaA() {
        return vivaA;
    }

    /**
     * 
     * @param vivaA
     *     The viva_a
     */
    public void setVivaA(String vivaA) {
        this.vivaA = vivaA;
    }

    /**
     * 
     * @return
     *     The method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 
     * @param method
     *     The method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(assId);
        dest.writeValue(compText);
        dest.writeValue(batchid);
        dest.writeValue(sscId);
        dest.writeValue(jobroleId);
        dest.writeValue(tpText);
        dest.writeValue(stuP);
        dest.writeValue(stuA);
        dest.writeValue(vivaP);
        dest.writeValue(vivaA);
        dest.writeValue(method);
    }

    public int describeContents() {
        return  0;
    }

}
