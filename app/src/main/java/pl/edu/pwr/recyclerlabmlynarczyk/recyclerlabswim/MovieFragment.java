package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by mlyna on 13.05.2017.
 */

public class MovieFragment extends Fragment {
    RatingBar ratingBar;
    TextView textDesc;
    ImageView imageViewDesc;
    TextView titleDesc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment_layout, container, false);
        ratingBar= (RatingBar) view.findViewById(R.id.rating_bar);
        textDesc= (TextView) view.findViewById(R.id.textview_desc);
        imageViewDesc= (ImageView) view.findViewById(R.id.image_view_desc);
        titleDesc= (TextView) view.findViewById(R.id.title_desc);
        return view;
    }

    public RatingBar getRatingbar() {
        return ratingBar;
    }

    public TextView getTextDesc() {
        return textDesc;
    }

    public ImageView geImageViewDesc() {
        return imageViewDesc;
    }

    public TextView getTitleDesc() {
        return titleDesc;
    }
}
