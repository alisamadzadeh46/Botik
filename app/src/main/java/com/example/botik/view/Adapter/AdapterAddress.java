package com.example.botik.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.botik.R;
import com.example.botik.databinding.ItemsaddressBinding;
import com.example.botik.model.ModelSelectAddress;
import com.example.botik.utils.Farsinumber;

import java.util.List;

public class AdapterAddress extends RecyclerView.Adapter<AdapterAddress.viewholder> {
    List<ModelSelectAddress> list;
    Itemsaddressid changecount;
    public AdapterAddress(List<ModelSelectAddress> list, Itemsaddressid changecount){
        this.list=list;
        this.changecount=changecount;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder((ItemsaddressBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemsaddress, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        final ModelSelectAddress listpost=list.get(position);
        holder.binding.setData(listpost);
        holder.binding.codeposti.setText(Farsinumber.farsinumber(listpost.getCodeposti()));
        holder.binding.phone.setText(Farsinumber.farsinumber(listpost.getPhone()));
        holder.binding.shomaresabet.setText(Farsinumber.farsinumber(listpost.getPhonesabet()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changecount.Change(listpost.getId());
            }
        });
    }

    public interface Itemsaddressid{
        void Change(String id);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ItemsaddressBinding binding;
        public viewholder(@NonNull ItemsaddressBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
