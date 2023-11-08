package com.example.testfornota.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CountCharacter implements Comparable<CountCharacter> {

    private final char ch;

    private final int count;

    @Override
    public int compareTo(CountCharacter o) {
        if (count > o.count) {
            return -1;
        } else if (count < o.count) {
            return 1;
        } else {
            return Character.compare(ch, o.ch);
        }
    }
}
