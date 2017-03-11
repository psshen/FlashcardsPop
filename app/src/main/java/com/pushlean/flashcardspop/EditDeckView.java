package com.pushlean.flashcardspop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pushlean.flashcardspop.data.Deck;
import com.pushlean.flashcardspop.data.Tag;

import java.util.Set;

import me.gujun.android.taggroup.TagGroup;

public class EditDeckView extends AppCompatActivity {

    private TagGroup editTagGroup;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTagGroup = (TagGroup) findViewById(R.id.edit_tag_group);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cards);

        Intent intent = getIntent();
        Deck deck = (Deck) intent.getSerializableExtra("deck");

        Set<Tag> tags = deck.getTags();
        TagGroup.TagAttributes[] tagNames = new TagGroup.TagAttributes[tags.size()];
        int i = 0;
        for (Tag tag : tags) {
            tagNames[i++] = new TagGroup.TagAttributes(tag.getName(), tag.getColor());
        }
        editTagGroup.setTags(tagNames);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this, deck);
        recyclerView.setAdapter(cardAdapter);

        setTitle(deck.getTitle());
    }

}
