package com.example.vpphongngatapp.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vpphongngatapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class ResetPasswordActivity extends AppCompatActivity {

    private TextInputEditText etNewPassword, etConfirmNewPassword;
    private MaterialButton btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        initViews();
        setupListeners();
    }

    private void initViews() {
        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmNewPassword = findViewById(R.id.etConfirmNewPassword);
        btnResetPassword = findViewById(R.id.btnResetPassword);
    }

    private void setupListeners() {
        btnResetPassword.setOnClickListener(v -> {
            String newPassword = etNewPassword.getText() != null ? etNewPassword.getText().toString().trim() : "";
            String confirmPassword = etConfirmNewPassword.getText() != null ? etConfirmNewPassword.getText().toString().trim() : "";

            if (newPassword.isEmpty()) {
                etNewPassword.setError("Vui lòng nhập mật khẩu mới");
                etNewPassword.requestFocus();
                return;
            }

            if (confirmPassword.isEmpty()) {
                etConfirmNewPassword.setError("Vui lòng xác nhận mật khẩu mới");
                etConfirmNewPassword.requestFocus();
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                etConfirmNewPassword.setError("Mật khẩu xác nhận không khớp");
                etConfirmNewPassword.requestFocus();
                return;
            }

            Toast.makeText(this, "Đặt lại mật khẩu thành công! Vui lòng đăng nhập lại.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
