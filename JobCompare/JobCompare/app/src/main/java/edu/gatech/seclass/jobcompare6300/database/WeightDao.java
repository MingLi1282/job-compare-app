package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.model.Weight;

@Dao
public interface WeightDao {

    @Query("SELECT * FROM weight")
    List<Weight> getAll();

    @Insert
    void insertWeight(Weight weight);

    @Update
    void updateWeight(Weight weight);
}
