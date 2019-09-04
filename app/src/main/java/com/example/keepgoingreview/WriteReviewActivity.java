package com.example.keepgoingreview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteReviewActivity extends AppCompatActivity {
    Button btn_category;
    Button btn_addImage;
    Button btn_addMap;
    Button btn_confirm;
    Button btn_reset;

    EditText et_title;
    EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        setTitle("리뷰 작성");

        btn_category = findViewById(R.id.btn_category);
        btn_addImage = findViewById(R.id.btn_addImage);
        btn_addMap = findViewById(R.id.btn_addImage);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_reset = findViewById(R.id.btn_reset);

        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);

        btn_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedItem = 0;
                if ((btn_category.getText()).equals("상품")) {
                    checkedItem = 0;
                } else if ((btn_category.getText()).equals("피트니스")) {
                    checkedItem = 1;
                } else if ((btn_category.getText()).equals("장소")){
                    checkedItem = 2;
                } else if ((btn_category.getText()).equals("다이어트")){
                    checkedItem = 3;
                } else if ((btn_category.getText()).equals("웨이트 트레이닝")){
                    checkedItem = 4;
                } else if ((btn_category.getText()).equals("레시피")){
                    checkedItem = 5;
                };
                AlertDialog.Builder dlg = new AlertDialog.Builder(WriteReviewActivity.this);
                dlg.setTitle("카테고리 선택");
                final  String[] category_list = {"상품", "피트니스", "장소", "다이어트", "웨이트 트레이닝", "레시피"};
                dlg.setSingleChoiceItems(category_list, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String msg = String.format("선택하신 항목은 %s 입니다.", category_list[i]);
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        btn_category.setText(category_list[i]);
                    }
                });
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_category.setText("카테고리");
                et_title.setText("");
                et_content.setText("");
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
