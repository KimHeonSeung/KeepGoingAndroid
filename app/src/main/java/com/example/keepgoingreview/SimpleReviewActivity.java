package com.example.keepgoingreview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleReviewActivity extends AppCompatActivity {
    private final int WRITE_REVIEW_REQUESTCODE=200;

    Button btn_writeReview;
    Button btn_searchReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_review);
        setTitle("리뷰 게시판");

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
