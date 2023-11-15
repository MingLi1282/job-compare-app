package edu.gatech.seclass.jobcompare6300;

import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.JOB_DB_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.database.JobDatabase;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class CompareTwo extends AppCompatActivity {

    private Button anotherComparison;
    private Button returnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two);
        Intent intent = getIntent();
        int id1 = intent.getIntExtra("id1", -1);
        int id2 = intent.getIntExtra("id2", -1);
        JobDatabase db = Room.databaseBuilder(getApplicationContext(),
                JobDatabase.class, JOB_DB_NAME).allowMainThreadQueries().build();
        JobDao jobDao = db.jobDao();
        List<Job> user1 = jobDao.getUser(id1);
        List<Job> user2 = jobDao.getUser(id2);
        // happy case
        if(!user1.isEmpty() && !user2.isEmpty()){
            Job one = user1.get(0);
            Job two = user2.get(0);
            TextView title1 = (TextView) findViewById(R.id.Title1);
            TextView title2 = (TextView) findViewById(R.id.Title2);
            TextView company1 = (TextView) findViewById(R.id.Company1);
            TextView company2 = (TextView) findViewById(R.id.Company2);
            TextView yearlysalary1 = (TextView) findViewById(R.id.YearlySalary1);
            TextView yearlysalary2 = (TextView) findViewById(R.id.YearlySalary2);
            TextView yearlybonus1 = (TextView) findViewById(R.id.YearlyBonus1);
            TextView yearlybonus2 = (TextView) findViewById(R.id.YearlyBonus2);
            TextView stock1 = (TextView) findViewById(R.id.Stock1);
            TextView stock2 = (TextView) findViewById(R.id.Stock2);
            TextView relocation1 = (TextView) findViewById(R.id.Relocation1);
            TextView relocation2 = (TextView) findViewById(R.id.Relocation2);
            TextView holiday1 = (TextView) findViewById(R.id.Holiday1);
            TextView holiday2 = (TextView) findViewById(R.id.Holiday2);
            TextView location1 = (TextView) findViewById(R.id.Location1);
            TextView location2 = (TextView) findViewById(R.id.Location2);
            TextView jobScore1 = (TextView) findViewById(R.id.JobScore1);
            TextView jobScore2 = (TextView) findViewById(R.id.JobScore2);

            // we need to add job score text view

            title1.setText(one.getTitle());
            title2.setText(two.getTitle());

            company1.setText(one.getCompany());
            company2.setText(two.getCompany());

            yearlysalary1.setText(Integer.toString(one.getSalary()));
            yearlysalary2.setText(Integer.toString(two.getSalary()));

            yearlybonus1.setText(Integer.toString(one.getBonus()));
            yearlybonus2.setText(Integer.toString(two.getBonus()));

            stock1.setText(Integer.toString(one.getStock()));
            stock2.setText(Integer.toString(two.getStock()));

            relocation1.setText(Integer.toString(one.getRelocation()));
            relocation2.setText(Integer.toString(two.getRelocation()));

            holiday1.setText(Integer.toString(one.getHoliday()));
            holiday2.setText(Integer.toString(two.getHoliday()));

            location1.setText(one.getAddress());
            location2.setText(two.getAddress());

            jobScore1.setText(Double.toString(one.getJobScore()));
            jobScore2.setText(Double.toString(two.getJobScore()));

        }
    }
    public void handleReturnClick(View view){
        Intent intent = new Intent(CompareTwo.this, MainActivity.class);
        startActivity(intent);
    }

    public void handleAnotherComparisonClick(View view){
        /*To anther comparison
        1. get the sorted list
        2. return the compare offer view and display
         */
        Intent intent = new Intent(CompareTwo.this, CompareOffers.class);
        startActivity(intent);
    }
}