package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    MovieFragment movieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        Bundle bundle = new Bundle();
        bundle.putString(title,getIntent().getExtras().getString(title));
        bundle.putString(desc,genre+":"+getIntent().getExtras().getString(genre)+" "+year+":"+getIntent().getExtras().getString(year));
        bundle.putInt(img,getIntent().getExtras().getInt(img));
        bundle.putFloat(rating,getIntent().getFloatExtra(rating,0.0f));
        movieFragment = new MovieFragment();
        movieFragment.setArguments(bundle);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,movieFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent();
        it.putExtra(position,getIntent().getIntExtra(position,0));
        it.putExtra(rating,movieFragment.getRating());
        setResult(RESULT_OK,it);
        finish();
    }

}
