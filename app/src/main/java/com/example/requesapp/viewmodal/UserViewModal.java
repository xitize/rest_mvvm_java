package com.example.requesapp.viewmodal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.requesapp.modal.Data;
import com.example.requesapp.repository.ListUserRepository;

public class UserViewModal extends AndroidViewModel {

    private ListUserRepository listUserRepository;

    public UserViewModal(@NonNull Application application) {
        super(application);
        listUserRepository = new ListUserRepository(application);
    }

    public LiveData<Data> getUserLiveDataByID(int userID) {
        return listUserRepository.getUserFromID(userID);
    }

}
