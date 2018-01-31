package com.example.sijack.provacontest.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Sijack on 25/01/2018.
 */

@Dao
public interface RoomDao {

    @Insert
    void insertAll(Room... rooms);

    @Query("SELECT * FROM Room")
    List<Room> getAll();
}
