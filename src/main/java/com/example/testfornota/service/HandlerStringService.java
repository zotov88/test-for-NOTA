package com.example.testfornota.service;

import com.example.testfornota.model.CountCharacter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HandlerStringService {

    private Map<Character, Integer> characterIntegerMap;

    public Set<CountCharacter> handlerString(final String string) {
        characterIntegerMap = new TreeMap<>();
        Set<CountCharacter> frequencyDictionary = new TreeSet<>();

        for (int i = 0; i < string.length(); i++) {
            fillCharacterIntegerMap(string.charAt(i));
        }
        for (Character c : characterIntegerMap.keySet()) {
            frequencyDictionary.add(new CountCharacter(c, characterIntegerMap.get(c)));
        }
        return frequencyDictionary;
    }

    private void fillCharacterIntegerMap(char ch) {
        if (!characterIntegerMap.containsKey(ch)) {
            characterIntegerMap.put(ch, 1);
        } else {
            characterIntegerMap.put(ch, characterIntegerMap.get(ch) + 1);
        }
    }
}
