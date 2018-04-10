package com.example.marcelo.staggeredrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;
    private ArrayList<String> imageURLs = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        imageURLs.add("https://i1.wp.com/www.eurodicas.com.br/wp-content/uploads/2017/10/amsterdam.jpg?resize=740,480");
        mNames.add("Amsterdam");

        imageURLs.add("https://www.siliconluxembourg.lu/wp-content/uploads/2017/05/Tallinn_Startups.jpg.pagespeed.ce.pZfiikAuLb.jpg");
        mNames.add("Tallinn");

        imageURLs.add("https://upload.wikimedia.org/wikipedia/commons/1/1d/Fernando_de_Noronha_-_Pernambuco_-_Brasil%285%29.jpg");
        mNames.add("Fernando de Noronha");

        imageURLs.add("http://ouropretotravel.com/wp-content/uploads/photo-gallery/passeios-diamantina.jpg");
        mNames.add("Diamantina");

        imageURLs.add("https://cache-graphicslib.viator.com/graphicslib/thumbs674x446/5623/SITours/skip-the-line-dinner-atop-the-berlin-tv-tower-in-berlin-122496.jpg");
        mNames.add("Berlim");

        imageURLs.add("https://aventurescu.ro/wp-content/uploads/2015/08/paris-820x390.jpg");
        mNames.add("Paris");

        imageURLs.add("https://ci-prod.imgix.net/upload/galeriadeimagens/00206964.jpg?w=555&h=416&fit=crop&auto=compress%2Cformat");
        mNames.add("Tóquio");
        setRecyclerView();
    }

    private void setRecyclerView(){

        Log.d(TAG, "setRecyclerView: initiating recyclerView!");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(this, imageURLs, mNames);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}
