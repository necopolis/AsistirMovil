package com.avaca.asistirandroid.modelo;

import com.google.gson.annotations.SerializedName;

public class MyDataModel {
    /*@SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }

    public MyDataModel(String data) {
        this.data = data;
    }
    public MyDataModel() {
    }*/

    private String id;
    private String name;
    private String height;
    private String weigth;
    private Sprites sprites = new Sprites();

    private String front_default=sprites.getFront_default();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}
