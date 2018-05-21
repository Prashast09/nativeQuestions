
package com.example.vihaan.nativequestions.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hn {

    @SerializedName("range")
    @Expose
    private Range_ range;

    public Range_ getRange() {
        return range;
    }

    public void setRange(Range_ range) {
        this.range = range;
    }

}
