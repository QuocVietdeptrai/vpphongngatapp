package com.example.vpphongngatapp.ui.auth;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vpphongngatapp.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivSplashLogo;
    private View vOrangeBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivSplashLogo = findViewById(R.id.ivSplashLogo);
        vOrangeBackground = findViewById(R.id.vOrangeBackground);

        ivSplashLogo.setScaleX(0.5f);
        ivSplashLogo.setScaleY(0.5f);
        ivSplashLogo.setAlpha(0f);

        ivSplashLogo.animate()
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(800)
                .withEndAction(this::startExpandingAnimation)
                .start();
    }

    private void startExpandingAnimation() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            vOrangeBackground.setScaleX(1f);
            vOrangeBackground.setScaleY(1f);

            float maxDimension = Math.max(getResources().getDisplayMetrics().widthPixels,
                    getResources().getDisplayMetrics().heightPixels);
            float scaleFactor = (maxDimension / vOrangeBackground.getWidth()) * 2.5f;

            vOrangeBackground.animate()
                    .scaleX(scaleFactor)
                    .scaleY(scaleFactor)
                    .setDuration(600)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }
                    })
                    .start();
        }, 600);
    }
}
