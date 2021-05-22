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

import com.adi.mediapembelajaranmatematika.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpGenerate extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private EditText edt_otp_generate;
    private TextView txt_feedback;
    private Button btn_verify;
    private ProgressBar progressBar;

    private String verification_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_generate);
        init();
    }

    private void init() {

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        verification_id = getIntent().getStringExtra("verificationId");

        edt_otp_generate = findViewById(R.id.edt_generate_otp);
        txt_feedback = findViewById(R.id.txt_feedback_otp);

        btn_verify = findViewById(R.id.btn_generate_otp);
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp_generated = edt_otp_generate.getText().toString();

                if (otp_generated.isEmpty()) {
                    txt_feedback.setVisibility(View.VISIBLE);
                    txt_feedback.setText("Input OTP dan coba lagi!");
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    btn_verify.setEnabled(false);

                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verification_id, otp_generated);
                    signInWithPhone(credential);
                }
            }
        });

        progressBar = findViewById(R.id.progressBar_otp);
    }

    private void signInWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            sendUserToHome();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                txt_feedback.setVisibility(View.VISIBLE);
                                txt_feedback.setText("Verifikasi OTP error!");
                            }
                        }

                        progressBar.setVisibility(View.INVISIBLE);
                        btn_verify.setEnabled(true);
                    }
                });
    }

    public void sendUserToHome() {
        Intent i = new Intent(OtpGenerate.this, MenuUtama.class);
        startActivity(i);
        finish();
    }
}