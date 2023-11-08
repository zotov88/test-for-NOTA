package com.example.testfornota.controller;

import com.example.testfornota.model.CountCharacter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static com.example.testfornota.constant.CountCharacterData.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback(value = false)
public class HandlerStringControllerTest {

    @Autowired
    private HandlerStringController handlerStringController;

    @Test
    @Order(0)
    public void handleCorrectString() {
        ResponseEntity<Set<CountCharacter>> responseEntity = handlerStringController.handler(CORRECT_STRING);
        assertNotNull(responseEntity);
        assertFalse(biggerThanCorrectString(CORRECT_STRING));
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(EXPECT_COUNT_CHARACTER_SET, responseEntity.getBody());
    }

    @Test
    @Order(1)
    public void handleIncorrectString() {
        ResponseEntity<Set<CountCharacter>> responseEntity = handlerStringController.handler(INCORRECT_STRING_LENGTH_BIGGER_256);
        assertNotNull(responseEntity);
        assertTrue(biggerThanCorrectString(INCORRECT_STRING_LENGTH_BIGGER_256));
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

    }

    private boolean biggerThanCorrectString(String str) {
        return str.length() > 256;
    }
}
