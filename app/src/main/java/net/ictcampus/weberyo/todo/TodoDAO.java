package net.ictcampus.weberyo.todo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface TodoDAO {

    //Querys

    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Query("SELECT * FROM todo WHERE date = :date")
    List<Todo> getTodoByDay(String date);

    @Query("SELECT * FROM todo WHERE date = :date AND title = :title ORDER BY title DESC LIMIT 1")
    Todo getToDoByTitle(String date, String title);

    @Query("SELECT * FROM todo WHERE STRFTIME('%j', date(date, '-3 days', 'weekday 4')) - 1 / 7 + 1 = STRFTIME('%j', date(:date, '-3 days', 'weekday 4')) - 1 / 7 + 1")
    List<Todo> getTodoByWeek(String date);

    @Query("SELECT * FROM todo WHERE STRFTIME('%m', date) = STRFTIME('%m', :date)")
    List<Todo> getTodoByMonth(String date);


    //Inserts

    @Insert
    void insertTodo(Todo... todos);

    //Deletes

    @Delete
    void deleteTodo(Todo todo);



}
