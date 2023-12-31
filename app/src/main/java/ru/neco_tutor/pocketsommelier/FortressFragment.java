package ru.neco_tutor.pocketsommelier;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import ru.neco_tutor.pocketsommelier.databinding.FragmentFortressBinding;

public class FortressFragment extends Fragment {

    private FragmentFortressBinding binding;


    private ListView listView;
    private String[] arrays;
    private TextView textView;
    private Typeface typeface;
    private ArrayAdapter<String> arrayAdapter;
    private final int category = 3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFortressBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textView3;
        typeface = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/Bitter/static/Bitter-Italic.ttf");
        textView.setTypeface(typeface);

        listView = binding.fortressList;
        arrays = getResources().getStringArray(R.array.fortress_array);
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
