package com.example.communityapp.Fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.Entities.Review;
import com.example.communityapp.Entities.User;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;

import java.util.List;

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.settings_btn:
                NavigationMaster.navigate(getView(), R.id.action_nav_profile_to_profileEditFragment);
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        loadUserData();
    }

    private void loadUserData() {

        CircleImageView avatarView = getView().findViewById(R.id.profile_avatar);
        TextView profileName = getView().findViewById(R.id.profile_name_label);
        TextView profileDesc = getView().findViewById(R.id.profile_desc_label);
        Button ratingBtn = getView().findViewById(R.id.rating_btn);

        User user = UserController.getUser();
        List<Review> reviews = UserController.findUserReviews(user.getId());

        avatarView.setImageBitmap(user.getAvatar());
        profileName.setText(user.getUsername());
        profileDesc.setText(user.getDescription());
        ratingBtn.setText(Integer.toString(reviews.size()));
    }
}
