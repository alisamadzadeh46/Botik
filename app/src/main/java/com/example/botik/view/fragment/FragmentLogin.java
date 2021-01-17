package com.example.botik.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.botik.R;
import com.example.botik.databinding.FragmentloginBinding;
import com.example.botik.model.Status;
import com.example.botik.repository.Repository;
import com.example.botik.viewmodel.ViewModelLogin;
import com.sdsmdg.tastytoast.TastyToast;

public class FragmentLogin extends Fragment {

    FragmentloginBinding binding;
    NavController navController;
    private static final String TAG = "Fragment_login";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentloginBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelLogin viewmodel =new ViewModelProvider(this).get(ViewModelLogin.class);
        binding.setData(viewmodel);
        viewmodel.mutableLiveDataLogin.observe(requireActivity(), new Observer<Status>() {
            @Override
            public void onChanged(Status status) {
                if(status.getStatus().equals("ok")){
                    Repository.Shared_write(requireActivity(),status.getToken());
                    navController.navigate(R.id.action_fragmentLogin_to_fragmentProfile);
                }else
                {
                    TastyToast.makeText(requireActivity(), "نام کاربری یا رمز عبور اشتباه است", TastyToast.LENGTH_LONG,
                            TastyToast.WARNING);
                }
            }
        });
        viewmodel.mutableLiveDataRegister.observe(requireActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    navController.navigate(R.id.action_fragmentLogin_to_fragmentRegister);
                }
            }
        });

        return binding.getRoot();
    }

}
