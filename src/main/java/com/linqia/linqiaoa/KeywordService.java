package com.linqia.linqiaoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class KeywordService {
    @Autowired
    private KeywordRepository repo;
    private List<Keyword> keywordsInMemory;

    public void loadKeywordInMemory(){
        keywordsInMemory = repo.findAll();
    }

    public List<Keyword> listKeywords(){
        return  keywordsInMemory;
    }

    public void addKeyword(List<Keyword> keywords){
        keywordsInMemory.addAll(keywords);
        synchronizedWithDatabase();
    }

    public void synchronizedWithDatabase(){
        List<Keyword> keywordInDatabase = repo.findAll();
        List<Keyword> copyKeywords = new ArrayList<>(keywordsInMemory);
        copyKeywords.removeAll(keywordInDatabase);
        repo.saveAll(copyKeywords);
    }

    public String predict(String text){
        for(Keyword keyword : keywordsInMemory){
            if(text.toLowerCase().contains(keyword.getTextValue().toLowerCase())){
                return "sponsored";
            }
        }

        return "non-sponsored";
    }
}
