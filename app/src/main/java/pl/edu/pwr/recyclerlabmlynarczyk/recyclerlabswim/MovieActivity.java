package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieActivity extends AppCompatActivity {
//    @BindView(R.id.title_desc) TextView titleDesc;
//    @BindView(R.id.image_view_desc) ImageView imageViewDesc;
//    @BindView(R.id.textview_desc) TextView textDesc;
//    @BindView(R.id.rating_bar) RatingBar ratingBar;
    @BindString(R.string.title) String title;
    @BindString(R.string.year) String year;
    @BindString(R.string.genre) String genre;
    @BindString(R.string.img_txt) String img;
    @BindString(R.string.rating) String rating;
    @BindString(R.string.position) String position;
    RatingBar ratingBar;
    TextView textDesc;
    ImageView imageViewDesc;
    TextView titleDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MovieFragment movieFragment = new MovieFragment();
        fragmentTransaction.add(R.id.fragment_container,movieFragment);
        fragmentTransaction.commit();
        ratingBar = movieFragment.getRatingbar();
        textDesc = movieFragment.getTextDesc();
        imageViewDesc = movieFragment.geImageViewDesc();
        titleDesc = movieFragment.getTitleDesc();
        //setData();
    }

    private void setData() {
        titleDesc.setText(getIntent().getExtras().getString(title));
        textDesc.setText(genre+":"+getIntent().getExtras().getString(genre)+" "+year+":"+getIntent().getExtras().getString(year));
        imageViewDesc.setImageDrawable(getDrawable(getIntent().getExtras().getInt(img)));
        ratingBar.setRating(getIntent().getFloatExtra(rating,0.0f));
    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent();
        it.putExtra(position,getIntent().getIntExtra(position,0));
        it.putExtra(rating,ratingBar.getRating());
        setResult(RESULT_OK,it);
        finish();
    }

}
