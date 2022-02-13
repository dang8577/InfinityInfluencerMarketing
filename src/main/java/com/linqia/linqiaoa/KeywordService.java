package com.linqia.linqiaoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class KeywordService {
    @Autowired
    private KeywordRepository repo;

    public List<Keyword> listKeywords(){
        return (List<Keyword>) repo.findAll();
    }

    public void addKeyword(List<Keyword> keywords){
        repo.saveAll(keywords);
    }

    public String predict(String text){
        List<Keyword> keywords = (List<Keyword>) repo.findAll();
        for(Keyword keyword : keywords){
            if(text.contains(keyword.getTextValue())){
                return "sponsored";
            }
        }

        return "non-sponsored";
    }
}
