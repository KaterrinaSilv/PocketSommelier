package ru.neco_tutor.pocketsommelier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.neco_tutor.pocketsommelier.databinding.FragmentVarietyBinding;

public class VarietyFragment extends Fragment {

    private FragmentVarietyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVarietyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}

