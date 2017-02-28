package com.pushlean.flashcardspop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pushlean.flashcardspop.data.Deck;
import com.pushlean.flashcardspop.databinding.DeckListItemBinding;

/**
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.DeckAdapterViewHolder> {

    private Deck[] decks = new Deck[] {
            new Deck("Tutorial", null, null, false),
            new Deck("Spanish", null, null, true)
    };

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
        }

    }

}

