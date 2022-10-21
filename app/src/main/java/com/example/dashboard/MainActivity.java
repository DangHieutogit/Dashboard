package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoveisViewPager();

    }

    private void setupMoveisViewPager(){
        ViewPager2 moviesViewPager = findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);

        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));

    }


    private List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        Movie passengers = new Movie();
        passengers.poster = R.drawable.d;
        passengers.name = "Em's Be's";
        passengers.category="Iem be cua anh";
        passengers.releaseDate = "11/09/2003";
        passengers.rating = 5;
        movies.add(passengers);

        Movie embea = new Movie();
        embea.poster = R.drawable.a;
        embea.name = "Anhh che em beo a` :< ";
        embea.category = "Drama Love";
        embea.releaseDate = "19/10/2022";
        embea.rating = 4.8f;
        movies.add(embea);

        Movie embeb = new Movie();
        embeb.poster = R.drawable.e;
        embeb.name = "Híu Bị Bỏ Bùa";
        embeb.category = "Drama Love";
        embeb.releaseDate = "20/10/2022";
        embeb.rating = 4.5f;
        movies.add(embeb);

        Movie embec = new Movie();
        embec.poster = R.drawable.a;
        embec.name = "Anhh hong iu iem";
        embec.category = "Drama Love";
        embec.releaseDate = "21/10/2022";
        embec.rating = 5f;
        movies.add(embec);

        return movies;
    }

}