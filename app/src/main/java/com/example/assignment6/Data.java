package com.example.assignment6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Data {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "text_from_editText")
    public String text_from_editText;

    @ColumnInfo(name = "time")
    public String time;

    public Data(String text_from_editText, String time) {
        this.text_from_editText = text_from_editText;
        this.time = time;
    }
}

