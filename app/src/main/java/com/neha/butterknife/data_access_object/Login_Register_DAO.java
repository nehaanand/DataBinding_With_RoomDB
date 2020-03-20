package com.neha.butterknife.data_access_object;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.neha.butterknife.entity.Login_Register_Entity;

import java.util.List;

@Dao
public interface Login_Register_DAO {

    @Query("SELECT * FROM Login_Register_Entity")
    List<Login_Register_Entity> getAll();


    @Query("SELECT * FROM Login_Register_Entity WHERE Email= :email AND Password= :password")
    List<Login_Register_Entity> check_if_user_exists(String email, String password);

    @Insert
    void insert(Login_Register_Entity entity);

    @Delete
    void delete(Login_Register_Entity entity);

    @Update
    void update(Login_Register_Entity entity);

}
