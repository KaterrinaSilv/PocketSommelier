package ru.neco_tutor.pocketsommelier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.neco_tutor.pocketsommelier.databinding.FragmentColorBinding;

public class ColorFragment extends Fragment {
    private FragmentColorBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentColorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}
