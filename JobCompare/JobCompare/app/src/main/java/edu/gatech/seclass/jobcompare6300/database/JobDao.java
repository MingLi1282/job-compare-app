package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Update;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.model.Job;

@Dao
public interface JobDao {
    @Query("SELECT * FROM job")
    List<Job> getAll();

    @Insert
    void insertJob(Job job);

    @Query("SELECT * FROM job WHERE jobId = :id")
    List<Job> getUser(int id);

    @Query("SELECT * FROM job WHERE is_curr_job=1")
    List<Job> getCurrentJob();

    @Query("Select * from job where jobid = (Select MAX(jobid) from job)")
    List<Job> getLatestJob();

    @Query("UPDATE job SET is_curr_job=:currentJob")
    void setAllCurrentJobs(Boolean currentJob);

    @Update
    void updateJob(Job job);

}