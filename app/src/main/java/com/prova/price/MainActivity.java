package com.prova.price;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor;
    private EditText edtNumero;
    private EditText edtTaxa;
    private TextView txtPrest;
    private ListView lvTabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = findViewById(R.id.edtValorBem);
        edtNumero = findViewById(R.id.edtNPrestacao);
        edtTaxa = findViewById(R.id.edtTaxa);
        txtPrest = findViewById(R.id.txtPrestacao);
        lvTabela = findViewById(R.id.lvTabela);

    }

    public void Calcular(View view){
        Double valor = 0.0;
        Double taxa = 0.0;
        Double prestacao = 0.0;
        int numero = 0;
        boolean validador = true;

        if (!edtValor.getText().toString().isEmpty()){
            valor = Double.parseDouble(edtValor.getText().toString());
        }else {
            edtValor.setError("Preencha o campo!");
            validador = false;
        }

        if (!edtNumero.getText().toString().isEmpty()){
            numero = Integer.parseInt(edtNumero.getText().toString());
        }else {
            edtNumero.setError("Preencha o campo!");
            validador = false;
        }

        if (!edtTaxa.getText().toString().isEmpty()){
            taxa = Double.parseDouble(edtTaxa.getText().toString());
        }else {
            edtTaxa.setError("Preencha o campo!");
            validador = false;
        }

        if (validador){
            prestacao = valor * ((Math.pow((1+taxa), numero)*taxa))/((Math.pow((1+taxa), numero)-1));
            txtPrest.setText("Prestação:\nR$ "+String.format("%.2f",prestacao));
            txtPrest.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            ArrayAdapter adapter = new PriceAdapter(this, preencherDados(prestacao, numero, valor, taxa));
//            final Intent intent = new Intent(MainActivity.this, Resultado.class);
//            intent.putExtra("adapter", preencherDados(prestacao, numero, valor, taxa));
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    startActivity(intent);
//                }
//            }, 5000);
            lvTabela.setAdapter(adapter);
        } else {
            lvTabela.setAdapter(null);
            Toast.makeText(MainActivity.this, "Preencha os Campos obrigatorios!", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<Price> preencherDados(Double prestacao, int numero, Double valor, Double taxa) {
        ArrayList<Price> dados = new ArrayList<>();
        int n;
        Price temp;
        double vetJuros[] = new double[numero+1];
        double vetAmort[] = new double[numero+1];
        double vetSaldo[] = new double[numero+1];
        vetSaldo[0] = valor;
        vetJuros[0] = 0;
        vetAmort[0] = 0;
        for (n=1; n<=numero; n++){
            vetJuros[n]=vetSaldo[n-1]*taxa;
            vetAmort[n]=prestacao-vetJuros[n];
            vetSaldo[n]=vetSaldo[n-1]-vetAmort[n];
            temp = new Price(Double.valueOf(n),prestacao,vetJuros[n],vetAmort[n],vetSaldo[n]);
            dados.add(temp);
        }
        return dados;
    }

}
