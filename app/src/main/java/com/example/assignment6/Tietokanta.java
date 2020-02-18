package com.example.assignment6;

import androidx.room.RoomDatabase;
import androidx.room.Database;


@Database(entities = {Data.class}, version = 1, exportSchema = false)
public abstract class Tietokanta extends RoomDatabase {
    public static final String NIMI = "DATABASE";
    public abstract MyDao myDao();
}
