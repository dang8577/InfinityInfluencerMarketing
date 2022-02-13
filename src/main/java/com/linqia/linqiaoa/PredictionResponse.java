package com.linqia.linqiaoa;

public class PredictionResponse {
    private String prediction;

    public PredictionResponse(){

    }

    public PredictionResponse(String prediction){
        this.prediction = prediction;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
