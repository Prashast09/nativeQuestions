
package com.example.vihaan.nativequestions.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class En implements Parcelable {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("options")
    @Expose
    private List<Option> options = null;
    @SerializedName("sol")
    @Expose
    private List<Sol> sol = null;
    @SerializedName("co")
    @Expose
    private String co;
    @SerializedName("range")
    @Expose
    private Range range;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Sol> getSol() {
        return sol;
    }

    public void setSol(List<Sol> sol) {
        this.sol = sol;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
        dest.writeList(this.options);
        dest.writeList(this.sol);
        dest.writeString(this.co);
        dest.writeParcelable(this.range, flags);
    }

    public En() {
    }

    protected En(Parcel in) {
        this.value = in.readString();
        this.options = new ArrayList<Option>();
        in.readList(this.options, Option.class.getClassLoader());
        this.sol = new ArrayList<Sol>();
        in.readList(this.sol, Sol.class.getClassLoader());
        this.co = in.readString();
        this.range = in.readParcelable(Range.class.getClassLoader());
    }

    public static final Parcelable.Creator<En> CREATOR = new Parcelable.Creator<En>() {
        @Override
        public En createFromParcel(Parcel source) {
            return new En(source);
        }

        @Override
        public En[] newArray(int size) {
            return new En[size];
        }
    };
}
