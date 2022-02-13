package com.linqia.linqiaoa;


public class AddKeywordsRequest {
    private String[] keywords;
    public AddKeywordsRequest(){

    }

    public AddKeywordsRequest(String[] inputs){
        keywords = inputs;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
}
