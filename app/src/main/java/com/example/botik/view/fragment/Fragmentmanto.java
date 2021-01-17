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
import com.example.botik.databinding.FragmentmantoBinding;
import com.example.botik.model.ModelIndex;
import com.example.botik.view.Adapter.AdapterPost;
import com.example.botik.viewmodel.ViewModelIndex;

import java.util.List;

public class Fragmentmanto extends Fragment {
    FragmentmantoBinding binding;
    ViewModelIndex viewmodelindex;
    AdapterPost adapterPost;
    NavController navController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(binding==null){
            binding=FragmentmantoBinding.inflate(inflater,container,false);
            navController= Navigation.findNavController(requireActivity(), R.id.fragment);
            viewmodelindex =new ViewModelProvider(this).get(ViewModelIndex.class);
            viewmodelindex.Post();
            viewmodelindex.mutableLiveDataPost.observe(requireActivity(), new Observer<List<ModelIndex>>() {
                @Override
                public void onChanged(List<ModelIndex> list) {
                    binding.mantoRecycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
                    adapterPost=new AdapterPost(list, new AdapterPost.GetClicidpost() {
                        @Override
                        public void Clickgetid(String id) {
                            Bundle bundle=new Bundle();
                            bundle.putString("id",id);
                            navController.navigate(R.id.action_fragmentmanto_to_fragmentDetails,bundle);
                        }
                    });
                    binding.mantoRecycler.setAdapter(adapterPost);
                }
            });
        }

        return binding.getRoot();
    }

}
