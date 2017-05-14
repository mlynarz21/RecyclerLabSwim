package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mlyna on 13.05.2017.
 */

public class ActorFragment extends Fragment {

    ImageView actorImg1;
    ImageView actorImg2;
    ImageView actorImg3;
    TextView actorTxt1;
    TextView actorTxt2;
    TextView actorTxt3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actor_fragment_layout, container, false);
        actorImg1 = (ImageView) view.findViewById(R.id.actor_image1);
        actorImg2 = (ImageView) view.findViewById(R.id.actor_image2);
        actorImg3 = (ImageView) view.findViewById(R.id.actor_image3);
        actorTxt1 = (TextView) view.findViewById(R.id.actor_textView1);
        actorTxt2 = (TextView) view.findViewById(R.id.actor_textView2);
        actorTxt3 = (TextView) view.findViewById(R.id.actor_textView3);
        setActors();
        return view;
    }

    private void setActors() {
        int images[] = getArguments().getIntArray(getResources().getString(R.string.imgsArr));
        String actors[] = getArguments().getStringArray(getResources().getString(R.string.actorsArr));
        actorImg1.setImageDrawable(getResources().getDrawable(images[6]));
        actorImg2.setImageDrawable(getResources().getDrawable(images[7]));
        actorImg3.setImageDrawable(getResources().getDrawable(images[8]));
        actorTxt1.setText(actors[0]);
        actorTxt2.setText(actors[1]);
        actorTxt3.setText(actors[2]);

    }
}
