package ru.neco_tutor.pocketsommelier;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.neco_tutor.pocketsommelier.databinding.ActivityContentBinding;

public class ActivityContent extends AppCompatActivity {

    private ActivityContentBinding binding;
    private TextView textView;
    private Typeface typeface;
    private int category;
    private int position;
    private ActionBar actionBar;
    private SharedPreferences sharedPreferencesTextSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        receiveIntent();

    }

    private void receiveIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            category = intent.getIntExtra("category", 0);
            position = intent.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                switch (position) {
                    case 0:
                        textView.setText(R.string.red_wine);
                        actionBar.setTitle("Красные вина");
                        break;
                    case 1:
                        textView.setText(R.string.white_wine);
                        actionBar.setTitle("Белые вина");
                        break;
                    case 2:
                        textView.setText(R.string.rose_wine);
                        actionBar.setTitle("Розовые вина");
                        break;
                }
                break;
            case 1:
                switch (position) {
                    case 0:
                        textView.setText(R.string.dry_wine);
                        actionBar.setTitle("Сухие вина");
                        break;
                    case 1:
                        textView.setText(R.string.semi_dry_and_semi_sweet_wine);
                        actionBar.setTitle("Полусухие и полусладкие вина");
                        break;
                    case 2:
                        textView.setText(R.string.sweet_wine);
                        actionBar.setTitle("Сладкие вина");
                        break;
                }
                break;
            case 2:
                switch (position) {
                    case 0:
                        textView.setText(R.string.quiet_wine);
                        actionBar.setTitle("Тихие вина");
                        break;
                    case 1:
                        textView.setText(R.string.sparkling_wine);
                        actionBar.setTitle("Игристые вина");
                        break;
                }
                break;
            case 3:
                textView.setText(R.string.fortress_wine);
                actionBar.setTitle("");
                break;
            case 4:
                switch (position) {
                    case 0:
                        textView.setText(R.string.chardonnay);
                        actionBar.setTitle("Шардоне");
                        break;
                    case 1:
                        textView.setText(R.string.cabernet_sauvignon);
                        actionBar.setTitle("Каберне совиньон");
                        break;
                    case 2:
                        textView.setText(R.string.merlot);
                        actionBar.setTitle("Мерло");
                        break;
                    case 3:
                        textView.setText(R.string.sauvignon_blan);
                        actionBar.setTitle("Совиньон блан");
                        break;
                }
                break;
        }
    }

    private void init() {
        sharedPreferencesTextSize = PreferenceManager.getDefaultSharedPreferences(this);
        textView = binding.textView;
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Bitter/static/Bitter-Italic.ttf");
        textView.setTypeface(typeface);
        actionBar = getSupportActionBar();
        String text = sharedPreferencesTextSize.getString("main_text_size", "Средний");
        if(text != null) {
            switch (text) {
                case "Большой":
                    textView.setTextSize(22);
                    break;
                case "Средний":
                    textView.setTextSize(20);
                    break;
                case "Маленький":
                    textView.setTextSize(18);
                    break;
            }
        }
    }
}