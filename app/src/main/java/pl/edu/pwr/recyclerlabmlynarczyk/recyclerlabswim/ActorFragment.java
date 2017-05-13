package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mlyna on 13.05.2017.
 */

public class ActorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_fragment_layout, container, false);
        return view;
    }
}
