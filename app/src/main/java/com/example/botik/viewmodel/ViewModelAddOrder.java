package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelOrder;
import com.example.botik.model.ModelPay;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelAddOrder extends ViewModel {
    public MutableLiveData<ModelOrder> mutableinfo=new MutableLiveData();
    public MutableLiveData<List<ModelPay>> muableprice=new MutableLiveData();

    public void AddOrder(String token,String address){
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().AddOrder(token,address), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableinfo.setValue((ModelOrder) object);
            }
        });

        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Pay(), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                muableprice.setValue((List)object);
            }
        });
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
