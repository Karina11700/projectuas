package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListAdapter listAdapter;
    private RecyclerView recyclerView;
    private ArrayList<List> lists;
    int jumdata;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lists= new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url= "https://karinagita.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumdata = response.length();
                        try {
                            for (int i = 0; i < jumdata; i++) {
                                JSONObject buku = response.getJSONObject(i);
                                String gambarbuku = buku.getString("gambar");
                                String namabuku = buku.getString("nama");
                                String hargabuku = buku.getString("harga");
                                String descbuku = buku.getString("desc");
                                String ketbuku = buku.getString("ket");
                                lists.add(new List(namabuku, hargabuku, gambarbuku, descbuku, ketbuku));
                            }
                            listAdapter = new ListAdapter(MainActivity.this, lists);
                            recyclerView.setAdapter(listAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

    });
            requestQueue.add(request);
    }
}
