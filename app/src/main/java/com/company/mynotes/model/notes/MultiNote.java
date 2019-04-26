package com.company.mynotes.model.notes;


public class MultiNote extends BaseNote {

    public MultiNote(String noteTitle) {
        super(noteTitle);
    }

    @Override
    public int getType() {
        return TYPE_MULTI;
    }

}
