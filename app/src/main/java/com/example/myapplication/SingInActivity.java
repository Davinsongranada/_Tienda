package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingInActivity extends AppCompatActivity {

    EditText userName, emailUser, passwordUser;
    TextView tvMessageR;
    Button btnR;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userName = findViewById(R.id.etName);
        emailUser = findViewById(R.id.etEmailR);
        passwordUser = findViewById(R.id.etPasswordR);
        tvMessageR = findViewById(R.id.tvMessageR);
        btnR = findViewById(R.id.btnRegR);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String mEmail = emailUser.getText().toString();
            String mPassword = passwordUser.getText().toString();
                if(!mEmail.isEmpty() && !mPassword.isEmpty()){
                    mAuth
                            .createUserWithEmailAndPassword(mEmail, mPassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        tvMessageR.setTextColor(Color.parseColor("#526E48"));
                                        tvMessageR.setText("Cuenta creada exitosamente...");
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    tvMessageR.setTextColor(Color.parseColor("#800000"));
                                    tvMessageR.setText("No se creó la cuenta.....");
                                }
                            });
                } else{
                    tvMessageR.setTextColor(Color.parseColor("#800000"));
                    tvMessageR.setText("Debe ingresar todos los datos");
                }
            }
        });
    }
}