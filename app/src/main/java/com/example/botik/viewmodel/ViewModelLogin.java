package com.example.botik.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.example.botik.model.Status;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;
import com.sdsmdg.tastytoast.TastyToast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModelLogin extends AndroidViewModel {
    public MutableLiveData<Status> mutableLiveDataLogin=new MutableLiveData();
    public MutableLiveData<Boolean> mutableLiveDataRegister=new MutableLiveData();
    public String username=null;
    public String password=null;
    Application application;
    public ViewModelLogin(@NonNull Application application) {
        super(application);
        this.application=application;
    }

    public void Login(View view){
        if(username==null){
            TastyToast.makeText(application.getApplicationContext(), "نام کاربری را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        else if(password==null){
            TastyToast.makeText(application.getApplicationContext(), "نام کاربری را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);

        }
        else{
            Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Login(username,password), new Repository.Unit() {
                @Override
                public void invoke(Object object) {
                    mutableLiveDataLogin.setValue((Status) object);
                }
            });
        }
    }

    public void Register(View view){
        mutableLiveDataRegister.setValue(true);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }



}
