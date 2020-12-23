package com.example.communityapp.Fragments.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Adapter.ReviewAdapter;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.ReviewsDataContainer;
import com.example.communityapp.Entities.Review;
import com.example.communityapp.Entities.User;
import com.example.communityapp.R;

import java.util.List;

public class ReviewsListFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reviews_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        initializeRecyclerView();

        User user = ReviewsDataContainer.getCurrentUser();
        List<Review> reviews = UserController.findAboutUserReviews(user.getId());

        RecyclerView.Adapter recyclerAdapter = new ReviewAdapter(reviews);

        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initializeRecyclerView() {
        recyclerView = getView().findViewById(R.id.review_recycler);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}
