package com.example.keepgoingreview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int REVIEW_REQUESTCODE=200;
    private static final String HOST_NETWORK_PROTOCOL = "http://";
    private static final String HOST_ADDRESS = "172.30.1.42:8080";
    private static final String HOST_APP_NAME = "webapp/android";

    Button btn_regist;
    Button btn_login;
    Button btn_review;
    Button btn_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Keep Going");

        btn_regist = findViewById(R.id.btn_regist);
        btn_login = findViewById(R.id.btn_login);
        btn_review = findViewById(R.id.btn_review);
        btn_item = findViewById(R.id.btn_item);


        final Intent intent = new Intent(getApplicationContext(), SimpleReviewActivity.class);
        btn_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, REVIEW_REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
