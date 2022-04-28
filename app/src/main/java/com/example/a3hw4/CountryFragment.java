package com.example.a3hw4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3hw4.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    private FragmentContinentBinding binding;
    private ArrayList<UniversModel> list;
    private Adapter adapter;
    private String continentName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new Adapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBundle();
        loadData();
        setAdapter();
    }

    private void getBundle() {
        Bundle bundle = getArguments();
        assert bundle != null;
        continentName = bundle.getString("key");
    }

    private void loadData() {
        list = new ArrayList<>();
        switch (continentName) {
            case "Азия": {
                list.add(new UniversModel("Туркменистан", R.drawable.turkmenistan_image));
                list.add(new UniversModel("Тайвань", R.drawable.taiwan_image));
                list.add(new UniversModel("Таджикистан", R.drawable.tajikistan_image));
                list.add(new UniversModel("Тайланд", R.drawable.thailant_image));
                list.add(new UniversModel("Турция", R.drawable.turkiya_image));
                break;
            }
            case "Северная Америка": {
                list.add(new UniversModel("Сан-Морино", R.drawable.sanmorino_image));
                list.add(new UniversModel("Суринам", R.drawable.surinam_image));
                list.add(new UniversModel("Словакия", R.drawable.slovakia_image));
                list.add(new UniversModel("Свазиленд", R.drawable.swaziland_image));
                list.add(new UniversModel("украина", R.drawable.ucraine_image));
                break;
            }
            case "Южная Америка": {
                list.add(new UniversModel("Сан-Морино", R.drawable.siland_image));
                list.add(new UniversModel("Суринам", R.drawable.sb_image));
                list.add(new UniversModel("Словакия", R.drawable.slovakia_image));
                list.add(new UniversModel("Свазиленд", R.drawable.surinam_image));
                list.add(new UniversModel("украина", R.drawable.ucraine_image));
                break;
            }
            case "Австралия": {
                list.add(new UniversModel("Timor", R.drawable.timor_image));
                list.add(new UniversModel("Singapur", R.drawable.singapur_image));
                list.add(new UniversModel("Садин", R.drawable.sd_image));
                list.add(new UniversModel("Тунис", R.drawable.tunisia_image));
                list.add(new UniversModel("Танодр", R.drawable.td_image));
                break;
            }
            case "Африка": {
                list.add(new UniversModel("Siland", R.drawable.siland_image));
                list.add(new UniversModel("SaintBang", R.drawable.sb_image));
                list.add(new UniversModel("Somali", R.drawable.somali_image));
                list.add(new UniversModel("SillantHill", R.drawable.siland_image));
                list.add(new UniversModel("SeaHoork", R.drawable.sh_image));
                break;
            }
            case "Европа": {
                list.add(new UniversModel("Ukraine", R.drawable.ucraine_image));
                list.add(new UniversModel("Slovakia", R.drawable.slovakia_image));
                list.add(new UniversModel("Slovenia", R.drawable.slovenia_image));
                list.add(new UniversModel("Swidden", R.drawable.swiden_image));
                list.add(new UniversModel("Syria", R.drawable.siriya_image));
                break;
            }
        }
    }

    private void setAdapter() {
        binding.recyclerContinent.setAdapter(adapter);
        adapter.setList(list);
    }
}