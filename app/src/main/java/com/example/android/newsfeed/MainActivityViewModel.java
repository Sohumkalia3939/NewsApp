package com.example.android.newsfeed;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Created by acer on 05-03-2018.
 */

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAB2 =MainActivityViewModel.class.getSimpleName();
    private Repository mRepository;

    private LiveData<List<News>> mNewList;

    public MainActivityViewModel(@NonNull Application application)  {
        super(application);
        Log.i(TAB2,"MainActivityViewModel call");
        this.mRepository = new Repository();
        this.mNewList = mRepository.getNews();
    }

     LiveData<List<News>> getNews(){
        Log.i(TAB2,"getNews call");
        return mNewList;
    }

    void setSearch(String search){
         Log.i(TAB2,"setSearch call");
         Repository.newssearch = search;
         mRepository.fetch();
    }





}
