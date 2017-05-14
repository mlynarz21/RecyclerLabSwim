package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

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
        setData();

        imageViewDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle outBundle1 = new Bundle();
                Bundle outBundle2 = new Bundle();
                outBundle2.putStringArray(getResources().getString(R.string.actorsArr),getArguments().getStringArray(getResources().getString(R.string.actorsArr)));
                outBundle2.putIntArray(getResources().getString(R.string.imgsArr),getArguments().getIntArray(getResources().getString(R.string.imgsArr)));
                outBundle1.putIntArray(getResources().getString(R.string.imgsArr),getArguments().getIntArray(getResources().getString(R.string.imgsArr)));
                ImagesFragment imagesFragment = new ImagesFragment();
                ActorFragment actorFragment = new ActorFragment();
                imagesFragment.setArguments(outBundle1);
                actorFragment.setArguments(outBundle2);
                actorFragment.setArguments(outBundle2);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,imagesFragment);
                fragmentTransaction.add(R.id.fragment_container2,actorFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

        private void setData() {
            Bundle bundle = getArguments();
            titleDesc.setText(bundle.getString(getResources().getString(R.string.title)));
            textDesc.setText(bundle.getString(getResources().getString(R.string.desc)));
            imageViewDesc.setImageDrawable(getResources().getDrawable(bundle.getInt(getResources().getString(R.string.img_txt))));
            ratingBar.setRating(bundle.getFloat(getResources().getString(R.string.rating)));
    }

    public float getRating() {
        return ratingBar.getRating();
    }
}
