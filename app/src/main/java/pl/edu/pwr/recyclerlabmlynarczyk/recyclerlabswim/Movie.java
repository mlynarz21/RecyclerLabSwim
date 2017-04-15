package pl.edu.pwr.recyclerlabmlynarczyk.recyclerlabswim;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mlyna on 09.04.2017.
 */

public class Movie{
    private String title, genre, year;
    private Drawable image;
    private int imageId;
    float rating;
    boolean mark;

    public Movie() {
    }

    public Movie(String title, String genre, String year, int imageId) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.imageId = imageId;
        rating=0;
        mark=false;
    }

//    private Creator(Parcel in){
//        this()
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(title);
//        dest.writeString(genre);
//        dest.writeString(year);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
}