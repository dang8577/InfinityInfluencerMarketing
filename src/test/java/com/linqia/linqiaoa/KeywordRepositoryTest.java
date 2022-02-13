package com.linqia.linqiaoa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
/*
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Run Test directly on MySQL database not in Memory Database
*/
@Rollback(false)
public class KeywordRepositoryTest {
    @Autowired
    private KeywordRepository repo;
    @Test
    public void testListKeywords(){
        Iterable<Keyword> iterable = repo.findAll();
        iterable.forEach(System.out::println);

    }


    @Test
    public void testInsertKeywords(){
        Keyword newKeyword = new Keyword();
        newKeyword.setTextValue("testValue");
        repo.save(newKeyword);
    }
}

