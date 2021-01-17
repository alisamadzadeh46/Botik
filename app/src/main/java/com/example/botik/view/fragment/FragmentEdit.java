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
import com.example.botik.databinding.FragmenteditBinding;
import com.example.botik.databinding.FragmentregisterBinding;
import com.example.botik.model.Status;
import com.example.botik.repository.Repository;
import com.example.botik.viewmodel.ViewModelEdit;
import com.example.botik.viewmodel.ViewModelRegister;
import com.sdsmdg.tastytoast.TastyToast;

public class FragmentEdit extends Fragment {
    FragmenteditBinding binding;
    NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmenteditBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelEdit viewmodel = new ViewModelProvider(this).get(ViewModelEdit.class);
        String token = Repository.Shared_Read(requireActivity());
        if (token == null) {

        }
        else {
            viewmodel.token = Repository.Shared_Read(requireActivity());
            binding.setData(viewmodel);
            viewmodel.mutableLiveDataEdit.observe(requireActivity(), new Observer<Status>() {
                @Override
                public void onChanged(Status status) {
                    if (status.getStatus().equals("ok")) {
                        navController.navigate(R.id.action_fragmentEdit_to_fragmentProfile);
                    } else {
                        TastyToast.makeText(requireActivity(), "خطا در ثبت اطلاعات", TastyToast.LENGTH_LONG,
                                TastyToast.WARNING);
                    }
                }
            });
        }
        return binding.getRoot();

    }
}
