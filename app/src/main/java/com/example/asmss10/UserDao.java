package com.example.asmss10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserEntity userEntity);
    @Update
    void updateUser(UserEntity userEntity);
    @Delete
    void deleteUser(UserEntity userEntity);
    @Query("select*from users ")
    List<UserEntity> getUser();
    @Query("select*from users where id=:id")
    UserEntity findById(int id);
    @Query("select*from users where name=:name")
    UserEntity findByName(String name);

}
