package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailBuku extends AppCompatActivity {

    public static final String detailnama = "detail nama";
    public static final String detailharga = "detail harga";
    public static final String desc = "detail desc";
    public static final String ket = "detail keterangan";
    public static final String detailimg = "NULL";
    public TextView tvdetailnama;
    public TextView tvdetailharga;
    public TextView tvdetaildesc;
    public TextView tvdetailketerangan;
    public ImageView ivdetailimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        tvdetailnama = findViewById(R.id.tv_detailnama);
        tvdetailharga = findViewById(R.id.tv_detailharga);
        tvdetaildesc = findViewById(R.id.tv_desc);
        tvdetailketerangan = findViewById(R.id.tv_ket);
        ivdetailimg = findViewById(R.id.iv_detailimg);

        String simpannama = getIntent().getStringExtra(detailnama);
        String simpanharga = getIntent().getStringExtra(detailharga);
        String simpandesc = getIntent().getStringExtra(desc);
        String simpanket = getIntent().getStringExtra(ket);
        String simpanimg = getIntent().getStringExtra(detailimg);

        tvdetailnama.setText(simpannama);
        tvdetailharga.setText(simpanharga);
        tvdetaildesc.setText(simpandesc);
        tvdetailketerangan.setText(simpanket);
        Glide
                .with(this)
                .load(simpanimg)
                .centerCrop()
                .into(ivdetailimg);
    }
}
