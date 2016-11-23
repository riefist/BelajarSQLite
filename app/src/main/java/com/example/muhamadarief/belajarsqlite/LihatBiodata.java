package com.example.muhamadarief.belajarsqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class LihatBiodata extends AppCompatActivity {
    private ListView listView;
    DatabaseAdapter dbAdapter;
    ArrayList<Biodata> biodatas;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        listView = (ListView) findViewById(R.id.listview);
        dbAdapter = new DatabaseAdapter(this);
        dbAdapter.open();
        biodatas = dbAdapter.getAllBiodata();
        dbAdapter.close();

        adapter = new CustomAdapter(LihatBiodata.this,R.id.txt_nama, R.layout.list_item_row, biodatas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final Biodata biodata = adapter.getItem(position);

                CharSequence[] dialogitem = {"Update Biodata", "Delete Biodata"};

                AlertDialog.Builder builder = new AlertDialog.Builder(LihatBiodata.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                //Update Data
                                Intent intent = new Intent(LihatBiodata.this, UpdateBiodata.class);
                                intent.putExtra("id", ""+biodata.getId());
                                intent.putExtra("nama", ""+biodata.getNama());
                                intent.putExtra("nim", ""+biodata.getNim());
                                startActivity(intent);
                                break;
                            case 1:
                                dbAdapter.open();
                                dbAdapter.delete("" + biodata.getId());
                                dbAdapter.close();
                                reloadAllData();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        }

    public void reloadAllData(){
        //ambil data
        dbAdapter.open();
        biodatas = dbAdapter.getAllBiodata();
        dbAdapter.close();
        //clear adapter
        adapter.clear();
        //add data pada adapter
        adapter.addAll(biodatas);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ambil data
        dbAdapter.open();
        biodatas = dbAdapter.getAllBiodata();
        dbAdapter.close();
        //clear adapter
        adapter.clear();
        //add data pada adapter
        adapter.addAll(biodatas);

        adapter.notifyDataSetChanged();
    }
}
