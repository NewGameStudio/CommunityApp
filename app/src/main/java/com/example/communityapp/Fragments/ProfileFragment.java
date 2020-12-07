package com.example.communityapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.settings_btn).setVisible(true);
    }

    @Override
    public void onStart() {
        super.onStart();

        loadUserData();
    }

    private void loadUserData() {

        CircleImageView avatarView = getActivity().findViewById(R.id.profile_avatar);
        TextView profileName = getActivity().findViewById(R.id.profile_name_label);
        TextView profileDesc = getActivity().findViewById(R.id.profile_desc_label);

        avatarView.setImageBitmap(UserController.getAvatarImage());
        profileName.setText(UserController.getName());
        profileDesc.setText(UserController.getProfileDescription());
    }
}
