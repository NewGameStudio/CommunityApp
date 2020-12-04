package com.example.communityapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Masters.NavigationMaster;
import com.example.communityapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignInFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();

        BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigation.setVisibility(View.GONE);

        MaterialButton signinButton = getActivity().findViewById(R.id.signin_btn);
        signinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.signin_btn:

                TextInputLayout usernameLayout = getActivity().findViewById(R.id.signin_username_input);
                String username = usernameLayout.getEditText().getText().toString();

                TextInputLayout passwordLayout = getActivity().findViewById(R.id.signin_password_input);
                String password = passwordLayout.getEditText().getText().toString();

                if (UserController.login(username, password)) {

                    BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottom_navigation);

                    bottomNavigation.setVisibility(View.VISIBLE);

                    NavigationMaster.navigate(getView(), R.id.action_signInFragment_to_profileFragment);

                } else
                    passwordLayout.setError("Неверный логин или пароль");

                break;
        }
    }
}
