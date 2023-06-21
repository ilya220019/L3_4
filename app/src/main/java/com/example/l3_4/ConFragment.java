package com.example.l3_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.l3_4.databinding.FragmentConBinding;

import java.util.ArrayList;


public class ConFragment extends Fragment implements OnItemClickListener {
    private FragmentConBinding binding;
    ConAdapter adapter;
    public ArrayList<Coyntries> name = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ConAdapter(name, this);
        binding.rvCon.setAdapter(adapter);
    }

    private void loadData() {
        name.add(new Coyntries("Aystralia", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Australia-climate-map_ru.svg/300px-Australia-climate-map_ru.svg.png"));
        name.add(new Coyntries("Evrasia", "https://ykl-res.azureedge.net/44a642af-8f34-4e32-99d0-10e585328f5d/%D0%95%D0%B2%D1%80%D0%B0%D0%B7%D0%B8%D1%8F%203-w658.png"));
        name.add(new Coyntries("Africa", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/280px-Africa_%28orthographic_projection%29.svg.png"));
        name.add(new Coyntries("North America", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/280px-Location_North_America.svg.png"));
        name.add(new Coyntries("South America", "data:image/jpeg;base64,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"));
    }

    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("name", position);
        CountryFragment countryFragment1 = new CountryFragment();
        countryFragment1.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, countryFragment1).addToBackStack(null).commit();

    }
}