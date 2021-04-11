package com.example.quizmlmod2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Video_tut_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tut);

        Button btnEng = findViewById(R.id.btnEnglish);
        Button btnHindi = findViewById(R.id.btnHindi);
        Button btnimple = findViewById(R.id.btnImple);

        findViewById(R.id.imageViewEditPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtube.com/playlist?list=PLrJWJ04ZQm6J48-fi0x7fg3Pi7pIg6Jso"));
                startActivity(intent);
            }
        });

        btnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtube.com/playlist?list=PLrJWJ04ZQm6K3ZSYg48BVq6PfN8jj52k3"));
                startActivity(intent);
            }
        });

        btnimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtube.com/playlist?list=PLrJWJ04ZQm6LH_NKE5L-jcmV1NmhVsIup"));
                startActivity(intent);
            }
        });

    }
}
