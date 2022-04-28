package com.example.a3hw4;

public class UniversModel {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public UniversModel(String name, int image) {
        this.name = name;
        this.image = image;
    }
}
