package com.wtf.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    ImageView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        view = findViewById(R.id.view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Объект, при создании связывающий ImageView и вызывающий родительский метод execute
                //с параметром - строкой из editText
                //new DownloadImageTask(view).execute(editText.getText().toString());
                DownloadImageTask downloadImageTask = new DownloadImageTask(view);
                downloadImageTask.execute(editText.getText().toString());
            }
        });

    }
}

