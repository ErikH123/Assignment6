package com.example.assignment6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ListView listView;
    private Adapteri adapteri;
    private ArrayList<Data> lista;
    private Date aika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        adapteri = new Adapteri(this, R.layout.custom_layout, lista);
        listView.setAdapter(adapteri);

         final Tietokanta tietokanta = Room.databaseBuilder(
                getApplicationContext(),
                Tietokanta.class,
                Tietokanta.NIMI
        ).allowMainThreadQueries()
                 .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aika = Calendar.getInstance().getTime();
                int iend = aika.toString().indexOf("G");
                if(!editText.getText().toString().isEmpty()) {
                    tietokanta.myDao().delete();
                    tietokanta.myDao().insert(new Data(editText.getText().toString(), aika.toString().substring(0, iend)));
                    editText.setText("");
                    lista.addAll(tietokanta.myDao().getAll());
                    adapteri.notifyDataSetChanged();
                }
            }
        });
    }
}
