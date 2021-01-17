package com.example.botik.view.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.botik.R;
import com.example.botik.databinding.ItemspayBinding;
import com.example.botik.model.ModelPay;

import java.util.List;

public class AdapterPay extends RecyclerView.Adapter<AdapterPay.viewholder> {
    List<ModelPay> list;
    Itemsaddressid changecount;
    int[] idrg;
    Context context;
    public AdapterPay( Context context, List<ModelPay> list, Itemsaddressid changecount){
        this.list=list;
        this.changecount=changecount;
        idrg=new int[list.size()];
        this.context=context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder((ItemspayBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemspay, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        final ModelPay listpost=list.get(position);
        int id = View.generateViewId();
        holder.binding.RB.setId(id);
        idrg[position]=id;
        holder.binding.setData(listpost);
        if(position==1){
            holder.binding.RB.setChecked(true);
            changecount.Change(listpost.getLink());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changecount.Change(listpost.getLink());
            }
        });
        holder.binding.RB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int value : idrg) {
                    RadioButton radioButton = ((Activity) context).findViewById(value);
                    radioButton.setChecked(view.getId() == value);
                }
                changecount.Change(listpost.getLink());

            }
        });
    }

    public interface Itemsaddressid{
        void Change(String link);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ItemspayBinding binding;
        public viewholder(@NonNull ItemspayBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
