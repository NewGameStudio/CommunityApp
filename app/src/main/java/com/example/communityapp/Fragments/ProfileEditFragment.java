package com.example.communityapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileEditFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_edit, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.save_btn).setVisible(true);
    }

    @Override
    public void onStart() {
        super.onStart();

        loadUserData();

        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        avatarView.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save_btn :
                saveUserData();
                NavigationMaster.navigate(getView(), R.id.action_profileEditFragment_to_nav_profile);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View view) {

    }

    private void loadUserData() {

        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        TextInputEditText profileName = getActivity().findViewById(R.id.edit_profile_name_edittext);
        TextInputEditText profileDesc = getActivity().findViewById(R.id.edit_profile_desc_edittext);

        avatarView.setImageBitmap(UserController.getAvatarImage());
        profileName.setText(UserController.getUsername());
        profileDesc.setText(UserController.getProfileDescription());
    }

    private void saveUserData() {
        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        TextInputEditText profileName = getActivity().findViewById(R.id.edit_profile_name_edittext);
        TextInputEditText profileDesc = getActivity().findViewById(R.id.edit_profile_desc_edittext);

        UserController.setUsername(profileName.getText().toString());
        UserController.setProfileDescription(profileDesc.getText().toString());
    }
}