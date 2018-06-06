
package br.com.barrsoft.androiddevelopmentcourse.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {


    @SerializedName("payload_type")
    @Expose
    private String payloadType;

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }
}
