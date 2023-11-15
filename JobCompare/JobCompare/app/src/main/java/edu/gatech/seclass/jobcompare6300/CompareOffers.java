package edu.gatech.seclass.jobcompare6300;

import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.JOB_DB_NAME;
import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.WEIGHT_DB_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.database.JobDatabase;
import edu.gatech.seclass.jobcompare6300.database.WeightDao;
import edu.gatech.seclass.jobcompare6300.database.WeightDatabase;
import edu.gatech.seclass.jobcompare6300.model.Job;
import edu.gatech.seclass.jobcompare6300.model.ScoreComparator;
import edu.gatech.seclass.jobcompare6300.model.Weight;
import edu.gatech.seclass.jobcompare6300.services.JobService;

public class CompareOffers extends AppCompatActivity {

    private Button mainReturn;
    private Button compareTwo;

    private RecyclerView recyclerView;
    private int itemCount;
    private TextView jobID_1;
    private TextView jobID_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_offers);

        jobID_1 = (TextView) findViewById(R.id.JobID_1_CompareOffers);
        jobID_2 = (TextView) findViewById(R.id.JobID_2_CompareOffers);
        jobID_1.setText("0");
        jobID_2.setText("0");

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_CompareOffers);

        // Show jobs
//        TextView jobListing = (TextView) findViewById(R.id.jobList);
        JobDatabase jobDb = Room.databaseBuilder(getApplicationContext(),
                JobDatabase.class, JOB_DB_NAME).allowMainThreadQueries().build();

        // Get Weight and Calculate
        WeightDatabase weightDb = Room.databaseBuilder(getApplicationContext(),
                WeightDatabase.class, WEIGHT_DB_NAME).allowMainThreadQueries().build();

        JobDao jobDao = jobDb.jobDao();
        List<Job> jobs = jobDao.getAll();

        // Get current weight
        WeightDao weightDao = weightDb.weightDao();
        Weight weight = weightDao.getAll().get(0);

        jobs.forEach(job -> job.setJobScore(JobService.calcJobScore(job, weight)));

        jobs.sort(new ScoreComparator());
        Collections.reverse(jobs);
//        for(Job j: jobs){
//            jobListing.append(j.toString() + "\n\n");
//        }
        CompareOffersAdaptor compareOffersAdaptor = new CompareOffersAdaptor(CompareOffers.this,jobs);
        recyclerView.setAdapter(compareOffersAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(CompareOffers.this));
        itemCount = compareOffersAdaptor.getItemCount();
    }


    public void handleCancelReturnClick(View view){
        Intent intent = new Intent(CompareOffers.this, MainActivity.class);
        startActivity(intent);
    }


    public void handleCompareTwoClick(View view){
        /*
        1. check if two job offer were selected
        2. get two job offers details
        3. pass two job offers details. trigger to CompareTwo view
         */
        if(!check()){
            return;
        }
        startActivity(new Intent(CompareOffers.this, CompareTwo.class).putExtra("id1", Integer.parseInt(jobID_1.getText().toString())).putExtra("id2", Integer.parseInt(jobID_2.getText().toString())));
    }

    private Boolean check() {
        boolean flag = true;
        String jobID_1_input = jobID_1.getText().toString();
        String jobID_2_input = jobID_2.getText().toString();

        if (jobID_1_input.equals("")){
            jobID_1.setError("Invalid Entry Text");
            flag = false;
        }
        if (jobID_2_input.equals("")){
            jobID_2.setError("Invalid Entry Text");
            flag = false;
        }
        // check job ID_1 in range
        int jobID_1_input_int;
        try {
            jobID_1_input_int = Integer.parseInt(jobID_1_input);
        }
        catch (NumberFormatException e) {
            jobID_1_input_int = 0;
        }
        if (jobID_1_input_int < 1){
            jobID_1.setError("Job ID not in range");
            flag = false;
        }
        if (jobID_1_input_int > itemCount){
            jobID_1.setError("Job ID not in range");
            flag = false;
        }
        // check job ID_2 in range
        int jobID_2_input_int;
        try {
            jobID_2_input_int = Integer.parseInt(jobID_2_input);
        }
        catch (NumberFormatException e) {
            jobID_2_input_int = 0;
        }
        if (jobID_2_input_int < 1){
            jobID_2.setError("Job ID not in range");
            flag = false;
        }
        if (jobID_2_input_int > itemCount){
            jobID_2.setError("Job ID not in range");
            flag = false;
        }
        // check if same id entered
        if (jobID_2_input_int == jobID_1_input_int){
            jobID_1.setError("Same Job IDs");
            jobID_2.setError("Same Job IDs");
            flag = false;
        }
        return flag;
    }
}