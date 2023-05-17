package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ObjectAnimator objectAnimator;
    ObjectAnimator objectAnimatorS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image);
        Button btn = findViewById(R.id.btnAnimate);
//        objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation",360);
        objectAnimator = ObjectAnimator.ofFloat(imageView, "x",360);
        objectAnimatorS = ObjectAnimator.ofFloat(imageView, "rotation",360);
//        objectAnimator = ObjectAnimator.ofFloat(imageView, "radius",imageView.getWidth(), 0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectAnimator.setDuration(1000);
                objectAnimatorS.setDuration(1000);
                objectAnimator.start();
                objectAnimatorS.start();
            }
        });

    }
}