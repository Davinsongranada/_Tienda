package com.example.myapplication;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    ImageView bEnseres, bInicio, bAparatos;
    ImageView getPreview, getPreview2, getPreview3, getPreview4,getPreview5, getPreview6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bEnseres = findViewById(R.id.btnEnseres);
        bInicio = findViewById(R.id.btnInicio);
        bAparatos = findViewById(R.id.btnAparatos);
        getPreview = findViewById(R.id.imgPreview);
        getPreview2 = findViewById(R.id.imgPreview2);
        getPreview3 = findViewById(R.id.imgPreview3);
        getPreview4 = findViewById(R.id.imgPreview4);
        getPreview5 = findViewById(R.id.imgPreview5);
        getPreview6 = findViewById(R.id.imgPreview6);

        //ImageView
        getPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Product1Activity.class));
            }
        });

        getPreview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), product.class));
            }
        });


        getPreview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), product.class));
            }
        });

        getPreview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), product.class));
            }
        });

        getPreview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), product.class));
            }
        });

        getPreview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), product.class));
            }
        });




        bEnseres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EnseresActivity.class));
                bEnseres.setColorFilter(ContextCompat.getColor(HomeActivity.this, R.color.orange), PorterDuff.Mode.SRC_IN);
            }
        });

        bAparatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AparatosActivity.class));
            }
        });

        bInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}