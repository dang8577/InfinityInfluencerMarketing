package com.linqia.linqiaoa;


public class AddKeywordsRequest {
    private String[] vocab;
    public AddKeywordsRequest(){

    }

    public AddKeywordsRequest(String[] inputs){
        vocab = inputs;
    }

    public String[] getVocab() {
        return vocab;
    }

    public void setVocab(String[] vocab) {
        this.vocab = vocab;
    }
}
