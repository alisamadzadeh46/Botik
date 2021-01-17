package com.example.botik.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.ModelDetails;
import com.example.botik.model.ModelIndex;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;

import java.util.List;

public class ViewModelDetails extends ViewModel {
    public MutableLiveData<ModelDetails> mutableLiveDataPost = new MutableLiveData();

    public void PostDetails(String id) {
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().ApiDetails(id), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveDataPost.setValue((ModelDetails) object);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
