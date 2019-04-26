package com.company.mynotes.model.notes;


public class SimpleNote extends BaseNote {

    public SimpleNote(String noteTitle) {
        super(noteTitle);
    }

    @Override
    public int getType() {
        return TYPE_SIMPLE;
    }

}
