package com.example.testfornota.constant;

import com.example.testfornota.model.CountCharacter;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface CountCharacterData {

    Set<CountCharacter> EXPECT_COUNT_CHARACTER_SET =
            new TreeSet<>(List.of
                    (
                            new CountCharacter('z', 2),
                            new CountCharacter('Z', 1),
                            new CountCharacter('x', 4),
                            new CountCharacter('s', 2),
                            new CountCharacter('a', 2)
                    )
            );
    String CORRECT_STRING = "zxsaxxsxzZa";

    String INCORRECT_STRING_LENGTH_BIGGER_256 = "12erfdgsb5e112erfdgsb5e12erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;6ywHVUbUI;lkmflm;12erfdgsb5e12erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;6ywHVUbUI;lkmflm;2erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;12erfdgsb5e6ywHVUbUI;lkmflm;6ywHVUbUI;lkmflm;";

}
