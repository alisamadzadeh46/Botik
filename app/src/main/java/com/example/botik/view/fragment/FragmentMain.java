package com.example.botik.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.botik.R;
import com.example.botik.databinding.FragmentmainBinding;



public class FragmentMain extends Fragment {
    FragmentmainBinding binding;
    NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentmainBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment);
        binding.manto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragmentMain_to_fragmentmanto);
            }
        });
        return binding.getRoot();
    }

}
