package com.dorizu.umovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovie extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        Movie movieTangkap = getIntent().getParcelableExtra("key");

        ImageView thimnail = findViewById(R.id.img_thumnail);
        TextView judul = findViewById(R.id.judul);
        TextView rilis =  findViewById(R.id.tgl_rilis);
        TextView durasiXgenre =  findViewById(R.id.durasi_genre);
        TextView deskripsi =  findViewById(R.id.diskripsi);
        TextView director =  findViewById(R.id.director);
        TextView bahasa =  findViewById(R.id.bahasa);
        ImageView back =  findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(DetailMovie.this, MainActivity.class);
                startActivity(backHome);
            }
        });

        Glide.with(this)
                .load(movieTangkap.getThunail())
                .apply(new RequestOptions().override(350, 550))
                .into(thimnail);
        judul.setText(movieTangkap.getJudul());
        rilis.setText(movieTangkap.getTanggalRilis());
        durasiXgenre.setText(movieTangkap.getDurasi()+" | "+ movieTangkap.getGenre());
        deskripsi.setText(movieTangkap.getOverview());
        director.setText("Director : "+movieTangkap.getDirector());
        bahasa.setText("Original Language : " + movieTangkap.getBahasa());
    }
}
