package ru.neco_tutor.pocketsommelier;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import ru.neco_tutor.pocketsommelier.databinding.FragmentVarietyBinding;

public class VarietyFragment extends Fragment {

    private FragmentVarietyBinding binding;

    private ListView listView;
    private String[] arrays;
    private ArrayAdapter<String> arrayAdapter;
    private final int category = 4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVarietyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        listView = binding.varietyList;
        arrays = getResources().getStringArray(R.array.variety_array);
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(arrays)));
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ActivityContent.class);
                intent.putExtra("category", category);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        arrayAdapter.clear();
        binding = null;
    }
}

