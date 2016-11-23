package com.example.muhamadarief.belajarsqlite;

/**
 * Created by Muhamad Arief on 23/11/2016.
 */

public class Biodata {
    private String id, nama, nim;

    public Biodata(String id, String nama, String nim) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    public Biodata(){

    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}
