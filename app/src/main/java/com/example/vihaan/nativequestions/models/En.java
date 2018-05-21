
package com.example.vihaan.nativequestions.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class En {

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

}
