package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelListOrder;
import com.example.botik.model.ModelShowData;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelShowData extends ViewModel {
    public MutableLiveData<List<ModelShowData>> mutableLiveData = new MutableLiveData();
    public void ShowData(String token) {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().ShowData(token), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveData.setValue((List) object);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
