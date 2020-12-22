package com.example.communityapp.Fragments.Authorization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class SignInFragment extends Fragment implements View.OnClickListener {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigation;
    private MaterialButton signinButton;

    private TextInputLayout usernameLayout;
    private TextInputLayout passwordLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();
        findFragmentElements();


        toolbar.setVisibility(View.GONE);
        bottomNavigation.setVisibility(View.GONE);
        signinButton.setOnClickListener(this);
    }

    private void findFragmentElements() {
        toolbar = getActivity().findViewById(R.id.toolbar);
        bottomNavigation = getActivity().findViewById(R.id.bottom_navigation);
        signinButton = getActivity().findViewById(R.id.signin_btn);

        usernameLayout = getView().findViewById(R.id.signin_username_input);
        passwordLayout = getView().findViewById(R.id.signin_password_input);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.signin_btn) {

            String username = usernameLayout.getEditText().getText().toString();
            String password = passwordLayout.getEditText().getText().toString();

            if (!UserController.login(username, password)) {
                passwordLayout.setError("Неверный логин или пароль");
                return;
            }

            bottomNavigation.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.VISIBLE);

            NavigationMaster.navigate(getView(), R.id.action_signInFragment_to_profileFragment);
        }
    }
}
