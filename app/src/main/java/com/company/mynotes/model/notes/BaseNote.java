package com.company.mynotes.model.notes;

public abstract class BaseNote {

    protected String noteTitle;

    public BaseNote(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public static final int TYPE_SIMPLE = 0;
    public static final int TYPE_MULTI = 1;

    public abstract int getType();

}
