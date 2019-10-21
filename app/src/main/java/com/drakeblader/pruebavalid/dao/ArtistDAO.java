package com.drakeblader.pruebavalid.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.drakeblader.pruebavalid.model.Artist;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ArtistDAO {

    @Query("SELECT * FROM artist")
    List<Artist> getAll();

    @Insert(onConflict = REPLACE)
    void insertAll(ArrayList<Artist> artists);
}
