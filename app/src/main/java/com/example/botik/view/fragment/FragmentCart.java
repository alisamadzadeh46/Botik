package com.example.botik.view.fragment;

import android.graphics.ColorSpace;
import android.opengl.Visibility;
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
import com.example.botik.databinding.FragmentcartBinding;
import com.example.botik.model.ModelAddCart;
import com.example.botik.model.ModelGetCart;
import com.example.botik.model.Price;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;
import com.example.botik.view.Adapter.AdapterListCart;
import com.example.botik.viewmodel.ViewModelCartList;

import java.util.List;

public class FragmentCart extends Fragment {
    FragmentcartBinding binding;
    NavController navController;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentcartBinding.inflate(inflater, container, false);
            navController = Navigation.findNavController(requireActivity(), R.id.fragment);
            final ViewModelCartList viewmodel = new ViewModelProvider(this).get(ViewModelCartList.class);
            final String token = Repository.Shared_Read(requireActivity());

            if (token == null) {

            } else {
                viewmodel.Cart(token);

                viewmodel.mutableinfo.observe(requireActivity(), new Observer<List<ModelGetCart>>() {
                    @Override
                    public void onChanged(List<ModelGetCart> modelGetCarts) {
                        binding.CartRecycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
                        AdapterListCart adapter = new AdapterListCart(requireActivity(), modelGetCarts, token, new AdapterListCart.Changecount() {
                            @Override
                            public void Change() {
                                viewmodel.Cart(token);
                                viewmodel.muableprice.observe(requireActivity(), new Observer<List<Price>>() {
                                    @Override
                                    public void onChanged(List<Price> prices) {
                                        final String Price = Desimal_format_Interger.GetformatInteger(prices.get(0).getPrice());
                                        binding.jm.setText(Farsinumber.farsinumber(Price) + " تومان ");
                                    }
                                });
                            }
                        });
                        binding.CartRecycler.setAdapter(adapter);
                    }
                });
                viewmodel.muableprice.observe(requireActivity(), new Observer<List<Price>>() {
                    @Override
                    public void onChanged(List<Price> prices) {
                        final String Price = Desimal_format_Interger.GetformatInteger(prices.get(0).getPrice());
                        binding.jm.setText(Farsinumber.farsinumber(Price) + " تومان ");
                    }
                });
                binding.pardakht.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        navController.navigate(R.id.action_fragmentCart_to_fragmentAddress);
                    }
                });



            }

        }
        return binding.getRoot();
    }


}
