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
import com.example.botik.databinding.FragmentaddressBinding;
import com.example.botik.model.ModelSelectAddress;
import com.example.botik.repository.Repository;
import com.example.botik.view.Adapter.AdapterAddress;
import com.example.botik.viewmodel.ViewModelSelectAddress;

import java.util.List;

public class FragmentAddress extends Fragment {
    FragmentaddressBinding binding;
    NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentaddressBinding.inflate(inflater, container, false);
            navController = Navigation.findNavController(requireActivity(), R.id.fragment);
            final ViewModelSelectAddress viewmodel = new ViewModelProvider(this).get(ViewModelSelectAddress.class);
            final String token = Repository.Shared_Read(requireActivity());
            if (token == null) {

            } else {
                viewmodel.Address(token);
                viewmodel.mutableLiveDataSelectAddress.observe(requireActivity(), new Observer<List<ModelSelectAddress>>() {
                    @Override
                    public void onChanged(List<ModelSelectAddress> modelSelectAddresses) {
                        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireActivity()));
                        AdapterAddress adapter= new AdapterAddress(modelSelectAddresses, new AdapterAddress.Itemsaddressid() {
                            @Override
                            public void Change(String id) {
                                Bundle bundle=new Bundle();
                                bundle.putString("id",id);
                                navController.navigate(R.id.action_fragmentAddress_to_fragmentPay,bundle);
                            }
                        });
                        binding.recyclerview.setAdapter(adapter);
                    }
                });
            }
        }
        return binding.getRoot();
    }
}
