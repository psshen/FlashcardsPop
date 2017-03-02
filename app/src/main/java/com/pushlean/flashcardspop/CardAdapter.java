package com.pushlean.flashcardspop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pushlean.flashcardspop.data.Card;
import com.pushlean.flashcardspop.data.Deck;
import com.pushlean.flashcardspop.databinding.CardListItemBinding;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterViewHolder> {

    private final Context context;
    private Deck deck;
    private Card[] cards;

    public CardAdapter(Context context, Deck deck) {
        this.context = context;
        this.deck = deck;
        cards = deck.getCards().toArray(new Card[deck.getCards().size()]);
    }

    @Override
    public CardAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CardListItemBinding binding = CardListItemBinding.inflate(layoutInflater, parent, false);
        return new CardAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CardAdapterViewHolder holder, int position) {
        Card card = cards[position];
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return cards.length;
    }

    class CardAdapterViewHolder extends RecyclerView.ViewHolder {

        private CardListItemBinding binding;

        CardAdapterViewHolder(CardListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Card card) {
            binding.clue.setText(card.getClue());
            binding.answer.setText(card.getAnswer());
        }

    }

}
