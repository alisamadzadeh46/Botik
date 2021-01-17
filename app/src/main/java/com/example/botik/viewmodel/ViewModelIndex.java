package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.botik.model.ModelIndex;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelIndex extends ViewModel {
    public MutableLiveData<List<ModelIndex>> mutableLiveDataPost = new MutableLiveData();

    public void Post() {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().SinglePost(), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveDataPost.setValue((List) object);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
