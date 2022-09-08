package com.example.devapp.BucketList.Model;

import androidx.annotation.DrawableRes;

public class BucketListEntry {

    private String title;
    private String description;
    private int image;
    private float rating;

    public BucketListEntry(String title, String description, @DrawableRes int image, float rating) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
