package ru.neco_tutor.pocketsommelier;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.neco_tutor.pocketsommelier.databinding.ActivityContentBinding;

public class ActivityContent extends AppCompatActivity {

    private ActivityContentBinding binding;
    private TextView textView;
    private int category;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textView = binding.textView;
        receiveIntent();

    }
    private void receiveIntent(){
        Intent intent = getIntent();
        if(intent != null){
            category = intent.getIntExtra("category", 0);
            position = intent.getIntExtra("position", 0);
        }
        switch (category){
            case 0:
                switch (position){
                    case 0:
                        textView.setText(R.string.red_wine);
                        break;
                    case 1:
                        textView.setText(R.string.white_wine);
                        break;
                    case 2:
                        textView.setText(R.string.rose_wine);
                        break;
                }
                break;
            case 1:
                switch (position) {
                    case 0:
                        textView.setText(R.string.dry_wine);
                        break;
                    case 1:
                        textView.setText(R.string.semi_dry_and_semi_sweet_wine);
                        break;
                    case 2:
                        textView.setText(R.string.sweet_wine);
                        break;
                }
                break;
            case 2:
                switch (position) {
                    case 0:
                        textView.setText(R.string.quiet_wine);
                        break;
                    case 1:
                        textView.setText(R.string.sparkling_wine);
                        break;
                }
                break;
            case 3:
                textView.setText(R.string.fortress_wine);
                break;
            case 4:
                switch (position){
                    case 0:
                        textView.setText(R.string.chardonnay);
                        break;
                    case 1:
                        textView.setText(R.string.cabernet_sauvignon);
                        break;
                    case 2:
                        textView.setText(R.string.merlot);
                        break;
                    case 3:
                        textView.setText(R.string.sauvignon_blan);
                        break;
                }
                break;
        }
    }
}