package com.linqia.linqiaoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class KeywordController {
    @Autowired
    private KeywordService service;

    @GetMapping("/api/vocab")
    public ListKeywordResponse listKeywords(){
        return new ListKeywordResponse(service.listKeywords());
    }

    @PostMapping("/api/vocab")
    public ListKeywordResponse addKeyword(@RequestBody AddKeywordsRequest request){ // Use @requestBody to convert JSON to Java Object
        String[] keywords = request.getKeywords();
        List<Keyword> listKeywords = new ArrayList<>();
        for(String keyword: keywords){
            listKeywords.add(new Keyword(keyword));
        }

        service.addKeyword(listKeywords);
        return new ListKeywordResponse(service.listKeywords());
    }

    @PostMapping("/api/prediction")
    public PredictionResponse predict(@RequestBody PredictionRequest request){
        System.out.println(request.getPostText());
        String result = service.predict(request.getPostText());
        return new PredictionResponse(result);
    }
}
