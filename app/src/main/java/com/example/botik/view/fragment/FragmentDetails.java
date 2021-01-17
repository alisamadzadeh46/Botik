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
import com.example.botik.databinding.FragmentdetailsBinding;
import com.example.botik.model.ModelAddCart;
import com.example.botik.model.ModelDetails;
import com.example.botik.model.ModelIndex;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;
import com.example.botik.view.Adapter.Adapterviewpager;
import com.example.botik.view.activity.MainActivity;
import com.example.botik.viewmodel.ViewModelDetails;

import java.util.List;

public class FragmentDetails extends Fragment {
    FragmentdetailsBinding binding;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentdetailsBinding.inflate(inflater,container,false);
        navController= Navigation.findNavController(requireActivity(), R.id.fragment);
        ViewModelDetails viewmodel =new ViewModelProvider(this).get(ViewModelDetails.class);
        assert getArguments() != null;
        viewmodel.PostDetails(getArguments().getString("id"));
        viewmodel.mutableLiveDataPost.observe(requireActivity(), modelDetails -> {
            ModelIndex model=new ModelIndex();
            model.setIdpost(modelDetails.post.get(0).getIdpost());
            model.setImage(modelDetails.post.get(0).getImage());
            model.setMade(modelDetails.post.get(0).getMade());
            model.setPrice(modelDetails.post.get(0).getPrice());
            model.setTozih(modelDetails.post.get(0).getTozih());
            model.setName(modelDetails.post.get(0).getName());
            binding.name.setText(Farsinumber.farsinumber(modelDetails.post.get(0).getName()));
            String Price= Desimal_format_Interger.GetformatInteger(modelDetails.post.get(0).getPrice());
            binding.gheymat.setText(Farsinumber.farsinumber(Price));
            binding.setData(model);
//                binding.BtnPrice.setText(" افزودن به سبد خرید "+ model_details.post.get(0).getPrice() + " تومان ");
            Adapterviewpager adapter =new Adapterviewpager(modelDetails.slider);
            binding.imgView.setAdapter(adapter);
            binding.imgView.setPageMargin(22);
            binding.imgView.setPadding(45,0,10,0);
            binding.imgView.setCurrentItem(1);
        });

        binding.addToCart.setOnClickListener(view -> {
            String user= Repository.Shared_Read(requireActivity());
            if(user==null){
                navController.navigate(R.id.action_fragmentDetails_to_fragmentLogin);
            }else
            {
                assert getArguments() != null;
                Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Addcart(getArguments().getString("id"), user, "1", "add"), object -> {
                    ModelAddCart model_addcart=(ModelAddCart)object;
                    if(model_addcart.getStatus().equals("ok"))
                    {
                        MainActivity mainActivity=(MainActivity) getActivity();
                        assert mainActivity != null;
                        mainActivity.Get_CountCart();
                    }
                });

            }


        });
        return binding.getRoot();

    }
}
