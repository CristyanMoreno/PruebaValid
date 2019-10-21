package com.drakeblader.pruebavalid.utils;

import androidx.room.TypeConverter;

import com.drakeblader.pruebavalid.model.Image;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class DataTypeConverter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<Image> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Image>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<Image> someObjects) {
        return gson.toJson(someObjects);
    }
}