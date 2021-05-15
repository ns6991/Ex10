package com.example.ex10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex10.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText a, b, c;
    TextView explain1;

    EditText min1,max1;
    int a1, b1, c1;
    double root1, root2;
    int max ,min;
    Random rn;

    TextView x1, x2;
    boolean check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rn = new Random();
        a = findViewById(R.id.A);
        b = findViewById(R.id.B);
        c = findViewById(R.id.C);
        explain1 = findViewById(R.id.explain);
        max1 = findViewById(R.id.max);
        min1 = findViewById(R.id.min);
        explain1.setText("if you want use random numbers,\n enter the minimum and the maximum on the right places");
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x1.setText("");
        x2.setText("");
        max1.setText("");
        min1.setText("");
    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            root1 = data_back.getDoubleExtra("x1", 1);
            root2 = data_back.getDoubleExtra("x2", 1);
            check1 = data_back.getBooleanExtra("x3",false);
            if (check1 == true){
                x1.setText("X1 = "+root1+" + "+root2+"i");
                x2.setText("X2 = "+root1+" - "+root2+"i");
            }
            else {
                x1.setText("X1: " + root1);
                x2.setText("X2: " + root2);
            }


        }
    }

    public void rand(View view) {
        if(max1.getText().toString().equals("")  || min1.getText().toString().equals("")){
            max = 50;
            min = -50;
            Toast.makeText(getApplicationContext(), "Next time fill minimum and maximum!", Toast.LENGTH_LONG).show();

        }
        else{
            max = Integer.parseInt(max1.getText().toString());
            min = Integer.parseInt(min1.getText().toString());
        }



        a1 = rn.nextInt(max - min) + min;
        b1 = rn.nextInt(max - min) + min;
        c1 = rn.nextInt(max - min) + min;
        a.setText("" + a1);
        b.setText("" + b1);
        c.setText("" + c1);
    }

    public void result(View view) {
        if ((a.getText().toString().isEmpty()) || (b.getText().toString().isEmpty()) || (c.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Enter all variables please", Toast.LENGTH_SHORT).show();
        } else {
            a1 = Integer.parseInt(a.getText().toString());
            b1 = Integer.parseInt(b.getText().toString());
            c1 = Integer.parseInt(c.getText().toString());
            Intent si = new Intent(this, results.class);
            si.putExtra("aa", a1);
            si.putExtra("bb", b1);
            si.putExtra("cc", c1);
            startActivityForResult(si, 1);
        }


    }


}