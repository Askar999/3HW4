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


public class ContinentFragment extends Fragment implements OnClick {

    private FragmentContinentBinding binding;
    private ArrayList<UniversModel> list;
    private Adapter adapter;

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
        loadData();
        setAdapter();
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new UniversModel("Азия", R.drawable.asia_image));
        list.add(new UniversModel("Северная Америка", R.drawable.nourth_america_image));
        list.add(new UniversModel("Южная Америка", R.drawable.south_america_image));
        list.add(new UniversModel("Австралия", R.drawable.australia_image));
        list.add(new UniversModel("Африка", R.drawable.africa_image));
        list.add(new UniversModel("Европа", R.drawable.europa_image));
    }

    private void setAdapter() {
        binding.recyclerContinent.setAdapter(adapter);
        adapter.setList(list);
        adapter.setOnClick(this);
    }

    @Override
    public void click(UniversModel model) {
        Bundle bundle = new Bundle();
        bundle.putString("key", model.getName());
        Fragment fragment = new CountryFragment();
        fragment.setArguments(bundle);
        requireActivity().
                getSupportFragmentManager().
                beginTransaction().
                addToBackStack(null).replace(R.id.container_main, fragment).commit();
    }
}