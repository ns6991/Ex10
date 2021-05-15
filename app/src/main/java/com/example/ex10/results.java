package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.ex10.R;

public class results extends AppCompatActivity {
    int a, b, c;
    TextView x3, x4;
    double root1, root2;
    double dis;
    String url;
    WebView web;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent gi = getIntent();
        a = gi.getIntExtra("aa", 1);
        b = gi.getIntExtra("bb", 1);
        c = gi.getIntExtra("cc", 1);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);
        web = findViewById(R.id.web);

        url = "https://www.google.com/search?q=" + a + "x%5E2%2B" + b + "x%2B" + c + "&oq=x%5E2&aqs=chrome.0.69i59l3j69i57j0l2j69i61l2.3824j0j7&sourceid=chrome&ie=UTF-8";

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new MyWebViewClient());

        dis = b * b - 4 * a * c;

        if (dis > 0) {
            root1 = (-b + Math.sqrt(dis)) / (2 * a);
            root2 = (-b - Math.sqrt(dis)) / (2 * a);

        }
        else if (dis == 0) {
            root1 = root2 = -b / (2 * a);
        }
        else {
            root1 = -b / (2 * a);
            root2 = Math.sqrt(-dis) / (2 * a);
            check = true;
        }

        if (check == true){
            x3.setText("X1 = "+root1+" + "+root2+"i");
            x4.setText("X2 = "+root1+" - "+root2+"i");
        }
        else {
            x3.setText("X1: " + root1);
            x4.setText("X2: " + root2);
        }

        web.loadUrl(url);

    }

    public void goback(View view) {
        Intent wi = getIntent();
        wi.putExtra("x1",root1);
        wi.putExtra("x2", root2);
        wi.putExtra("x3",check);
        setResult(RESULT_OK,wi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}