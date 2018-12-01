package com.example.jabadabadoo.uxdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    public void paynoow(View view) {
        Toast.makeText(this,"De har nu betalt, maden er klar inden længe!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));

    }
}
