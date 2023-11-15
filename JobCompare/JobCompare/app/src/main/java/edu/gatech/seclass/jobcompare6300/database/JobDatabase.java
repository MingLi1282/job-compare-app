package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.gatech.seclass.jobcompare6300.model.Job;

@Database(entities = {Job.class}, version = 1)
public abstract class JobDatabase extends RoomDatabase {
    public abstract JobDao jobDao();
}
