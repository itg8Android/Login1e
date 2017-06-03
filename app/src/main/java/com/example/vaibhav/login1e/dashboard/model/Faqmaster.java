
package com.example.vaibhav.login1e.dashboard.model;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Faqmaster implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("typeof")
    @Expose
    private String typeof;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("created")
    @Expose
    private String created;
    public final static Parcelable.Creator<Faqmaster> CREATOR = new Creator<Faqmaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Faqmaster createFromParcel(Parcel in) {
            Faqmaster instance = new Faqmaster();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.typeof = ((String) in.readValue((String.class.getClassLoader())));
            instance.question = ((String) in.readValue((String.class.getClassLoader())));
            instance.answer = ((String) in.readValue((String.class.getClassLoader())));
            instance.created = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Faqmaster[] newArray(int size) {
            return (new Faqmaster[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The typeof
     */
    public String getTypeof() {
        return typeof;
    }

    /**
     * 
     * @param typeof
     *     The typeof
     */
    public void setTypeof(String typeof) {
        this.typeof = typeof;
    }

    /**
     * 
     * @return
     *     The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 
     * @param question
     *     The question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 
     * @return
     *     The answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 
     * @param answer
     *     The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(typeof);
        dest.writeValue(question);
        dest.writeValue(answer);
        dest.writeValue(created);
    }

    public int describeContents() {
        return  0;
    }

}
