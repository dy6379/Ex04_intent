package com.busanit.ex04_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText2;
    private TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//                intent.putExtra("number",100);
//                intent.putExtra("message","Hello Android!");
                SimpleData data = new SimpleData(100,"Hello Android!");
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        println("MainActivity onCreate 호출됨");

        //SharedPreferences 저장 관련
        Button saveBtn = findViewById(R.id.saveBtn);
        editText2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.text3);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText2.getText().toString();
                if(!str.equals("")){
                    text3.setText(str);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("MainActivity onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("MainActivity onStop 호출됨");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        println("MainActivity onRestart 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("MainActivity onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("MainActivity onPause 호출됨");
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("MainActivity onResume 호출됨");
        restoreState();
    }

    private void saveState() {
        SharedPreferences preferences = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("str",text3.getText().toString());
        editor.apply();
    }
    private void restoreState(){
        SharedPreferences preferences = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((preferences!=null) && (preferences.contains("str"))){
            String str = preferences.getString("str","");
            text3.setText(str);
        }
    }

    private void println(String data) {
        Log.d("myLog",data);
    }
}