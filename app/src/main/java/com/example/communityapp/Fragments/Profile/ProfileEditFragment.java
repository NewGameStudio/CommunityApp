package com.example.communityapp.Fragments.Profile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class ProfileEditFragment extends Fragment implements View.OnClickListener {

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;


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
    public void onStart() {
        super.onStart();

        loadUserData();

        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        avatarView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.edit_profile_avatar:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    int selfPermission = getActivity()
                            .checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

                    if (selfPermission == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = { Manifest.permission.READ_EXTERNAL_STORAGE };
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else
                        pickAvatarFromGallery();

                } else
                    pickAvatarFromGallery();

                break;
        }
    }


    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.save_btn).setVisible(true);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case PERMISSION_CODE:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    pickAvatarFromGallery();
                else
                    Toast.makeText(getActivity(), "Доступ запрещён...", Toast.LENGTH_SHORT).show();

                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            Uri imageUri = data.getData();

            CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);

            avatarView.setImageURI(imageUri);
        }
    }


    private void loadUserData() {

        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        TextInputEditText profileName = getActivity().findViewById(R.id.edit_profile_name_edittext);
        TextInputEditText profileDesc = getActivity().findViewById(R.id.edit_profile_desc_edittext);

        avatarView.setImageBitmap(UserController.getAvatarImage());
        profileName.setText(UserController.getUsername());
        profileDesc.setText(UserController.getProfileDescription());
    }

    private void pickAvatarFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        getActivity().startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    private void saveUserData() {
        CircleImageView avatarView = getActivity().findViewById(R.id.edit_profile_avatar);
        TextInputEditText profileName = getActivity().findViewById(R.id.edit_profile_name_edittext);
        TextInputEditText profileDesc = getActivity().findViewById(R.id.edit_profile_desc_edittext);

        UserController.setUsername(profileName.getText().toString());
        UserController.setProfileDescription(profileDesc.getText().toString());
    }
}