package com.example.requesapp.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.requesapp.modal.Data;
import com.example.requesapp.modal.ListUsers;
import com.example.requesapp.modal.User;
import com.example.requesapp.modal.UserWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListUserRepository {

    private MutableLiveData<List<User>> listMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Data> userMutableLiveData = new MutableLiveData<>();

    private Application application;

    public ListUserRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<User>> getGetListOfUserByPage(int pageNo) {
        RestApiService restApiService = RetrofitInstance.getRetrofitApiService();
        Call<ListUsers> usersCall = restApiService.getListOfUsers(pageNo);
        usersCall.enqueue(new Callback<ListUsers>() {
            @Override
            public void onResponse(Call<ListUsers> call, Response<ListUsers> response) {
                ListUsers userList = response.body();
                if (userList != null && userList.getData() != null) {
                    listMutableLiveData.setValue(userList.getData());
                }

            }

            @Override
            public void onFailure(Call<ListUsers> call, Throwable t) {

            }
        });

        return listMutableLiveData;
    }


    public MutableLiveData<Data> getUserFromID(int userNo) {
        RestApiService restApiService = RetrofitInstance.getRetrofitApiService();
        restApiService.getUserFromID(userNo).enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                UserWrapper user = response.body();
                if (user != null && user.getData() != null) {
                    userMutableLiveData.setValue(user.getData());
                }

            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });

        return userMutableLiveData;
    }


}
