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
import com.example.botik.model.ModelListOrder;
import com.example.botik.repository.Repository;
import com.example.botik.view.Adapter.AdapterOrder;
import com.example.botik.viewmodel.ViewModelOrder;

import java.util.List;

public class FragmentOrder extends Fragment {
    FragmentorderBinding binding;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentorderBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelOrder viewmodel =new ViewModelProvider(this).get(ViewModelOrder.class);
        String token= Repository.Shared_Read(requireActivity());
        if(token==null){

        }else
        {
            viewmodel.Order(token);
            viewmodel.mutablepost.observe(requireActivity(), new Observer<List<ModelListOrder>>() {
                @Override
                public void onChanged(List<ModelListOrder> modelListOrders) {
                    binding.CartRecycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
                    AdapterOrder adpter=new AdapterOrder(modelListOrders);
                    binding.CartRecycler.setAdapter(adpter);
                }
            });

        }
        return binding.getRoot();
    }
}
