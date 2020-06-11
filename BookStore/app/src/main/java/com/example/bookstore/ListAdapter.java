package com.example.bookstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<List> lists;
    private Button btn;

    public ListAdapter(Context mcontext, ArrayList<List> listbuku){
        context= mcontext;
        lists= listbuku;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        List listbaru= lists.get(position);
        String gambarbaru= listbaru.getGambar();
        String harga= listbaru.getHarga();
        String nama= listbaru.getNama();

        holder.tvnamabuku.setText(nama);
        holder.tvhargabuku.setText(harga);
        Glide

            .with(context)
            .load(gambarbaru)
            .centerCrop()
            .into(holder.imgbuku);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgbuku;
        public TextView tvhargabuku;
        public TextView tvnamabuku;
        public TextView tvdetaildesc;
        public TextView tvdetailketerangan;


        public ListViewHolder(@NonNull View itemView) {
                super(itemView);
            imgbuku= itemView.findViewById(R.id.img_list);
            tvhargabuku= itemView.findViewById(R.id.tv_harga);
            tvnamabuku= itemView.findViewById(R.id.tv_nama);
            tvdetaildesc= itemView.findViewById(R.id.tv_desc);
            tvdetailketerangan= itemView.findViewById(R.id.tv_ket);

            btn= itemView.findViewById(R.id.btn_beli);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent = new Intent(context, DetailBuku.class);
                    intent.putExtra(DetailBuku.detailnama, lists.get(getAdapterPosition()).getNama());
                    intent.putExtra(DetailBuku.detailharga, lists.get(getAdapterPosition()).getHarga());
                    intent.putExtra(DetailBuku.desc, lists.get(getAdapterPosition()).getDesc());
                    intent.putExtra(DetailBuku.ket, lists.get(getAdapterPosition()).getKet());
                    intent.putExtra(DetailBuku.detailimg, lists.get(getAdapterPosition()).getGambar());
                    context.startActivity(intent);

                }
            });
        }
    }
}
