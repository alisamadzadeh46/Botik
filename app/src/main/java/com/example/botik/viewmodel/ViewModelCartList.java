package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelGetCart;
import com.example.botik.model.Price;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelCartList extends ViewModel {
    public MutableLiveData<List<ModelGetCart>> mutableinfo = new MutableLiveData();
    public MutableLiveData<List<Price>> muableprice = new MutableLiveData();

    public void Cart(String token) {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Listcart(token), object -> mutableinfo.setValue((List)object));

        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_sumprice(token), object -> muableprice.setValue((List)object));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
