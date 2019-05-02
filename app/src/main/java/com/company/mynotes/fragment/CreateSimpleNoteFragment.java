package com.company.mynotes.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.mynotes.BaseFragment;
import com.company.mynotes.R;
import com.company.mynotes.util.DateTimeUtils;
import com.company.mynotes.util.Ui;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;

import static android.widget.CompoundButton.*;

public class CreateSimpleNoteFragment extends BaseFragment {

    private TextView tvNoteCreateDate;
    private ImageView ivIsImportant;
    private EditText etTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        showToolbar(false);
        View view = inflater.inflate(R.layout.fragment_create_note, container, false);
        tvNoteCreateDate = view.findViewById(R.id.tv_note_create_date);

        Handler timerHandler = new Handler();
        Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
                tvNoteCreateDate.setText(DateTimeUtils.getStringTime(new Date(System.currentTimeMillis())));
                timerHandler.postDelayed(this, 1000);
            }
        };
        timerHandler.post(timerRunnable);

        ivIsImportant = view.findViewById(R.id.iv_is_important);
        etTitle = view.findViewById(R.id.et_title);

        new Handler().postDelayed(() -> Ui.showKeyboard(context, etTitle), 100);

        AppCompatCheckBox checkBoxIsImportant = view.findViewById(R.id.ch_bx_is_important);
        checkBoxIsImportant.setOnCheckedChangeListener(isImportantListener);

        AppCompatCheckBox checkBoxHideTitle = view.findViewById(R.id.ch_bx_hide_title);
        checkBoxHideTitle.setOnCheckedChangeListener(hideTitleListener);

        return view;
    }

    private OnCheckedChangeListener isImportantListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ivIsImportant.setVisibility(View.VISIBLE);
            } else {
                ivIsImportant.setVisibility(View.GONE);
            }
        }
    };

    private OnCheckedChangeListener hideTitleListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                etTitle.setVisibility(View.GONE);
            } else {
                etTitle.setVisibility(View.VISIBLE);
            }
        }
    };

}
