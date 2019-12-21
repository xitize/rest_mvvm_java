package com.example.requesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.requesapp.R;
import com.example.requesapp.modal.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    private List<User> userList;

    private ClickListenerInterface clickListenerInterface;


    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void ItemOnClickListnererPosition(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {

        holder.tvID.setText(String.valueOf(userList.get(position).getId()));
        holder.tvFirstName.setText(String.valueOf(userList.get(position).getFirstName()));
        holder.tvLastName.setText(String.valueOf(userList.get(position).getLastName()));
        holder.tvEmail.setText(String.valueOf(userList.get(position).getEmail()));
        Glide.with(holder.context)
                .load(String.valueOf(userList.get(position).getAvatar()))
                .into(holder.ivThumbnail);
        holder.itemView.setOnClickListener(v -> clickListenerInterface.getClickListener(userList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvID, tvFirstName, tvLastName, tvEmail;
        ImageView ivThumbnail;
        Context context;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvIDUserItem);
            tvFirstName = itemView.findViewById(R.id.firstNameUserItem);
            tvLastName = itemView.findViewById(R.id.lastNameUserItem);
            tvEmail = itemView.findViewById(R.id.emailUserItem);
            ivThumbnail = itemView.findViewById(R.id.ivAvatarUserItem);
            context = itemView.getContext();
        }
    }


    public interface ClickListenerInterface {
        void getClickListener(int userID);
    }
}
