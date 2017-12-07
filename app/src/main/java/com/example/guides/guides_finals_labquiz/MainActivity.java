package com.example.guides.guides_finals_labquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText text1,text2;
    Button Save, Next;
    FileOutputStream fos;
    FileInputStream fis;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText) findViewById(R.id.EDT1);
        text2 = (EditText) findViewById(R.id.EDT2);
        Save = (Button) findViewById(R.id.BTN1);
        Next = (Button) findViewById(R.id.BTN2);
        tvDisplay = (TextView) findViewById(R.id.TV);

    }
    public void saveMessage (View view) {
        String message = text1.getText().toString() + " said '" + text2.getText().toString() + "'";
        try{
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Quotation Saved!", Toast.LENGTH_SHORT).show();

    }

    public void Next(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
