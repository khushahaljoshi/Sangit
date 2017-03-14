package com.example.kjoshi.musicplayer;

import android.app.LoaderManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K. Joshi on 11-Mar-17.
 */
public class SplashScreen extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Song>>{

    private static final int SONG_LODER_ID=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screeen);
        LoaderManager loaderManager=getLoaderManager();
        loaderManager.initLoader(SONG_LODER_ID, null, this);


    }
    @Override
    public Loader<ArrayList<Song>> onCreateLoader(int i ,Bundle bundle){
        return new SongsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Song>> loader,ArrayList<Song> songs){
        Intent intent=new Intent(this,MainActivity.class);
        MainActivity.songs=songs;
        startActivity(intent);

    }
    @Override
    public void onLoaderReset(Loader<ArrayList<Song>> loader) {
        // Loader reset, so we can clear out our existing data.
    }



}





