package edu.gatech.seclass.jobcompare6300;

import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.JOB_DB_NAME;
import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.WEIGHT_DB_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.database.JobDatabase;
import edu.gatech.seclass.jobcompare6300.database.WeightDatabase;
import edu.gatech.seclass.jobcompare6300.model.Job;
import edu.gatech.seclass.jobcompare6300.model.Weight;
import edu.gatech.seclass.jobcompare6300.services.JobService;

public class MainActivity extends AppCompatActivity {

    private Button enterCurJob;
    private Button enterOffer;
    private Button adjSetting;
    private Button compareoffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeightDatabase weightDb = Room.databaseBuilder(getApplicationContext(),
                WeightDatabase.class, WEIGHT_DB_NAME).allowMainThreadQueries().build();
        JobDatabase jobDB = Room.databaseBuilder(getApplicationContext(),
                JobDatabase.class, JOB_DB_NAME).allowMainThreadQueries().build();

        if(jobDB.jobDao().getAll().isEmpty()) {
            populateDB();
        }


        enterCurJob = (Button) findViewById(R.id.EnterCurJob);
        enterOffer = (Button) findViewById(R.id.EnterOffer);
        adjSetting = (Button) findViewById(R.id.Settings);
        compareoffer = (Button) findViewById(R.id.Compare);

        //To Enter Current Job Detail view
        enterCurJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterCurJob.class);
                startActivity(intent);
            }
        });

        //To Enter Job Offers view
        enterOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterJobOffers.class);
                startActivity(intent);
            }
        });

        //To Enter Setting view
        adjSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdjustSettings.class);
                startActivity(intent);
            }
        });

        compareoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompareOffers.class);
                startActivity(intent);
            }
        });


        //testDB();
    }

    private void populateDB() {
        Weight initialTestWeight = new Weight(0,2, 3, 1, 1, 3);

        // Create fake job1
        Job testjob1 = new Job(0,
                "Software Engineer",
                "Google",
                "Atlanta, GA",
                121,
                110000,
                15000,
                25000,
                5000,
                20,
                true,
                0);
        testjob1.setJobScore(JobService.calcJobScore(testjob1, initialTestWeight));

        // Create fake job2
        Job testjob2 = new Job(0,
                "Software Engineer",
                "Microsoft",
                "Atlanta, GA",
                121,
                90000,
                25000,
                10000,
                2000,
                15,
                false,
                0);
        testjob2.setJobScore(JobService.calcJobScore(testjob2, initialTestWeight));

        // Create fake job3
        Job testjob3 = new Job(0,
                "Software Engineer",
                "Apple",
                "Los Angeles, CA",
                194,
                160000,
                20000,
                15000,
                15000,
                16,
                false,
                0);
        testjob3.setJobScore(JobService.calcJobScore(testjob3, initialTestWeight));

        // Create fake job4
        Job testjob4 = new Job(0,
                "Software Engineer",
                "Netflix",
                "San Francisco, CA",
                204,
                180000,
                25000,
                20000,
                10000,
                25,
                false,
                0);
        testjob4.setJobScore(JobService.calcJobScore(testjob4, initialTestWeight));

        // Create fake job5
        Job testjob5 = new Job(0,
                "Project Manager",
                "Walmart",
                "Kansas City, Missouri",
                145,
                90000,
                10000,
                15000,
                5000,
                15,
                false,
                0);
        testjob5.setJobScore(JobService.calcJobScore(testjob5, initialTestWeight));

        // Create fake job6
        Job testjob6 = new Job(0,
                "Project Manager",
                "Target",
                "Minneapolis, MN",
                156,
                95000,
                10000,
                16000,
                7000,
                15,
                false,
                0);
        testjob6.setJobScore(JobService.calcJobScore(testjob6, initialTestWeight));

        // Create fake job7
        Job testjob7 = new Job(0,
                "Chemist",
                "Big Chemistry Company",
                "Atlanta, GA",
                156,
                95000,
                10000,
                16000,
                7000,
                15,
                false,
                0);
        testjob7.setJobScore(JobService.calcJobScore(testjob7, initialTestWeight));

        // Create fake job8
        Job testjob8 = new Job(0,
                "Chemist",
                "Small Chemistry Company",
                "Orlando, FL",
                155,
                75000,
                7000,
                25000,
                5000,
                25,
                false,
                0);
        testjob8.setJobScore(JobService.calcJobScore(testjob7, initialTestWeight));

        // Create fake job9
        Job testjob9 = new Job(0,
                "QA Engineer",
                "Rakuten",
                "Los Angeles, CA",
                194,
                135000,
                15000,
                15000,
                15000,
                15,
                false,
                0);
        testjob9.setJobScore(JobService.calcJobScore(testjob7, initialTestWeight));

        // Create fake job10
        Job testjob10 = new Job(0,
                "QA Engineer",
                "Disney",
                "Los Angeles, CA",
                194,
                115000,
                8000,
                30000,
                9000,
                25,
                false,
                0);
        testjob10.setJobScore(JobService.calcJobScore(testjob7, initialTestWeight));


        // Create Job DB
        JobDatabase db = Room.databaseBuilder(getApplicationContext(),
                JobDatabase.class, JOB_DB_NAME).allowMainThreadQueries().build();

        WeightDatabase weightDb = Room.databaseBuilder(getApplicationContext(),
                WeightDatabase.class, WEIGHT_DB_NAME).allowMainThreadQueries().build();


        // Prepopulate test jobs
        JobDao jobDao = db.jobDao();
        jobDao.insertJob(testjob1);
        jobDao.insertJob(testjob2);
        jobDao.insertJob(testjob3);
        jobDao.insertJob(testjob4);
        jobDao.insertJob(testjob5);
        jobDao.insertJob(testjob6);
        jobDao.insertJob(testjob7);
        jobDao.insertJob(testjob8);
        jobDao.insertJob(testjob9);
        jobDao.insertJob(testjob10);

        // Prepopulate test weight
        weightDb.weightDao().insertWeight(initialTestWeight);
    }
}