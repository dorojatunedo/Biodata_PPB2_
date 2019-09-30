package com.example.belanja.biodata_ppb2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.createChooser;

public class MainActivity extends AppCompatActivity {

    private TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = findViewById(R.id.textAlamat);
    }

    public void alamat(View view) {

        String loc = location.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q="+loc);

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void telepon(View view) {

        String nomor = "085868721863" ;
        Intent telepon = new Intent(Intent. ACTION_DIAL);
        telepon.setData(Uri. fromParts("tel",nomor,null));
        startActivity(telepon);
    }

    public void email(View view) {
        Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(    "mailto", "edorojatun@gmail.com", null));
        email.putExtra(Intent.EXTRA_SUBJECT,"Subject");
        email.putExtra(Intent.EXTRA_TEXT, "Isi Email");
        startActivity(Intent.createChooser(email, "Feedback"));


    }
}
