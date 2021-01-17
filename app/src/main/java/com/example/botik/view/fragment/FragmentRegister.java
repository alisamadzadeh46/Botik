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
import com.example.botik.databinding.FragmentregisterBinding;
import com.example.botik.model.Status;
import com.example.botik.repository.Repository;
import com.example.botik.viewmodel.ViewModelRegister;
import com.sdsmdg.tastytoast.TastyToast;

public class FragmentRegister extends Fragment {
    FragmentregisterBinding binding;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentregisterBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelRegister viewmodel =new ViewModelProvider(this).get(ViewModelRegister.class);
        binding.setData(viewmodel);
        viewmodel.mutableLiveDataRegister.observe(requireActivity(), new Observer<Status>() {
            @Override
            public void onChanged(Status status) {
                if(status.getStatus().equals("ok")){
                    Repository.Shared_write(requireActivity(),status.getToken());
                    navController.navigate(R.id.action_fragmentRegister_to_fragmentProfile);
                }else
                {
                    TastyToast.makeText(requireActivity(), "نام کاربری وجود دارد لطفا وارد شوید", TastyToast.LENGTH_LONG,
                            TastyToast.WARNING);
                }
            }
        });
        viewmodel.mutableLiveDataLogin.observe(requireActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    navController.navigate(R.id.action_fragmentRegister_to_fragmentLogin);
                }
            }
        });
        return binding.getRoot();

    }
}
