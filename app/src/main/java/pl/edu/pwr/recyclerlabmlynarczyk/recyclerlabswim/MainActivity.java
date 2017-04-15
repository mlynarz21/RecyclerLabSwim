package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindString(R.string.rating) String rating;
    @BindString(R.string.position) String position;
    @BindString(R.string.movies) String movies;

    private ArrayList<Movie> movieList = new ArrayList<>();
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(savedInstanceState!=null) {
            movieList = savedInstanceState.getParcelableArrayList(movies);
        }
        else {prepareMovieData();}
        mAdapter = new MoviesAdapter(movieList, MainActivity.this);
        setRecyclerView();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(setSimpleItemTouchCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mAdapter.setItemRating(data.getIntExtra(position, 0), data.getFloatExtra(rating, 0.0f));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(movies,movieList);
        super.onSaveInstanceState(outState);
    }

    private ItemTouchHelper.SimpleCallback setSimpleItemTouchCallback() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                mAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        };
        return simpleItemTouchCallback;
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_settings) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965",R.drawable.dory);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",R.drawable.dory);
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}

