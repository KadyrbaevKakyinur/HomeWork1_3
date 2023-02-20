package com.example.homework1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonSend;
    private EditText editText2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSend = findViewById(R.id.btn_send);
        editText = findViewById(R.id.edt_txt);
        editText2 = findViewById(R.id.edt_email);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = editText.getText().toString();
                String text2 = editText2.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{text2});
                email.putExtra(Intent.EXTRA_TEXT, text);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"выберите email клиент;"));

            }
        });
    }

}