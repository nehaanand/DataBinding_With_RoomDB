package com.neha.butterknife.data_access_object;

import androidx.room.Dao;

@Dao
public interface Login_Register_DAO {

    @Query("SELECT * FROM Login_Register_Entity")
    List<Login_Register_Entity> getAll();

    @Insert
    void insert(Login_Register_Entity entity);

    @Delete
    void delete(Login_Register_Entity entity);

    @Update
    void update(Login_Register_Entity entity);

}
