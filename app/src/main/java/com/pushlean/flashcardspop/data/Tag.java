package com.pushlean.flashcardspop.data;

import java.io.Serializable;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class Tag implements Serializable {

    String name;
    int color;

    public Tag(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

}
