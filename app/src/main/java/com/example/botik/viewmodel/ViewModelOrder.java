package com.example.botik.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelListOrder;
import com.example.botik.model.Status;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelOrder extends ViewModel {
    public MutableLiveData<List<ModelListOrder>> mutablepost = new MutableLiveData();

    public void Order(String token) {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().order(token), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutablepost.setValue((List) object);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
