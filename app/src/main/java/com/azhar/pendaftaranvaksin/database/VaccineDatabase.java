package com.azhar.pendaftaranvaksin.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.azhar.pendaftaranvaksin.dao.InputDao;
import com.azhar.pendaftaranvaksin.ui.inputdata.ModelInput;

@Database(entities = {ModelInput.class}, version = 1)
public abstract class VaccineDatabase extends RoomDatabase {

    private static VaccineDatabase instance;

    public abstract InputDao inputDao();

    public static synchronized VaccineDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    VaccineDatabase.class, "vaccine_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

}
