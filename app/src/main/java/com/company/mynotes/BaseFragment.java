package com.company.mynotes;

import android.content.Context;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private MainActivity activity;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        this.activity = (MainActivity) context;
    }

    protected void pushFragment(BaseFragment fragment) {
        activity.getFragmentStack().push(fragment);
    }

    protected void replaceFragment(BaseFragment fragment) {
        activity.getFragmentStack().replace(fragment);
    }

    protected void setToolbarTitle(String title) {
        activity.toolbar(title);
    }
}
