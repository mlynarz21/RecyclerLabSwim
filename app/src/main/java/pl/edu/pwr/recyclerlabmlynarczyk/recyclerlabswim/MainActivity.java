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
        else {
            prepareMovieData();
        }
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
        mAdapter = new MoviesAdapter(movieList, MainActivity.this);
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
        int imageSet1[] = new int[9];
        imageSet1[0] = R.drawable.scene11;
        imageSet1[1] = R.drawable.scene9;
        imageSet1[2] = R.drawable.scene7;
        imageSet1[3] = R.drawable.scene6;
        imageSet1[4] = R.drawable.scene10;
        imageSet1[5] = R.drawable.scene1;
        imageSet1[6] = R.drawable.actor3;
        imageSet1[7] = R.drawable.actor1;
        imageSet1[8] = R.drawable.actor7;
        int imageSet2[] = new int[9];
        imageSet2[0] = R.drawable.scene6;
        imageSet2[1] = R.drawable.scene1;
        imageSet2[2] = R.drawable.scene22;
        imageSet2[3] = R.drawable.scene12;
        imageSet2[4] = R.drawable.scene17;
        imageSet2[5] = R.drawable.scene10;
        imageSet2[6] = R.drawable.actor4;
        imageSet2[7] = R.drawable.actor7;
        imageSet2[8] = R.drawable.actor3;
        int imageSet3[] = new int[9];
        imageSet3[0] = R.drawable.scene10;
        imageSet3[1] = R.drawable.scene6;
        imageSet3[2] = R.drawable.scene18;
        imageSet3[3] = R.drawable.scene21;
        imageSet3[4] = R.drawable.scene15;
        imageSet3[5] = R.drawable.scene19;
        imageSet3[6] = R.drawable.actor8;
        imageSet3[7] = R.drawable.actor3;
        imageSet3[8] = R.drawable.actor1;
        int imageSet4[] = new int[9];
        imageSet4[0] = R.drawable.scene14;
        imageSet4[1] = R.drawable.scene12;
        imageSet4[2] = R.drawable.scene2;
        imageSet4[3] = R.drawable.scene7;
        imageSet4[4] = R.drawable.scene1;
        imageSet4[5] = R.drawable.scene17;
        imageSet4[6] = R.drawable.actor8;
        imageSet4[7] = R.drawable.actor7;
        imageSet4[8] = R.drawable.actor6;
        int imageSet5[] = new int[9];
        imageSet5[0] = R.drawable.scene20;
        imageSet5[1] = R.drawable.scene19;
        imageSet5[2] = R.drawable.scene13;
        imageSet5[3] = R.drawable.scene9;
        imageSet5[4] = R.drawable.scene1;
        imageSet5[5] = R.drawable.scene7;
        imageSet5[6] = R.drawable.actor9;
        imageSet5[7] = R.drawable.actor10;
        imageSet5[8] = R.drawable.actor4;
        int imageSet6[] = new int[9];
        imageSet6[0] = R.drawable.scene3;
        imageSet6[1] = R.drawable.scene7;
        imageSet6[2] = R.drawable.scene9;
        imageSet6[3] = R.drawable.scene10;
        imageSet6[4] = R.drawable.scene2;
        imageSet6[5] = R.drawable.scene11;
        imageSet6[6] = R.drawable.actor2;
        imageSet6[7] = R.drawable.actor9;
        imageSet6[8] = R.drawable.actor1;

        String  actorSet1[] = new String[3];
        actorSet1[0] = "Christian Bale";
        actorSet1[1] = "Robert Downey Jr.";
        actorSet1[2] = "Nicolas Cage";
        String actorSet2[] = new String[3];
        actorSet2[0] = "Antonio Banderas";
        actorSet2[1] = "Johnny Depp";
        actorSet2[2] = "Orlando Bloom";
        String actorSet3[] = new String[3];
        actorSet3[0] = "Orlando Bloom";
        actorSet3[1] = "Robert Downey Jr.";
        actorSet3[2] = "Nicolas Cage";
        String actorSet4[] = new String[3];
        actorSet4[0] = "Antonio Banderas";
        actorSet4[1] = "Johnny Depp";
        actorSet4[2] = "Christian Bale";
        String actorSet5[] = new String[3];
        actorSet5[0] = "Johnny Depp";
        actorSet5[1] = "Nicolas Cage";
        actorSet5[2] = "Antonio Banderas";
        String actorSet6[] = new String[3];
        actorSet6[0] = "Antonio Banderas";
        actorSet6[1] = "Orlando Bloom";
        actorSet6[2] = "Nicolas Cage";

        Movie movie = new Movie("Finding Dory", "Animation, Kids & Family", "2016",R.drawable.dory, imageSet1, actorSet1);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015",R.drawable.inside, imageSet1, actorSet2);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015",R.drawable.shaun, imageSet3, actorSet3);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015",R.drawable.maritian, imageSet6, actorSet4);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015",R.drawable.misson, imageSet5, actorSet3);
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009",R.drawable.up, imageSet5, actorSet6);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014",R.drawable.lego, imageSet2, actorSet5);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008",R.drawable.ironman, imageSet4, actorSet3);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986",R.drawable.aliens, imageSet4, actorSet3);
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000",R.drawable.chicken, imageSet6, actorSet1);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985",R.drawable.back, imageSet5, actorSet3);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981",R.drawable.raiders, imageSet5, actorSet2);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965",R.drawable.goldfinge, imageSet3, actorSet6);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",R.drawable.guardians, imageSet1, actorSet5);
        movieList.add(movie);

        if(mAdapter!=null)
            mAdapter.notifyDataSetChanged();
    }
}

