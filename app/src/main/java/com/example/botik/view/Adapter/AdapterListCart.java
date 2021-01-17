package com.example.botik.view.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.botik.R;
import com.example.botik.databinding.ItemscartBinding;
import com.example.botik.model.ModelAddCart;
import com.example.botik.model.ModelGetCart;
import com.example.botik.model.Status;
import com.example.botik.repository.Api;
import com.example.botik.repository.Repository;
import com.example.botik.utils.Desimal_format_Interger;
import com.example.botik.utils.Farsinumber;

import java.util.List;

public class AdapterListCart  extends RecyclerView.Adapter<AdapterListCart.viewholder>{
    List<ModelGetCart> list;
    String user;
    Changecount changecount;
    Context context;
    public AdapterListCart(Context context, List<ModelGetCart> list, String user, Changecount changecount){
        this.list=list;
        this.user=user;
        this.changecount=changecount;
        this.context=context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder((ItemscartBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.itemscart, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, final int position) {
        final ModelGetCart listpost=list.get(position);
        holder.binding.setData(listpost);
        holder.binding.tedad.setText(Farsinumber.farsinumber(listpost.getCount()));
        final String Price= Desimal_format_Interger.GetformatInteger(listpost.getPrice());
        holder.binding.gheymat.setText(Farsinumber.farsinumber(Price) + "تومان");
        holder.binding.name.setText(listpost.getName());
        Glide.with(context).load(listpost.getImage()).into(holder.binding.imageview);
        holder.binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Addcart(listpost.getIdproduct(),user,"1","add"), new Repository.Unit() {
                    @Override
                    public void invoke(Object object) {
                        ModelAddCart model_addcart=(ModelAddCart)object;
                        if(model_addcart.getStatus().equals("ok"))
                        {
                            changecount.Change();
                        }
                    }
                });
            }
        });

        holder.binding.mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Addcart(listpost.getIdproduct(),user,"1","m"), new Repository.Unit() {
                    @Override
                    public void invoke(Object object) {
                        ModelAddCart model_addcart=(ModelAddCart)object;
                        if(model_addcart.getStatus().equals("ok"))
                        {
                            changecount.Change();
                        }
                    }
                });
            }
        });
        holder.binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Repository.INSTACNCE.CustomResponse(Api.Compation.invoke().Single_Delete_items(listpost.getId()), new Repository.Unit() {
                    @Override
                    public void invoke(Object object) {
                        Status status=(Status)object;
                        if(status.getStatus().equals("ok")){
                            list.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position,list.size());
                            changecount.Change();
                        }
                    }
                });

            }
        });

    }

    public interface Changecount{
        void Change();
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        ItemscartBinding binding;
        public viewholder(@NonNull ItemscartBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
