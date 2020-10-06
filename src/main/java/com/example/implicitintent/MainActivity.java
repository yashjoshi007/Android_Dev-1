package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(EditText) findViewById(R.id.a);
        b=(EditText) findViewById(R.id.b);
        c=(EditText) findViewById(R.id.c);

    }
    public void openWebsite(View view) {
        String url= a.getText().toString();
        Uri webpage= Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,webpage);
        if(i.resolveActivity(getPackageManager())!=null)
        {
            startActivity(i);
            Toast q=Toast.makeText(this,"Opening",Toast.LENGTH_SHORT);
            q.show();
        }
        else
        {
            a.setText("Enter URL Again"+"");
        }
    }
    public void openLocation(View view) {
        String loca=b.getText().toString();
        Uri address=Uri.parse("geo:0,0?q=" + loca);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            Toast q=Toast.makeText(this,"Locating",Toast.LENGTH_SHORT);
            q.show();
        } else {
            b.setText("Enter Location Again" + "");
        }
    }
    public void shareText(View view) {
        String txt = c.getText().toString();
        String q ="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(q)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
    public  void takepict(View v)
    {
        Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(i.resolveActivity(getPackageManager())!=null)
        {
            startActivity(i);
            Toast q=Toast.makeText(this,"Select",Toast.LENGTH_LONG);
            q.show();
        }
    }

}