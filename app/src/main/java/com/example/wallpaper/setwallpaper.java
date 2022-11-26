package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class setwallpaper extends AppCompatActivity {

    Intent intent;
    ImageView imageview;
    Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setwallpaper);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        set = findViewById(R.id.set);
        imageview = findViewById(R.id.finalImage);
        intent = getIntent();

        String url = intent.getStringExtra("image");
        Glide.with(getApplicationContext()).load(url).into(imageview);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bitmap bitmap = ((BitmapDrawable)imageview.getDrawable()).getBitmap();
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}