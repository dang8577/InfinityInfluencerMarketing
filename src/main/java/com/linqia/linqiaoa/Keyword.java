package com.linqia.linqiaoa;

import javax.persistence.*;

@Entity

public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // map ID with primary key of the table in database
    private Integer id;
    @Column(nullable = false) // Value can't be empty
    private String textValue;
    public Keyword(){

    }
    public Keyword(String keyword){
        textValue = keyword;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String value) {
        this.textValue = value;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", value='" + textValue + '\'' +
                '}';
    }
}
