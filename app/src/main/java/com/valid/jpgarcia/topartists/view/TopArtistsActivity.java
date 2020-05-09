package com.valid.jpgarcia.topartists.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.valid.jpgarcia.topartists.R;
import com.valid.jpgarcia.topartists.adapter.ArtistAdapter;
import com.valid.jpgarcia.topartists.di.BaseApplication;
import com.valid.jpgarcia.topartists.model.artist.Artist;
import com.valid.jpgarcia.topartists.model.artist.Attr;
import com.valid.jpgarcia.topartists.model.artist.Data;
import com.valid.jpgarcia.topartists.model.artist.TopArtist;
import com.valid.jpgarcia.topartists.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopArtistsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArtistAdapter adapter;
    private List<Artist> artists;
    private TopArtist topArtist;
    private Attr attr;

    private Disposable disposable;

    private static final String GET_TOP_ARTISTS = "geo.gettopartists";
    private static final String COUNTRY = "colombia";
    private static final String API_KEY = "829751643419a7128b7ada50de590067";
    private static final String FORMAT = "json";

    @Inject
    WebServiceClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);

        setUpDagger();
        setUpView();
        launchRequest();
    }

    private void setUpDagger(){
        ((BaseApplication)getApplication()).getRetrofitComponent().inject(this);
        //((BaseApplication)getApplication()).getConectionComponent().inject(this);
    }

    private void launchRequest(){

        Call<Data> call = client.getArtist(GET_TOP_ARTISTS, COUNTRY, API_KEY, FORMAT);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                adapter.setData(response.body().getTopArtist().getArtist());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("TAG1", "Error: "+ t.getMessage());
            }
        });
    }
/*
    private Observable crearObservable(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try{
                    emitter.onNext(artist);
                }catch (Exception e){

                }
            }
        });
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }

    private void setUpView(){
        artists = new ArrayList<>();
        attr = new Attr();
        topArtist = new TopArtist();
        adapter = new ArtistAdapter(artists);
        recyclerView = findViewById(R.id.recycler_view_artists);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(adapter);
    }
}
