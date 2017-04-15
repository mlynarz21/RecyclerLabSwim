package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.title_desc) TextView titleDesc;
    @BindView(R.id.image_view_desc) ImageView imageViewDesc;
    @BindView(R.id.textview_desc) TextView textDesc;
    @BindView(R.id.rating_bar) RatingBar ratingBar;
    @BindString(R.string.title) String title;
    @BindString(R.string.year) String year;
    @BindString(R.string.genre) String genre;
    @BindString(R.string.img_txt) String img;
    @BindString(R.string.rating) String rating;
    @BindString(R.string.position) String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        setData();
        ActionBar a = getSupportActionBar();
        a.setDisplayHomeAsUpEnabled(false);
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
