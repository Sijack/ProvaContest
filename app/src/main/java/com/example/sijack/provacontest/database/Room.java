package com.example.sijack.provacontest.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Sijack on 20/01/2018.
 */

@Entity
public class Room {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private String profId;
    private int type;
    private int number;

    public Room(){}

    public Room(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static Room[] populateData() {
        return new Room[] {
                new Room(11, 5, 62, 127),
                new Room(11, 132, 146, 94),
                new Room(45,76,76,98)
        };
    }
}
