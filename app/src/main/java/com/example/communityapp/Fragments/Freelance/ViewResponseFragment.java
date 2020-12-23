package com.example.communityapp.Fragments.Freelance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.communityapp.Controllers.FreelanceTasksController;
import com.example.communityapp.Controllers.UserController;
import com.example.communityapp.DataContainers.FreelanceFragmentsDataContainer;
import com.example.communityapp.DataContainers.MessengerFragmentsDataContainer;
import com.example.communityapp.Entities.ChatRoom;
import com.example.communityapp.Entities.Response;
import com.example.communityapp.Entities.User;
import com.example.communityapp.Master.NavigationMaster;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

public class ViewResponseFragment extends Fragment implements View.OnClickListener {

    private User responseOwner;
    private Response response;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.freelance_view_task_response, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        response = FreelanceFragmentsDataContainer.getCurrentViewResponse();
        responseOwner = UserController.findUserById(response.getOwnerId());

        Button openChatBtn = getView().findViewById(R.id.open_chat_btn);
        openChatBtn.setOnClickListener(this);

        Button appointExecutorBtn = getView().findViewById(R.id.appoint_as_executor_btn);
        appointExecutorBtn.setOnClickListener(this);

        TextView responseOwnerName = getView().findViewById(R.id.response_owner_name);
        TextView responseDescription = getView().findViewById(R.id.response_description);
        TextView responseComplDate = getView().findViewById(R.id.response_compl_date);
        TextView responsePrice = getView().findViewById(R.id.response_price);

        responseOwnerName.setText(responseOwner.getUsername());
        responseDescription.setText(response.getDescription());
        responseComplDate.setText("Дата выполнения: " +
                DateUtil.standardDateToString(response.getCompletionDate()));
        responsePrice.setText(Integer.toString(response.getPrice()));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.open_chat_btn) {

            int userId = UserController.getUser().getId();

            ChatRoom chatRoom = UserController.findChatRoomOrCreateNew(userId, responseOwner.getId());
            MessengerFragmentsDataContainer.setChatRoom(chatRoom);

            NavigationMaster.navigate(getView(), R.id.action_viewResponseFragment_to_chatRoomFragment);

        } else if(view.getId() == R.id.appoint_as_executor_btn) {
            FreelanceTasksController.appointAsExecutor(response.getTaskId(), responseOwner.getId());
            Toast.makeText(getContext(), "Исполнитель назначен", Toast.LENGTH_SHORT).show();
            NavigationMaster.navigate(getView(), R.id.action_viewResponseFragment_to_nav_freelance);
        }
    }
}
