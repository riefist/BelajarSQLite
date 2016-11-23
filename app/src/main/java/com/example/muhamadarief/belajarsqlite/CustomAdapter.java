package com.example.muhamadarief.belajarsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhamad Arief on 23/11/2016.
 */

public class CustomAdapter extends ArrayAdapter<Biodata> {
    ArrayList<Biodata> biodata;
    Context context;

    public CustomAdapter(Context context, int resource, int textViewResourceId, ArrayList<Biodata> biodata) {
        super(context, resource, textViewResourceId, biodata);
        this.context = context;
        this.biodata = biodata;
    }

    @Override
    public Biodata getItem(int position) {
        return biodata.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_row, parent, false);
        }

        Biodata currentBiodata = getItem(position);

        TextView nama = (TextView) v.findViewById(R.id.txt_nama);
        TextView nim = (TextView) v.findViewById(R.id.txt_nim);


        nama.setText(currentBiodata.getNama());
        nim.setText(currentBiodata.getNim());

        return v;
    }


}
