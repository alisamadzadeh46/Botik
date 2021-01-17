package com.example.botik.viewmodel;

import com.example.botik.model.ModelUserInfo;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelUserInfo extends ViewModel {
   public MutableLiveData<List<ModelUserInfo>> mutableinfo=new MutableLiveData();
    public void UserInfo(String token) {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().UserInfo(token), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableinfo.setValue((List) object);
            }
        });
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
