package com.linqia.linqiaoa;

import java.util.List;

public class ListKeywordResponse {
    private String[] vocab;

    public ListKeywordResponse(){

    }

    public ListKeywordResponse(List<Keyword> keywords){
        vocab = new String[keywords.size()];
        for(int i = 0; i < vocab.length; i++){
            vocab[i] = keywords.get(i).getTextValue();
        }
    }

    public String[] getVocab() {
        return vocab;
    }

    public void setVocab(String[] vocab) {
        this.vocab = vocab;
    }
}
