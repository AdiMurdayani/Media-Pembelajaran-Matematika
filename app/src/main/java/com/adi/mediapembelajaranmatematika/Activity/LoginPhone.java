package com.adi.mediapembelajaranmatematika.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.adi.mediapembelajaranmatematika.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginPhone extends AppCompatActivity {

    private Button btn_generatePhone;
    private EditText edt_phone, edt_code;
    private ProgressBar progressBar;
    private TextView txt_feedback;

    private FirebaseAuth auth;
    private FirebaseUser user;
    private String code = "+62";

    private boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);
        init();
    }

    private void init() {

        edt_phone = findViewById(R.id.edt_number);
        edt_code = findViewById(R.id.code_nomor);
        txt_feedback = findViewById(R.id.feedback);

        progressBar = findViewById(R.id.progressBar);
        edt_code.setText(code);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        btn_generatePhone = findViewById(R.id.btn_generate_phone);
        btn_generatePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no_hp = edt_phone.getText().toString();
                String country_code = edt_code.getText().toString();
                String code_hp_negara = "" + country_code + no_hp;

                Toast.makeText(LoginPhone.this, "Phone Number " + code_hp_negara, Toast.LENGTH_LONG).show();

                if (no_hp.isEmpty() || country_code.isEmpty()) {
                    txt_feedback.setText("Input code nomor dengan benar!");
                    txt_feedback.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    btn_generatePhone.setEnabled(false);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            code_hp_negara,
                            60,
                            TimeUnit.SECONDS,
                            LoginPhone.this,
                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    btn_generatePhone.setEnabled(true);
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    btn_generatePhone.setEnabled(true);
                                    Toast.makeText(LoginPhone.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    super.onCodeSent(s, forceResendingToken);

                                    progressBar.setVisibility(View.INVISIBLE);
                                    btn_generatePhone.setEnabled(true);

                                    Intent intent = new Intent(LoginPhone.this, OtpGenerate.class);
                                    intent.putExtra("verificationId", s);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                    );
                }
            }
        });

        loggedIn = isLoggedIn();
        if (isLoggedIn()) {
            sendUserToHome();
        }
    }

    private boolean isLoggedIn() {
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public void sendUserToHome() {
        Intent i = new Intent(LoginPhone.this, MenuUtama.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}