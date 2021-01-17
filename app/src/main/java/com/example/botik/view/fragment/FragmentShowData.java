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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.botik.R;
import com.example.botik.databinding.FragmentorderBinding;
import com.example.botik.databinding.FragmentshowdataBinding;
import com.example.botik.model.ModelIndex;
import com.example.botik.model.ModelListOrder;
import com.example.botik.model.ModelShowData;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Farsinumber;
import com.example.botik.view.Adapter.AdapterOrder;
import com.example.botik.viewmodel.ViewModelOrder;
import com.example.botik.viewmodel.ViewModelShowData;

import java.util.List;

public class FragmentShowData extends Fragment {
    FragmentshowdataBinding binding;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentshowdataBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelShowData viewmodel =new ViewModelProvider(this).get(ViewModelShowData.class);
        String token= Repository.Shared_Read(requireActivity());
        if(token==null){

        }else
        {
            viewmodel.ShowData(token);
            viewmodel.mutableLiveData.observe(requireActivity(), modelShowData -> {
                binding.usernameEdt.setText(Farsinumber.farsinumber(modelShowData.get(0).getAddress()));
               binding.codePosti.setText(Farsinumber.farsinumber(modelShowData.get(0).getCodeposti()));
               binding.phone.setText(Farsinumber.farsinumber(modelShowData.get(0).getPhone()));
               binding.telefon.setText(Farsinumber.farsinumber(modelShowData.get(0).getPhonesabet()));

            });
         binding.btnContinu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 navController.navigate(R.id.action_fragmentShowData_to_fragmentProfile);
             }
         });
        }
        return binding.getRoot();
    }
}
