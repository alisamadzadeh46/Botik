package com.example.botik.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.botik.R;
import com.example.botik.databinding.ItemorderBinding;
import com.example.botik.model.ModelListOrder;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;

import java.lang.reflect.Field;
import java.util.List;

public class AdapterOrder extends RecyclerView.Adapter<AdapterOrder.viewholder> {
    List<ModelListOrder> list;

    public AdapterOrder(List<ModelListOrder> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder((ItemorderBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemorder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final ModelListOrder listpost = list.get(position);
        holder.binding.setData(listpost);
        holder.binding.sefaresh.setText(Farsinumber.farsinumber(listpost.getId()));
        String gheymat = Desimal_format_Interger.GetformatInteger(listpost.getPrice());
        holder.binding.gheymat.setText(Farsinumber.farsinumber(gheymat));
        if (listpost.getStatus().equals("1")) {
            holder.binding.BtnSuccess.setVisibility(View.VISIBLE);
            holder.binding.BtnPrice.setVisibility(View.GONE);
        } else {
            holder.binding.BtnSuccess.setVisibility(View.GONE);
            holder.binding.BtnPrice.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ItemorderBinding binding;

        public viewholder(@NonNull ItemorderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
