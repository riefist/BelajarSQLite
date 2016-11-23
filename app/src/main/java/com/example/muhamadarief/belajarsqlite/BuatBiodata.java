package com.example.muhamadarief.belajarsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {
    private EditText etNama, etNim;
    private Button btnSimpan;
    DatabaseAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbAdapter = new DatabaseAdapter(this);

        etNama = (EditText) findViewById(R.id.etNama);
        etNim = (EditText) findViewById(R.id.etNim);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                finish();
            }
        });
    }

    private void insertData(){
        String nama = etNama.getText().toString();
        String nim = etNim.getText().toString();
        dbAdapter.open();
        dbAdapter.tambahData(nama, nim);
        dbAdapter.close();
        Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
    }
}
