package com.example.requesapp.viewmodal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.requesapp.modal.User;
import com.example.requesapp.repository.ListUserRepository;

import java.util.List;

public class MainViewModal extends AndroidViewModel {
    ListUserRepository listUserRepository;


    public MainViewModal(@NonNull Application application) {
        super(application);

        listUserRepository = new ListUserRepository(application);
    }


    public LiveData<List<User>> getListOfUsers(int pageNo) {
        return listUserRepository.getGetListOfUserByPage(pageNo);
    }

}
