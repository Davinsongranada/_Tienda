package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btnReg, btnLog;
    EditText rEmail, rPassword;
    TextView tvMessageR;
    DBproducts pDB = new DBproducts(this, "DBproducts", null, 1);
    SQLiteDatabase db = pDB.getWritableDatabase();
    CardView CardPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rEmail = findViewById(R.id.idEmail);
        rPassword = findViewById(R.id.idPassword);
        btnLog = findViewById(R.id.btnLogIn);
        btnReg = findViewById(R.id.btnRegister);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        CardPreview = findViewById(R.id.pCardPreview);


        //Boton de registro
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SingInActivity.class));
            }
        });


        //Lógica para inicio de sesión
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = rEmail.getText().toString();
                String password = rPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                mAuth
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                tvMessageR.setTextColor(Color.parseColor("#800000"));
                                tvMessageR.setText("No se creo la cuenta");
                            }
                        });

                } else{
                    tvMessageR.setTextColor(Color.parseColor("#800000"));
                    tvMessageR.setText("Debe ingresar todos los datos");
                }

            }
        });

        CardPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}