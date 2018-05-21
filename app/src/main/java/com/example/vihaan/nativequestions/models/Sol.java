
package com.example.vihaan.nativequestions.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sol implements Parcelable {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("addedon")
    @Expose
    private String addedon;
    @SerializedName("updatedon")
    @Expose
    private String updatedon;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddedon() {
        return addedon;
    }

    public void setAddedon(String addedon) {
        this.addedon = addedon;
    }

    public String getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(String updatedon) {
        this.updatedon = updatedon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
        dest.writeString(this.type);
        dest.writeString(this.name);
        dest.writeValue(this.id);
        dest.writeString(this.uid);
        dest.writeString(this.addedon);
        dest.writeString(this.updatedon);
    }

    public Sol() {
    }

    protected Sol(Parcel in) {
        this.value = in.readString();
        this.type = in.readString();
        this.name = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.uid = in.readString();
        this.addedon = in.readString();
        this.updatedon = in.readString();
    }

    public static final Parcelable.Creator<Sol> CREATOR = new Parcelable.Creator<Sol>() {
        @Override
        public Sol createFromParcel(Parcel source) {
            return new Sol(source);
        }

        @Override
        public Sol[] newArray(int size) {
            return new Sol[size];
        }
    };
}
