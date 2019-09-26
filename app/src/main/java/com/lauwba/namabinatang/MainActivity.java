package com.lauwba.namabinatang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_play, btn_about, btn_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play=findViewById(R.id.btn_play);
        btn_about=findViewById(R.id.btn_about);
        btn_keluar=findViewById(R.id.btn_keluar);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i= new Intent(MainActivity.this,Play.class);
            startActivity(i);
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Tentang Aplikasi");
                builder1.setMessage("Pengenalan Binatang Versi 1.0\nCreated by Erwin Aji N");
                builder1.setPositiveButton("Tutup", null);
                builder1.show();
            }
        });
        btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Keluar Aplikasi");
                builder1.setMessage("Apakah anda ingin keluar?");
                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                });
                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder1.show();
            }
        });
    }
}
