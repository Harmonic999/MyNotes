package com.company.mynotes.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.mynotes.BaseFragment;
import com.company.mynotes.R;
import com.company.mynotes.util.Constants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CreateNoteFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_note, container, false);
        setToolbarTitle(Constants.EMPTY);


        return view;
    }

}
