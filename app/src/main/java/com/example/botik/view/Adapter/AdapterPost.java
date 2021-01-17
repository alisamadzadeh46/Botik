package com.example.botik.view.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.botik.R;
import com.example.botik.databinding.ItemspostBinding;
import com.example.botik.model.ModelIndex;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;

import java.util.List;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.viewholder> {
    List<ModelIndex> list;
    GetClicidpost getClicidpost;

    public AdapterPost(List<ModelIndex> list, GetClicidpost getClicidpost) {
        this.list = list;
        this.getClicidpost = getClicidpost;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemspost, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final ModelIndex modelIndex = list.get(position);
        holder.binding.setData(modelIndex);
        final String Price= Desimal_format_Interger.GetformatInteger(modelIndex.getPrice());
        holder.binding.gheymat.setText(Farsinumber.farsinumber(Price) + "تومان");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getClicidpost.Clickgetid(modelIndex.getIdpost());
            }
        });
    }

    public interface GetClicidpost {
        void Clickgetid(String id);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ItemspostBinding binding;

        public viewholder(@NonNull ItemspostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
