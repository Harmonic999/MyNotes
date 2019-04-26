package com.company.mynotes.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.mynotes.R;
import com.company.mynotes.model.notes.BaseNote;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteHolder> {

    private List<BaseNote> baseNotes;

    public NotesAdapter(@NonNull List<BaseNote> baseNotes) {
        this.baseNotes = baseNotes;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View holderView;

        switch (viewType) {
            case BaseNote.TYPE_SIMPLE:
                holderView = inflater.inflate(R.layout.simple_note, parent, false);
                return new SimpleNoteHolder(holderView);

            default:
                holderView = inflater.inflate(R.layout.multi_note, parent, false);
                return new MultiNoteHolder(holderView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        BaseNote note = baseNotes.get(position);

        switch (note.getType()) {
            case BaseNote.TYPE_SIMPLE:

                break;

            case BaseNote.TYPE_MULTI:

                break;
        }

    }

    @Override
    public int getItemCount() {
        return baseNotes.size();
    }

    abstract class NoteHolder extends RecyclerView.ViewHolder {
        NoteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class SimpleNoteHolder extends NoteHolder {
        SimpleNoteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class MultiNoteHolder extends NoteHolder {
        MultiNoteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return baseNotes.get(position).getType();
    }
}
