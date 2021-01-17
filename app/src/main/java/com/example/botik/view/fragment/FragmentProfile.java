package com.example.botik.view.fragment;

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
import com.example.botik.databinding.FragmentprofileBinding;
import com.example.botik.model.ModelUserInfo;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Farsinumber;
import com.example.botik.viewmodel.ViewModelUserInfo;

import java.util.List;

public class FragmentProfile extends Fragment {
    FragmentprofileBinding binding;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentprofileBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        binding.exit.setOnClickListener(view -> {
            Boolean check=Repository.Shared_exit(requireActivity());
            if(check){
                navController.navigate(R.id.action_fragmentProfile_to_fragmentLogin);
            }
        });
        binding.sabege.setOnClickListener(view -> navController.navigate(R.id.action_fragmentProfile_to_fragmentOrder));
        binding.edit.setOnClickListener(view -> navController.navigate(R.id.action_fragmentProfile_to_fragmentEdit));
        binding.show.setOnClickListener(view -> navController.navigate(R.id.action_fragmentProfile_to_fragmentShowData));
        ViewModelUserInfo viewmodel =new ViewModelProvider(this).get(ViewModelUserInfo.class);
        String token= Repository.Shared_Read(requireActivity());
        if(token==null){

        }else
        {
            viewmodel.UserInfo(token);
            viewmodel.mutableinfo.observe(requireActivity(), modelUserInfos -> {
                ModelUserInfo user =new ModelUserInfo();
                user.setName(modelUserInfos.get(0).getName());
                binding.username.setText(Farsinumber.farsinumber(modelUserInfos.get(0).getName()));
                binding.setData(user);
            });

        }

        return binding.getRoot();
    }

}
