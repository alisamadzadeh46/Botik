package com.example.botik.view.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
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
import com.example.botik.databinding.FragmentpayBinding;
import com.example.botik.model.ModelOrder;
import com.example.botik.model.ModelPay;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;
import com.example.botik.view.Adapter.AdapterPay;
import com.example.botik.viewmodel.ViewModelAddOrder;

import java.util.List;

public class FragmentPay extends Fragment {
    FragmentpayBinding binding;
    NavController navController;
    String code = null;
    String linkintent = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentpayBinding.inflate(inflater, container, false);
            navController = Navigation.findNavController(requireActivity(), R.id.fragment);
            final ViewModelAddOrder viewmodel = new ViewModelProvider(this).get(ViewModelAddOrder.class);
            final String token = Repository.Shared_Read(requireActivity());
            assert getArguments() != null;
            final String address = getArguments().getString("id");
            if (token == null) {

            } else {
                viewmodel.AddOrder(token, address);
                viewmodel.mutableinfo.observe(requireActivity(), new Observer<ModelOrder>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onChanged(ModelOrder modelOrder) {
                        final String Price = Desimal_format_Interger.GetformatInteger(modelOrder.getPrice());
                        binding.count.setText(Farsinumber.farsinumber(Price) + " تومان ");
                        code = modelOrder.getCode();

                    }
                });
                viewmodel.muableprice.observe(requireActivity(), new Observer<List<ModelPay>>() {
                    @Override
                    public void onChanged(List<ModelPay> modelPays) {
                        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireActivity()));
                        AdapterPay adapter = new AdapterPay(requireContext(), modelPays, new AdapterPay.Itemsaddressid() {
                            @Override
                            public void Change(String link) {
                                linkintent = link;
                            }
                        });
                        binding.recyclerview.setAdapter(adapter);
                    }
                });

            }
            binding.btnContinu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (code == null) {

                    } else {
                        if (linkintent == null) {

                        } else {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(linkintent + code));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
        return binding.getRoot();
    }
}
