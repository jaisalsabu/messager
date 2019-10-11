package com.example.messager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.editText);
        txt2=findViewById(R.id.editText2);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi= PendingIntent.getActivity(getApplicationContext(),0,i,0);
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(txt1.getText().toString(),null,txt2.getText().toString(),pi,null);
                Toast.makeText(MainActivity.this,"Message sent to:"+txt1,Toast.LENGTH_LONG).show();
            }
        });


    }
}
