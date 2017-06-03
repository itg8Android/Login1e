
package com.example.vaibhav.login1e.login.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResponseLoginModel {

    @SerializedName("flag")
    private Long mFlag;
    @SerializedName("type")
    private Long mType;
    @SerializedName("userid")
    private String mUserid;

    public Long getFlag() {
        return mFlag;
    }

    public void setFlag(Long flag) {
        mFlag = flag;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

    public String getUserid() {
        return mUserid;
    }

    public void setUserid(String userid) {
        mUserid = userid;
    }

}
