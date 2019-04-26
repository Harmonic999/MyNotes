package com.company.mynotes.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.mynotes.BaseFragment;
import com.company.mynotes.R;
import com.company.mynotes.util.DateTimeUtils;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CreateSimpleNoteFragment extends BaseFragment {

    private TextView tvNoteCreateDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        showToolbar(false);
        View view = inflater.inflate(R.layout.fragment_create_note, container, false);
        tvNoteCreateDate = view.findViewById(R.id.tv_note_create_date);
        tvNoteCreateDate.setText(DateTimeUtils.getStringTime(new Date(System.currentTimeMillis())));
        return view;
    }

}
