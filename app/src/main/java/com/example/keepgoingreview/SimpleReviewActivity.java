package com.example.keepgoingreview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SimpleReviewActivity extends AppCompatActivity {
    private final int WRITE_REVIEW_REQUESTCODE=200;
    private static final String HOST_NETWORK_PROTOCOL = "http://";
    private static final String HOST_ADDRESS = "10.0.2.2:8080/";
    private static final String HOST_APP_NAME = "webapp/android";

    private List<SimpleBoardReviewView> list;

    Button btn_writeReview;
    Button btn_searchReview;

    TextView tv_articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_review);
        setTitle("리뷰 게시판");
        tv_articles = findViewById(R.id.tv_articles);

        final String strUrl = HOST_NETWORK_PROTOCOL +
                                HOST_ADDRESS +
                                HOST_APP_NAME + "/review/1";

        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setDoOutput(false);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

                    StringBuilder input = new StringBuilder();
                    String line;
                    while( (line = reader.readLine()) != null ) {
                        input.append(line);
                    }
                    JSONObject jsonObject = new JSONObject(input.toString());
                    JSONArray jsonArray = (JSONArray)jsonObject.get("list");
                    list = (List<SimpleBoardReviewView>) jsonArray;

                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        tv_articles.setText(list.get(0).getMember_id());

        btn_writeReview = findViewById(R.id.btn_writeReview);
        btn_searchReview = findViewById(R.id.btn_searchReview);
        btn_writeReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteReviewActivity.class);
                startActivityForResult(intent, WRITE_REVIEW_REQUESTCODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
