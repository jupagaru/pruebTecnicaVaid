package com.valid.jpgarcia.topartists.di;

import com.valid.jpgarcia.topartists.view.TopArtistsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RetrofitModule.class)
public interface RetrofitComponent {
    void inject(TopArtistsActivity daggerActivity);
}
