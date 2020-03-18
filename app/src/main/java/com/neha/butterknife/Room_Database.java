package com.neha.butterknife;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.neha.butterknife.data_access_object.Login_Register_DAO;
import com.neha.butterknife.entity.Login_Register_Entity;

@Database(entities = {Login_Register_Entity.class},version = 1,exportSchema = false)
public abstract class Room_Database extends RoomDatabase {                             //in this class we define all the entities
                                                                                    // and database version
    public abstract Login_Register_DAO dao_obj();

}
