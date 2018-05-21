
package com.example.vihaan.nativequestions.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

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

}
