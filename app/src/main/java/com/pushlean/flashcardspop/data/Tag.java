package com.pushlean.flashcardspop.data;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pushlean.flashcardspop.R;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class Tag {

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

    public void createTextView(LayoutInflater layoutInflater, ViewGroup parent) {
        TextView textView = (TextView) layoutInflater.inflate(R.layout.tag_text_view, parent, false);
        textView.setText(getName());
        textView.setBackgroundColor(getColor());
        parent.addView(textView);
    }
}
