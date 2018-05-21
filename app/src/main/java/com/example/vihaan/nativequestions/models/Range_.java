
package com.example.vihaan.nativequestions.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Range_ implements Parcelable {

    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.start);
        dest.writeString(this.end);
    }

    public Range_() {
    }

    protected Range_(Parcel in) {
        this.start = in.readString();
        this.end = in.readString();
    }

    public static final Parcelable.Creator<Range_> CREATOR = new Parcelable.Creator<Range_>() {
        @Override
        public Range_ createFromParcel(Parcel source) {
            return new Range_(source);
        }

        @Override
        public Range_[] newArray(int size) {
            return new Range_[size];
        }
    };
}
