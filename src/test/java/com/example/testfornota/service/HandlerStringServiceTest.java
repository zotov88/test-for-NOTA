package com.example.testfornota.service;

import com.example.testfornota.model.CountCharacter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static com.example.testfornota.constant.CountCharacterData.CORRECT_STRING;
import static com.example.testfornota.constant.CountCharacterData.EXPECT_COUNT_CHARACTER_SET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback(value = false)
public class HandlerStringServiceTest {

    @Autowired
    private HandlerStringService handlerStringService;

    @Test
    public void handleCorrectString() {
        Set<CountCharacter> countCharacterSet = handlerStringService.handlerString(CORRECT_STRING);
        assertNotNull(countCharacterSet);
        assertEquals(countCharacterSet, EXPECT_COUNT_CHARACTER_SET);
    }
}
