package com.example.requesapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.requesapp.viewmodal.UserViewModal;

public class UserActivity extends AppCompatActivity {
    UserViewModal userViewModal;

    TextView tvID, tvFirstName, tvLastName, tvEmail;
    ImageView ivThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tvID = findViewById(R.id.tvIDUser);
        tvFirstName = findViewById(R.id.firstNameUser);
        tvLastName = findViewById(R.id.lastNameUser);
        tvEmail = findViewById(R.id.emailUser);
        ivThumbnail = findViewById(R.id.ivAvatarUser);

        int userID = getIntent().getExtras().getInt("userID", 1);
        userViewModal = ViewModelProviders.of(this).get(UserViewModal.class);
        userViewModal.getUserLiveDataByID(userID).observe(this, user -> {
            tvID.setText(String.valueOf(user.getId()));
            tvEmail.setText(String.valueOf(user.getEmail()));
            tvFirstName.setText(String.valueOf(user.getFirstName()));
            tvLastName.setText(String.valueOf(user.getLastName()));
            Glide.with(this)
                    .load(String.valueOf(user.getAvatar()))
                    .into(ivThumbnail);
        });

    }
}
