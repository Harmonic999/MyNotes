package com.company.mynotes;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

class FragmentBackStack {

    private final FragmentManager fragmentManager;
    private final int fragmentContainerID;

    FragmentBackStack(FragmentManager fragmentManager, int fragmentContainerID) {
        this.fragmentManager = fragmentManager;
        this.fragmentContainerID = fragmentContainerID;
    }

    private synchronized void set(Fragment fragment, boolean addToBackStack) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (!addToBackStack) {
            clear();
            transaction
                    .replace(fragmentContainerID, fragment, fragment.getClass().getSimpleName())
                    .commit();
        } else {
            transaction
                    .replace(fragmentContainerID, fragment)
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    void push(Fragment fragment) {
        set(fragment, true);
    }

    void replace(Fragment fragment) {
        set(fragment, false);
    }

    synchronized void pop() {
        fragmentManager.popBackStack();
    }

    synchronized void clear() {
        fragmentManager.popBackStack(null, POP_BACK_STACK_INCLUSIVE);
    }

}
