package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.gatech.seclass.jobcompare6300.model.Weight;

@Database(entities = {Weight.class}, version = 1)
public abstract class WeightDatabase extends RoomDatabase {
    public abstract WeightDao weightDao();
}
