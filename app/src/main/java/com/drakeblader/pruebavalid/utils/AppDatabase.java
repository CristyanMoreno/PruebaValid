package com.drakeblader.pruebavalid.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.drakeblader.pruebavalid.dao.ArtistDAO;
import com.drakeblader.pruebavalid.dao.TrackDAO;
import com.drakeblader.pruebavalid.model.Artist;
import com.drakeblader.pruebavalid.model.Track;

@Database(entities = {Artist.class, Track.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArtistDAO artistDAO();
    public abstract TrackDAO trackDAO();
}