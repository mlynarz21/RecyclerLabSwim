package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

/**
 * Created by mlyna on 09.04.2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Movie> moviesList;
    private Context context;

    public void removeItem(int pos){
        moviesList.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos,moviesList.size());
    }

    public class MyViewHolderLeft extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView title, year, genre;
        public ImageView eyeImage, filmImg;

        public MyViewHolderLeft(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            filmImg = (ImageView) view.findViewById(R.id.imageview_film_left);
            eyeImage = (ImageView) view.findViewById(R.id.eye_image);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View v){
            Intent it = new Intent(context, MovieActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            it.putExtra(context.getString(R.string.title),title.getText().toString());
            it.putExtra(context.getString(R.string.genre),genre.getText().toString());
            it.putExtra(context.getString(R.string.year),year.getText().toString());
            it.putExtra(context.getString(R.string.img_txt),Integer.parseInt(filmImg.getTag().toString()));
            it.putExtra(context.getString(R.string.rating),moviesList.get(getAdapterPosition()).getRating());
            context.startActivity(it);
        }
        @Override
        public boolean onLongClick(View v){
            if (eyeImage.getVisibility()==View.GONE) {
                eyeImage.setVisibility(View.VISIBLE);
                moviesList.get(getAdapterPosition()).setMark(true);
            }
            else {
                eyeImage.setVisibility(View.GONE);
                moviesList.get(getAdapterPosition()).setMark(false);
            }
            return true;
        }
    }

    public class MyViewHolderRight extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView title, year, genre;
        public ImageView eyeImage, filmImg;

        public MyViewHolderRight(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title2);
            genre = (TextView) view.findViewById(R.id.genre2);
            year = (TextView) view.findViewById(R.id.year2);
            filmImg = (ImageView) view.findViewById(R.id.imageview_film_right);
            eyeImage = (ImageView) view.findViewById(R.id.eye_image);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v){
            Intent it = new Intent(context, MovieActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            it.putExtra(context.getString(R.string.title),title.getText().toString());
            it.putExtra(context.getString(R.string.genre),genre.getText().toString());
            it.putExtra(context.getString(R.string.year),year.getText().toString());
            it.putExtra(context.getString(R.string.img_txt),Integer.parseInt(filmImg.getTag().toString()));
            it.putExtra(context.getString(R.string.rating),moviesList.get(getAdapterPosition()).getRating());
            ((Activity) context).startActivityForResult(it,1);
        }
        @Override
        public boolean onLongClick(View v){
            if (eyeImage.getVisibility()==View.GONE) {
                eyeImage.setVisibility(View.VISIBLE);
                moviesList.get(getAdapterPosition()).setMark(true);
            }
            else {
                eyeImage.setVisibility(View.GONE);
                moviesList.get(getAdapterPosition()).setMark(false);
            }
            return true;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }


    public MoviesAdapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row, parent, false);
                return new MyViewHolderLeft(itemView);
            }
            case 1: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row_right, parent, false);
                return new MyViewHolderRight(itemView);
            }
            default: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row, parent, false);
                return new MyViewHolderLeft(itemView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setItemRating(int position,float rating){
        moviesList.get(position).rating = rating;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        Movie movie = moviesList.get(position);
        switch (holder.getItemViewType()) {
            case 0: {
                MyViewHolderLeft viewHolder = (MyViewHolderLeft) holder;
                viewHolder.title.setText(movie.getTitle());
                viewHolder.genre.setText(movie.getGenre());
                viewHolder.year.setText(movie.getYear());
                viewHolder.filmImg.setImageDrawable(context.getDrawable(movie.getImageId()));
                viewHolder.filmImg.setTag(movie.getImageId());
            }
            break;

            case 1: {
                MyViewHolderRight viewHolder = (MyViewHolderRight) holder;
                viewHolder.title.setText(movie.getTitle());
                viewHolder.genre.setText(movie.getGenre());
                viewHolder.year.setText(movie.getYear());
                viewHolder.filmImg.setImageDrawable(context.getDrawable(movie.getImageId()));
                viewHolder.filmImg.setTag(movie.getImageId());
            }
            break;
        }
    }
}
