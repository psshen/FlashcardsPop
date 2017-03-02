package com.pushlean.flashcardspop.data;

import java.io.Serializable;
import java.util.Set;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class Deck implements Serializable {

    String title;
    Set<Card> cards;
    Set<Tag> tags;
    boolean isFavorite;

    public Deck(String title, Set<Card> cards, Set<Tag> tags, boolean isFavorite) {
        this.title = title;
        this.cards = cards;
        this.tags = tags;
        this.isFavorite = isFavorite;
    }

    public String getTitle() {
        return title;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
