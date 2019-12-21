package com.example.requesapp.modal;

import com.google.gson.annotations.SerializedName;

public class UserWrapper{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"UserWrapper{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}