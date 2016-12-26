package com.tldn1.filteringrecyclerviewusingsearchview;

/**
 * Created by X on 12/26/2016.
 */

public class Model {
    private String title;
    private int image;

    public Model(String title, int image) {
        this.setTitle(title);
        this.setImage(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
