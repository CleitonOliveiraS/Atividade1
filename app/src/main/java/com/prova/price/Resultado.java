package com.prova.price;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {

    private ListView lvTabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        lvTabela = findViewById(R.id.lvTabela);
        Bundle bundle = getIntent().getExtras();
        ArrayList<? extends Price> list = bundle.getParcelableArrayList("adapter");
        ArrayList<Price> prices = new ArrayList<>();
        prices.addAll(list);
//        for (Price price : list){
//            prices.add(price);
//        }
        ArrayAdapter adapter = new PriceAdapter(this, prices);
        lvTabela.setAdapter(adapter);
    }
}
