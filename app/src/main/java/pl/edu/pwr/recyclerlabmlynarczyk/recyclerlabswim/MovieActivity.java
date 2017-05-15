package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindString;
import butterknife.ButterKnife;


public class MovieActivity extends AppCompatActivity {
    @BindString(R.string.title) String title;
    @BindString(R.string.year) String year;
    @BindString(R.string.genre) String genre;
    @BindString(R.string.img_txt) String img;
    @BindString(R.string.rating) String rating;
    @BindString(R.string.position) String position;
    @BindString(R.string.desc) String desc;
    @BindString(R.string.actorsArr) String actorsArr;
    @BindString(R.string.imgsArr) String imgsArr;
    MovieFragment movieFragment;
    float savedRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_movie);
        if(getFragmentManager().findFragmentByTag(getString(R.string.change_flag))==null){
            Bundle bundle = new Bundle();
            bundle.putString(title, getIntent().getExtras().getString(title));
            bundle.putString(desc, genre + ":" + getIntent().getExtras().getString(genre) + " " + year + ":" + getIntent().getExtras().getString(year));
            bundle.putInt(img, getIntent().getExtras().getInt(img));
            bundle.putFloat(rating, getIntent().getFloatExtra(rating, 0.0f));
            bundle.putStringArray(actorsArr, getIntent().getStringArrayExtra(actorsArr));
            bundle.putIntArray(imgsArr, getIntent().getIntArrayExtra(imgsArr));
            movieFragment = new MovieFragment();
            movieFragment.setArguments(bundle);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, movieFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(movieFragment!=null){
            outState.putFloat(rating,movieFragment.getRating());
        }
        else if(savedRating!=0) {
            outState.putFloat(rating, savedRating);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!= null) {
            savedRating = savedInstanceState.getFloat(rating, 0.0f);
        }
        if(movieFragment!=null)
            movieFragment.setRating(savedRating);

    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent();
        it.putExtra(position,getIntent().getIntExtra(position,0));
        if(movieFragment!=null)
            it.putExtra(rating,movieFragment.getRating());
        else {
            it.putExtra(rating,savedRating);
        }
        setResult(RESULT_OK,it);
        finish();
    }
}
