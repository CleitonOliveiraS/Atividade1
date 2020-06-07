package com.prova.price;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PriceAdapter extends ArrayAdapter<Price> {

    private final Context context;
    private final ArrayList<Price> prices;

    public PriceAdapter(Context context, ArrayList<Price> prices) {
        super(context, R.layout.linha, prices);
        this.context = context;
        this.prices = prices;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Price price = prices.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linhaView = inflater.inflate(R.layout.linha, parent, false);

        TextView numeroParcelas = linhaView.findViewById(R.id.numeroParcelas);
        TextView prestacao = linhaView.findViewById(R.id.prestacao);
        TextView juros = linhaView.findViewById(R.id.juros);
        TextView amortizacao = linhaView.findViewById(R.id.amortizacao);
        TextView saldo = linhaView.findViewById(R.id.saldo);

        numeroParcelas.setText(String.format("%d",price.getNumeroParcelas().intValue()));
        prestacao.setText(String.format("%.2f",price.getPrestacao()));
        juros.setText(String.format("%.2f",price.getJuros()));
        amortizacao.setText(String.format("%.2f",price.getAmortizacao()));
        saldo.setText(String.format("%.2f",price.getSaldo()));

        if (position % 2 == 0){
            linhaView.setBackgroundColor(Color.parseColor("#D8AAE9"));
        }

        return linhaView;
    }
}
