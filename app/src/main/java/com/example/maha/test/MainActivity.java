package com.example.maha.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        //  Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").error(R.mipmap.ic_launcher).into(imageView);


        textView = (TextView) findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=365f12b479aefadba7d0ba147412b338";
        StringRequest stringRequest = new StringRequest(Request.Method.Get, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("REsponse is"+ response.substring(0, 500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);

    }
}
