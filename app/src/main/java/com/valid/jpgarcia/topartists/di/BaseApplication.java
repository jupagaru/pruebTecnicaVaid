package com.valid.jpgarcia.topartists.di;

import android.app.Application;

import com.valid.jpgarcia.topartists.database.ConectionSQLiteHelper;

public class BaseApplication extends Application {

    private RetrofitComponent retrofitComponent;
    //private DBComponent dbComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        retrofitComponent = DaggerRetrofitComponent
                .builder()
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public RetrofitComponent getRetrofitComponent(){
        return retrofitComponent;
    }

    /*public DBComponent getConectionComponent(){
        return dbComponent;
    }*/

}
