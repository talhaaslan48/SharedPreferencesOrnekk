package com.talha.odev4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.talha.odev4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = this.getSharedPreferences("com.talha.odev4.databinding.ActivityMainBinding", Context.MODE_PRIVATE);
    }

    public void kaydet(View view) {
        String name = binding.isim.getText().toString();
        String location = binding.konum.getText().toString();

        sharedPreferences.edit().putString("isim", name).apply();
        sharedPreferences.edit().putString("konum", location).apply();

        Toast.makeText(this, "Bilgileriniz Kaydedildi", Toast.LENGTH_SHORT).show();

    }

    public void goster(View view) {
        String name = sharedPreferences.getString("isim", "Kayıtlı isim bulunamadı!");
        String location = sharedPreferences.getString("konum", "Konum bulunamadı!");

        binding.ad.setText("İsim: " + name);
        binding.konum1.setText("Konum: " + location);

    }

    public void sil(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        binding.ad.setText("");
        binding.konum1.setText("");

        Toast.makeText(this, "Bilgileriniz Silindi", Toast.LENGTH_SHORT).show();

    }

}

