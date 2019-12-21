package com.example.requesapp.repository;

import com.example.requesapp.modal.ListUsers;
import com.example.requesapp.modal.User;
import com.example.requesapp.modal.UserWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApiService {

    //      users?page=1
    @GET("users")
    Call<ListUsers> getListOfUsers(@Query("page") int pageNo);


    //   https://reqres.in/api/users/1
    @GET("users/{id}")
    Call<UserWrapper> getUserFromID(@Path("id") int ID);
}
