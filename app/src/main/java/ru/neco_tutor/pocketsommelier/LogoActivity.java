package ru.neco_tutor.pocketsommelier;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import ru.neco_tutor.pocketsommelier.databinding.ActivityLogoBinding;

public class LogoActivity extends Activity {
    private ActivityLogoBinding binding;
    private Animation logoAnim, buttonAnim, alphaAnim;
    private TextView textView;
    private ImageView imageView;
    private Typeface typeface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        startMainActivity();
    }

    private void init() {
        alphaAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);

        textView = binding.textView2;
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Bitter/static/Bitter-Italic.ttf");
        textView.setTypeface(typeface);
        imageView = binding.imageView;

        imageView.startAnimation(alphaAnim);
        textView.startAnimation(alphaAnim);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    private void startMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }).start();


    }
}
