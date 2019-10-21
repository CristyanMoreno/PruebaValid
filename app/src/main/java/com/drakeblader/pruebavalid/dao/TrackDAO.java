package com.drakeblader.pruebavalid.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.drakeblader.pruebavalid.model.Track;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TrackDAO {

    @Query("SELECT * FROM track")
    List<Track> getAll();

    @Insert(onConflict = REPLACE)
    void insertAll(ArrayList<Track> tracks);
}
