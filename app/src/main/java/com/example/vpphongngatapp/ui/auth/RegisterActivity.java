package com.example.vpphongngatapp.ui.auth;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.vpphongngatapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private MaterialButton btnRoleStudent, btnRoleParent, btnRegisterSubmit;
    private TextView tvLabelName, tvLabelEmail, tvLoginLink;
    private TextInputEditText etFullName, etEmail, etPassword, etConfirmPassword;
    private CheckBox cbTerms;

    private boolean isStudentRole = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        setupLoginLinkColor();
        setupListeners();
    }

    private void initViews() {
        btnRoleStudent = findViewById(R.id.btnRoleStudent);
        btnRoleParent = findViewById(R.id.btnRoleParent);
        btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);
        tvLabelName = findViewById(R.id.tvLabelName);
        tvLabelEmail = findViewById(R.id.tvLabelEmail);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        cbTerms = findViewById(R.id.cbTerms);
    }

    private void setupLoginLinkColor() {
        String fullText = "Bạn đã có tài khoản? Đăng nhập ngay";
        SpannableString spannableString = new SpannableString(fullText);
        int startIndex = fullText.indexOf("Đăng nhập ngay");
        if (startIndex != -1) {
            ForegroundColorSpan orangeSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.primary_orange));
            spannableString.setSpan(orangeSpan, startIndex, fullText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tvLoginLink.setText(spannableString);
    }

    private void setupListeners() {
        btnRoleStudent.setOnClickListener(v -> setRole(true));
        btnRoleParent.setOnClickListener(v -> setRole(false));

        btnRegisterSubmit.setOnClickListener(v -> {
            String name = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
            String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
            String password = etPassword.getText() != null ? etPassword.getText().toString().trim() : "";
            String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

            if (name.isEmpty()) {
                etFullName.setError("Vui lòng nhập họ và tên");
                etFullName.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Vui lòng nhập email");
                etEmail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Vui lòng nhập mật khẩu");
                etPassword.requestFocus();
                return;
            }

            if (confirmPassword.isEmpty()) {
                etConfirmPassword.setError("Vui lòng xác nhận mật khẩu");
                etConfirmPassword.requestFocus();
                return;
            }

            if (!password.equals(confirmPassword)) {
                etConfirmPassword.setError("Mật khẩu xác nhận không khớp");
                etConfirmPassword.requestFocus();
                return;
            }

            if (!cbTerms.isChecked()) {
                Toast.makeText(this, "Vui lòng đồng ý với Điều khoản & Chính sách bảo mật", Toast.LENGTH_SHORT).show();
                return;
            }

            String roleStr = isStudentRole ? "Học sinh" : "Phụ huynh";
            Toast.makeText(this, "Đăng ký thành công tài khoản " + roleStr + "!", Toast.LENGTH_SHORT).show();
            finish();
        });

        tvLoginLink.setOnClickListener(v -> finish());
    }

    private void setRole(boolean student) {
        isStudentRole = student;
        int orangeColor = ContextCompat.getColor(this, R.color.primary_orange);
        int grayColor = ContextCompat.getColor(this, R.color.text_hint);
        int whiteColor = Color.WHITE;

        if (student) {
            btnRoleStudent.setBackgroundTintList(ColorStateList.valueOf(whiteColor));
            btnRoleStudent.setTextColor(orangeColor);
            btnRoleStudent.setIconTint(ColorStateList.valueOf(orangeColor));

            btnRoleParent.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
            btnRoleParent.setTextColor(grayColor);
            btnRoleParent.setIconTint(ColorStateList.valueOf(grayColor));

            tvLabelName.setText("HỌ VÀ TÊN HỌC SINH");
            tvLabelEmail.setText("EMAIL HỌC SINH");
            btnRegisterSubmit.setText("TẠO TÀI KHOẢN HỌC SINH");
        } else {
            btnRoleParent.setBackgroundTintList(ColorStateList.valueOf(whiteColor));
            btnRoleParent.setTextColor(orangeColor);
            btnRoleParent.setIconTint(ColorStateList.valueOf(orangeColor));

            btnRoleStudent.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
            btnRoleStudent.setTextColor(grayColor);
            btnRoleStudent.setIconTint(ColorStateList.valueOf(grayColor));

            tvLabelName.setText("HỌ VÀ TÊN PHỤ HUYNH");
            tvLabelEmail.setText("EMAIL PHỤ HUYNH");
            btnRegisterSubmit.setText("TẠO TÀI KHOẢN PHỤ HUYNH");
        }
    }
}
