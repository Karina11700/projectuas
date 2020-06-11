package com.example.bookstore;

public class List {
    private String nama;
    private String harga;
    private String gambar;
    private String desc;
    private String ket;

    public List(String datanama, String dataharga, String datagambar, String datadesc, String dataket){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        desc = datadesc;
        ket = dataket;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDesc() {
        return desc;
    }

    public String getKet() {
        return ket;
    }
}
