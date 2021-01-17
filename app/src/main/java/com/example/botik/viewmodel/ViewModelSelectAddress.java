package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelSelectAddress;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelSelectAddress extends ViewModel {
    public MutableLiveData<List<ModelSelectAddress>> mutableLiveDataSelectAddress=new MutableLiveData();
    public void Address(String token){
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().SelectAddress(token), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveDataSelectAddress.setValue((List)object);
            }
        });
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
