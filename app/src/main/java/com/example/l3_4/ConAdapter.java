package com.example.l3_4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.l3_4.databinding.ConItemBinding;

import java.util.ArrayList;

public class ConAdapter extends RecyclerView.Adapter<ConAdapter.ConViewHolder> {

    public ConAdapter(ArrayList<Coyntries> name, OnItemClickListener onItemClickListener) {
        this.name = name;
        this.onItemClickListener = onItemClickListener;
    }

   private ArrayList<Coyntries> name;

   private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public ConViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConViewHolder(ConItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ConViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(name.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ConViewHolder extends RecyclerView.ViewHolder {
        private ConItemBinding binding;
        public ConViewHolder(ConItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Coyntries name) {
            binding.tvConItem.setText(name.nameCountry);
            Glide.with(binding.imItem).load(name.image).into(binding.imItem);
        }
    }
}
