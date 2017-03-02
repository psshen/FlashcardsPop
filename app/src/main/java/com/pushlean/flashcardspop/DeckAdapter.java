package com.pushlean.flashcardspop;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.common.collect.Sets;
import com.pushlean.flashcardspop.data.Card;
import com.pushlean.flashcardspop.data.Deck;
import com.pushlean.flashcardspop.data.Tag;
import com.pushlean.flashcardspop.databinding.DeckListItemBinding;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.DeckAdapterViewHolder> {

    private Deck[] decks = new Deck[]{
            new Deck("Tutorial",
                    Sets.newHashSet(new Card(), new Card()),
                    Sets.newHashSet(new Tag("Tutorials", Color.BLUE), new Tag("Learning", Color.RED)),
                    false),
            new Deck("Spanish",
                    null,
                    null,
                    true)
    };
    private final Context context;

    public DeckAdapter(Context context) {
        this.context = context;
    }

    @Override
    public DeckAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DeckListItemBinding binding = DeckListItemBinding.inflate(layoutInflater, parent, false);
        return new DeckAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DeckAdapterViewHolder holder, int position) {
        Deck deck = decks[position];
        holder.bind(deck);
    }

    @Override
    public int getItemCount() {
        return decks.length;
    }

    class DeckAdapterViewHolder extends RecyclerView.ViewHolder {

        private DeckListItemBinding binding;

        public DeckAdapterViewHolder(DeckListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Deck deck) {
            binding.deckTitle.setText(deck.getTitle());
            String deckSize = String.valueOf(deck.getCards() != null ? deck.getCards().size() : 0);
            binding.deckSize.setText(deckSize);
            binding.starToggle.setChecked(deck.isFavorite());

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            if (deck.getTags() != null) {
                for (Tag tag : deck.getTags()) {
                    tag.createTextView(layoutInflater, binding.tagContainer);
                }
            }
        }

    }

}

