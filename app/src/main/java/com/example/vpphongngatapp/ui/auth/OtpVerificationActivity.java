package com.example.vpphongngatapp.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vpphongngatapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class OtpVerificationActivity extends AppCompatActivity {

    private TextInputEditText etOtp;
    private MaterialButton btnVerifyOtp;
    private TextView tvResendOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        initViews();
        setupListeners();
    }

    private void initViews() {
        etOtp = findViewById(R.id.etOtp);
        btnVerifyOtp = findViewById(R.id.btnVerifyOtp);
        tvResendOtp = findViewById(R.id.tvResendOtp);
    }

    private void setupListeners() {
        btnVerifyOtp.setOnClickListener(v -> {
            String otp = etOtp.getText() != null ? etOtp.getText().toString().trim() : "";
            if (otp.length() < 6) {
                etOtp.setError("Vui lòng nhập đủ 6 chữ số OTP");
                etOtp.requestFocus();
                return;
            }

            Toast.makeText(this, "Xác thực OTP thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(OtpVerificationActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
            finish();
        });

        tvResendOtp.setOnClickListener(v -> {
            Toast.makeText(this, "Đã gửi lại mã OTP mới!", Toast.LENGTH_SHORT).show();
        });
    }
}
