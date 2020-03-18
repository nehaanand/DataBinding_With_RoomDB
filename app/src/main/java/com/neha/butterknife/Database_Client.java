package com.neha.butterknife;

import android.content.Context;

import androidx.room.Room;

public class Database_Client {                      //for avoiding object creation of Room_Database each
                                                    // and everytime we create a single instance of it in this class
    Context context;
    private static Database_Client mInstance;

    Room_Database room_db_obj;

    private Database_Client(Context context) {
        this.context = context;
        room_db_obj= Room.databaseBuilder(context,Room_Database.class,"Login_Register").build();    //Login_Register is name of database
    }


    public static synchronized Database_Client getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Database_Client(context);
        }
        return mInstance;
    }



    public Room_Database getAppDatabase() {
        return room_db_obj;
    }

}
