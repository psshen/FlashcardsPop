package com.pushlean.flashcardspop;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Sets;
import com.pushlean.flashcardspop.data.Card;
import com.pushlean.flashcardspop.data.Deck;
import com.pushlean.flashcardspop.data.Tag;
import com.pushlean.flashcardspop.databinding.DeckListItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.gujun.android.taggroup.TagGroup;

/**
 * Copyright 2017 Paul Shen. Licensed under the Apache License, Version 2.0.
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.DeckAdapterViewHolder> {

    private Deck[] decks = new Deck[]{
            new Deck("Tutorial",
                    Sets.newHashSet(new Card("Edit deck", "Click deck"), new Card("Add deck", "Click add button")),
                    Sets.newHashSet(new Tag("Tutorials", Color.BLUE), new Tag("Learning", Color.RED)),
                    false),
            new Deck("Spanish",
                    null,
                    null,
                    true)
    };
    private final Context context;

    private DeckAdapterOnClickHandler onClickHandler;
    public interface DeckAdapterOnClickHandler {
        void onClick(Deck deck);
    }

    public DeckAdapter(Context context, DeckAdapterOnClickHandler onClickHandler) {
        this.context = context;
        this.onClickHandler = onClickHandler;
    }

    @Override
    public DeckAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
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

    class DeckAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DeckListItemBinding binding;

        public DeckAdapterViewHolder(DeckListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        public void bind(Deck deck) {
            binding.deckTitle.setText(deck.getTitle());
            String deckSize = String.valueOf(deck.getCards() != null ? deck.getCards().size() : 0);
            binding.deckSize.setText(deckSize);
            binding.starToggle.setChecked(deck.isFavorite());

            Set<Tag> tags = deck.getTags();
            if (tags != null) {
                TagGroup tagContainer = binding.tagContainer;
                TagGroup.TagAttributes[] tagNames = new TagGroup.TagAttributes[tags.size()];
                int i = 0;
                for (Tag tag : tags) {
                    tagNames[i++] = new TagGroup.TagAttributes(tag.getName(), tag.getColor());
                }
                tagContainer.setTags(tagNames);
            }
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Deck deck = decks[adapterPosition];
            onClickHandler.onClick(deck);
        }

    }

}

