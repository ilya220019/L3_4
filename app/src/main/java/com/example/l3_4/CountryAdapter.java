package com.example.l3_4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.l3_4.databinding.ItemCoyntryBinding;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    public CountryAdapter(ArrayList<Coyntries> name) {
        this.name = name;
    }

    private ArrayList<Coyntries> name;

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new CountryViewHolder(ItemCoyntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(name.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        private ItemCoyntryBinding binding;
        public CountryViewHolder(ItemCoyntryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
        public void bind(Coyntries name) {
            binding.tvCountryItem.setText(name.nameCountry);
            Glide.with(binding.imCoyntryItem).load(name.image).into(binding.imCoyntryItem);
        }
    }
}
