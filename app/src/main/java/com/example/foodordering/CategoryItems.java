package com.example.foodordering;

public class CategoryItems {
    String title;
    int pic;
    int background;

    public CategoryItems(String title, int pic,int background) {
        this.title = title;
        this.pic = pic;
        this.background=background;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
