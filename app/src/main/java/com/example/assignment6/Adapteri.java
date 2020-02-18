package com.example.assignment6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapteri extends ArrayAdapter<Data> {
    private Context context;
    ArrayList<Data> dataset;

    public Adapteri(@NonNull Context context, int resource, @NonNull List objects){
        super(context, resource, objects);
        this.context = context;
        this.dataset = (ArrayList<Data>) objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View converView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.custom_layout, parent, false);
        LinearLayout linearLayout = (LinearLayout) v;

        TextView aika = v.findViewById(R.id.aika);
        TextView teksti = v.findViewById(R.id.teksti);

        aika.setText(dataset.get(position).time);
        teksti.setText(dataset.get(position).text_from_editText);

        return v;
    }
}
