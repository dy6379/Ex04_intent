package com.busanit.ex04_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        processIntent(intent);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        println("MenuActivity onCreate 호출됨");
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("MenuActivity onStart 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("MenuActivity onStop 호출됨");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        println("MenuActivity onRestart 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("MenuActivity onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("MenuActivity onPause 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("MenuActivity onResume 호출됨");
    }

    private void println(String data) {
        Log.d("myLog",data);
    }

    private void processIntent(Intent intent) {
        if(intent!=null){
//            int num = intent.getIntExtra("number",0);
//            String msg = intent.getStringExtra("message");
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            if(data!=null){
                textView.setText("전달받은 데이터\nNumber : "+data.number +"\nMessage : "+data.message);
            }
//            textView.setText("전달받은 데이터\nNumber : "+num +"\nMessage : "+msg);
        }
    }
}