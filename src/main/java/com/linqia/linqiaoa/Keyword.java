package com.linqia.linqiaoa;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // map ID with primary key of the table in database
    private Integer id;
    @Column(nullable = false) // Value can't be empty
    private String textValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return Objects.equals(textValue, keyword.textValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textValue);
    }

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
