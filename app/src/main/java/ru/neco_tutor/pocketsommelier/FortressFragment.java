package ru.neco_tutor.pocketsommelier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import ru.neco_tutor.pocketsommelier.databinding.FragmentFortressBinding;

public class FortressFragment extends Fragment {

    private FragmentFortressBinding binding;


    private ListView listView;
    private String[] arrays;
    private ArrayAdapter<String> arrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFortressBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = binding.fortressList;
        arrays = getResources().getStringArray(R.array.fortress_array);
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(arrays)));
        listView.setAdapter(arrayAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        arrayAdapter.clear();
        binding = null;
    }
}
