package com.example.muhamadarief.belajarsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateBiodata extends AppCompatActivity {

    private EditText edtNama, edtNim;
    private Button btnUpdate;
    DatabaseAdapter dbAdapter;
    String id, nama, nim;
    LihatBiodata lihatBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbAdapter = new DatabaseAdapter(this);

        Intent i = this.getIntent();
        id = i.getStringExtra("id");
        nama = i.getStringExtra("nama");
        nim = i.getStringExtra("nim");

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtNim = (EditText) findViewById(R.id.edtNim);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        edtNama.setText(nama);
        edtNim.setText(nim);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();
                nim = edtNim.getText().toString();
                dbAdapter.update(id,nama,nim);
                finish();
            }
        });
    }



}
