package com.company.mynotes.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.company.mynotes.BaseFragment;
import com.company.mynotes.R;
import com.company.mynotes.adapter.NotesAdapter;
import com.company.mynotes.model.notes.BaseNote;
import com.company.mynotes.model.notes.SimpleNote;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class NotesFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        showToolbar(true);
        setToolbarTitle(getString(R.string.notes));

        RecyclerView rvNotes = view.findViewById(R.id.rv_notes);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, 1);
        rvNotes.setLayoutManager(manager);

        //FIXME replace with real data
        List<BaseNote> notes = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            notes.add(new SimpleNote(null));
        }

        NotesAdapter notesAdapter = new NotesAdapter(notes);
        rvNotes.setAdapter(notesAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.notes_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_create) {
            pushFragment(new CreateSimpleNoteFragment());
        }

        return super.onOptionsItemSelected(item);
    }
}
