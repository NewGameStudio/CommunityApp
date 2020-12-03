package com.example.communityapp.Masters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentMaster {

    private static FragmentManager fragmentManager;

    public static void setFragmentManager(FragmentManager fragmentManager) {
        FragmentMaster.fragmentManager = fragmentManager;
    }

    public static void setFragment(int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }
}
