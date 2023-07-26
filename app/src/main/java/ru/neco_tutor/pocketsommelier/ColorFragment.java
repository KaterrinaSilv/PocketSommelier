package ru.neco_tutor.pocketsommelier;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import ru.neco_tutor.pocketsommelier.databinding.FragmentColorBinding;
import ru.neco_tutor.pocketsommelier.utils.CustomArrayAdapter;
import ru.neco_tutor.pocketsommelier.utils.ListItemClass;

public class ColorFragment extends Fragment {
    private FragmentColorBinding binding;
    private ListView listView;
    private String[] arrays, arraySecondName;

    private CustomArrayAdapter customArrayAdapter;
    private final int category = 0;
    private TextView textView;
    private Typeface typeface;
    private int[] array_wine_images = new int[]{R.color.red, R.color.white, R.color.purple_200};
    private List<ListItemClass> listItemClasses;
    private ListItemClass listItem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentColorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textView4;
        typeface = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/Bitter/static/Bitter-Italic.ttf");
        textView.setTypeface(typeface);

        listView = binding.colorList;
        arrays = getResources().getStringArray(R.array.color_array);
        arraySecondName = getResources().getStringArray(R.array.second_color_array);
        listItemClasses = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++){
            listItem = new ListItemClass();
            listItem.setNameWine(arrays[i]);
            listItem.setSecondNameWine(arraySecondName[i]);
            listItem.setImage(array_wine_images[i]);
            listItemClasses.add(listItem);
        }
        customArrayAdapter = new CustomArrayAdapter(getContext(), R.layout.list_view_item_1, listItemClasses, getLayoutInflater());
        listView.setAdapter(customArrayAdapter);

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
        customArrayAdapter.clear();
        binding = null;
    }
}
