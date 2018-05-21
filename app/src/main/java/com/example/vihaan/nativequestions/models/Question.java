
package com.example.vihaan.nativequestions.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question implements Parcelable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("en")
    @Expose
    private En en;
    @SerializedName("hn")
    @Expose
    private Hn hn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public En getEn() {
        return en;
    }

    public void setEn(En en) {
        this.en = en;
    }

    public Hn getHn() {
        return hn;
    }

    public void setHn(Hn hn) {
        this.hn = hn;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.type);
        dest.writeParcelable(this.en, flags);
        dest.writeParcelable(this.hn, flags);
    }

    public Question() {
    }

    protected Question(Parcel in) {
        this.id = in.readString();
        this.type = in.readString();
        this.en = in.readParcelable(En.class.getClassLoader());
        this.hn = in.readParcelable(Hn.class.getClassLoader());
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
