package com.example.botik.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.botik.model.Status;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.repository.SingleTon;
import com.sdsmdg.tastytoast.TastyToast;


public class ViewModelEdit extends AndroidViewModel {
    public MutableLiveData<Status> mutableLiveDataEdit = new MutableLiveData();
    public String token = null;
    public String address = null;
    public String codeposti = null;
    public String phone = null;
    public String phonesabet = null;
    Application application;

   public ViewModelEdit(Application application){
       super(application);
       this.application=application;
   }

    public void Edit(View view) {
        if (address == null) {
            TastyToast.makeText(application.getApplicationContext(), "لطفا آدرس را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        } else if (codeposti == null) {
            TastyToast.makeText(application.getApplicationContext(), " لطفا کد پستی را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        else if (phone==null){
            TastyToast.makeText(application.getApplicationContext(), " لطفا شماره موبایل را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        else if (phone.length()>=12){
            TastyToast.makeText(application.getApplicationContext(), " لطفا شماره موبایل معتبر  وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        else if (phone.length()<11){
            TastyToast.makeText(application.getApplicationContext(), " لطفا شماره موبایل معتبر  وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }
        else if (phonesabet==null){
            TastyToast.makeText(application.getApplicationContext(), " لطفا شماره ثابت را وارد کنید", TastyToast.LENGTH_LONG,
                    TastyToast.WARNING);
        }

        Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Edit(token,address,codeposti,phone,phonesabet), new Repository.Unit() {
            @Override
            public void invoke(Object object) {
                mutableLiveDataEdit.setValue((Status) object);
            }
        });
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        SingleTon.com().clear();
    }
}
