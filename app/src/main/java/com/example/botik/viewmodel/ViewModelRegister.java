package com.example.botik.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botik.model.Status;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;
import com.sdsmdg.tastytoast.TastyToast;


public class ViewModelRegister extends AndroidViewModel {
    public MutableLiveData<Status> mutableLiveDataRegister = new MutableLiveData();
    public MutableLiveData<Boolean> mutableLiveDataLogin = new MutableLiveData();
    public String username = null;
    public String password = null;
    Application application;

   public ViewModelRegister(Application application){
       super(application);
       this.application=application;
   }

    public void Register(View view) {
        if (username == null) {
            TastyToast.makeText(application.getApplicationContext(), "نام کاربری را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        } else if (password == null) {
            TastyToast.makeText(application.getApplicationContext(), "نام رمز عبور را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Register(username, password), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveDataRegister.setValue((Status) object);
            }
        });
    }

    public void Login(View view) {
        mutableLiveDataLogin.setValue(true);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
