
package com.example.vihaan.nativequestions.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hn implements Parcelable {

    @SerializedName("range")
    @Expose
    private Range_ range;

    public Range_ getRange() {
        return range;
    }

    public void setRange(Range_ range) {
        this.range = range;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.range, flags);
    }

    public Hn() {
    }

    protected Hn(Parcel in) {
        this.range = in.readParcelable(Range_.class.getClassLoader());
    }

    public static final Parcelable.Creator<Hn> CREATOR = new Parcelable.Creator<Hn>() {
        @Override
        public Hn createFromParcel(Parcel source) {
            return new Hn(source);
        }

        @Override
        public Hn[] newArray(int size) {
            return new Hn[size];
        }
    };
}
