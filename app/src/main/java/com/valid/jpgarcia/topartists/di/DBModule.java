package com.valid.jpgarcia.topartists.di;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.valid.jpgarcia.topartists.database.ConectionSQLiteHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {

    @Singleton
    @Provides
    ConectionSQLiteHelper provideConectionSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        return new ConectionSQLiteHelper(context, name, factory, version);
    }
}
