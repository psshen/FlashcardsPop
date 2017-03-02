package com.pushlean.flashcardspop.data;

import java.io.Serializable;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class Card implements Serializable {

    String clue;
    String answer;

    public Card(String clue, String answer) {
        this.clue = clue;
        this.answer = answer;
    }

    public String getClue() {
        return clue;
    }

    public String getAnswer() {
        return answer;
    }

}
