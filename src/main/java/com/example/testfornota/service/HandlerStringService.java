package com.example.testfornota.service;

import com.example.testfornota.model.CountCharacter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

@Service
public class HandlerStringService {

    private Map<Character, Integer> countOfCharactersMap;

    public Set<CountCharacter> handlerString(final String string) {
        countOfCharactersMap = new TreeMap<>();
        Set<CountCharacter> frequencyDictionarySet = new TreeSet<>();

        for (int i = 0; i < string.length(); i++) {
            fillCountOfCharactersMap(string.charAt(i));
        }
        for (Character c : countOfCharactersMap.keySet()) {
            frequencyDictionarySet.add(new CountCharacter(c, countOfCharactersMap.get(c)));
        }
        return frequencyDictionarySet;
    }

    private void fillCountOfCharactersMap(char ch) {
        if (!countOfCharactersMap.containsKey(ch)) {
            countOfCharactersMap.put(ch, 1);
        } else {
            countOfCharactersMap.put(ch, countOfCharactersMap.get(ch) + 1);
        }
    }
}
