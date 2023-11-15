package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.model.Job;
import edu.gatech.seclass.jobcompare6300.model.Weight;
import edu.gatech.seclass.jobcompare6300.services.JobService;
import edu.gatech.seclass.jobcompare6300.services.WeightService;

public class EnterJobOffers extends AppCompatActivity {

    private Button cancelReturn;
    private Button saveReturn;
    private Button saveCompare;
    private Button saveAdd;

    private EditText title;
    private EditText company;
    private EditText city;
    private EditText state;
    private EditText costOfLiving;
    private EditText salary;
    private EditText bonus;
    private EditText stock;
    private EditText relocation;
    private EditText holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_offers);

        title = (EditText) findViewById(R.id.Title_EnterJobOffers);
        company = (EditText) findViewById(R.id.Company_EnterJobOffers);
        city = (EditText) findViewById(R.id.City_EnterJobOffers);
        state = (EditText) findViewById(R.id.State_EnterJobOffers);
        costOfLiving = (EditText) findViewById(R.id.CostOfLiving_EnterJobOffers);
        salary = (EditText) findViewById(R.id.YearlySalary_EnterJobOffers);
        bonus = (EditText) findViewById(R.id.YearlyBonus_EnterJobOffers);
        stock = (EditText) findViewById(R.id.Stock_EnterJobOffers);
        relocation = (EditText) findViewById(R.id.Relocation_EnterJobOffers);
        holidays = (EditText) findViewById(R.id.Holidays_EnterJobOffers);

        title.setText("");
        company.setText("");
        city.setText("");
        state.setText("");
        costOfLiving.setText("");
        salary.setText("");
        bonus.setText("");
        stock.setText("");
        holidays.setText("");
    }


    public void handleCancelReturnClick(View view){
        /*
        1. return to main
         */
        Intent intent = new Intent(EnterJobOffers.this, MainActivity.class);
        startActivity(intent);
    }


    public void handleSaveReturnClick(View view){
        // Get Latest Weight
        Weight latestWeight = WeightService.getWeight(getApplicationContext());

        // Get Job Dao
        JobDao jobDao = JobService.getJobDao(getApplicationContext());

        // Check fields are valid
        if(!check()){
            return;
        }

        saveJobOffer(latestWeight, jobDao);
        // Go to next activity
        startActivity(new Intent(EnterJobOffers.this, MainActivity.class));
    }

    public void handleSaveAddClick(View view){
        // Get Latest Weight
        Weight latestWeight = WeightService.getWeight(getApplicationContext());

        // Get Job Dao
        JobDao jobDao = JobService.getJobDao(getApplicationContext());

        // Check fields are valid
        if(!check()){
            return;
        }

        saveJobOffer(latestWeight, jobDao);
        // Go to next activity
        startActivity(new Intent(EnterJobOffers.this, EnterJobOffers.class));
    }

    public void handleSaveCompareClick(View view){
        /*
        1. check data
        2. Save job offers data to DB
        3. check if current job exists
        4. Go to Compare Offers View
         */

        // Get Latest Weight
        Weight latestWeight = WeightService.getWeight(getApplicationContext());

        // Get Job Dao
        JobDao jobDao = JobService.getJobDao(getApplicationContext());

        if(!check()){
            return;
        }

        saveJobOffer(latestWeight, jobDao);
        List<Job> latestJob = jobDao.getLatestJob();
        List<Job> currentJob = jobDao.getCurrentJob();
        startActivity(new Intent(EnterJobOffers.this, CompareTwo.class).putExtra("id1",currentJob.get(0).getJobId()).putExtra("id2", latestJob.get(0).getJobId()));
    }

    private void saveJobOffer(Weight latestWeight, JobDao jobDao) {
        // Build comma delimited address field
        String builtAddress = city.getText().toString() + ','
                + state.getText().toString();

        Job currJob = new Job(0,
                title.getText().toString(),
                company.getText().toString(),
                builtAddress,
                Integer.parseInt(costOfLiving.getText().toString()),
                Integer.parseInt(salary.getText().toString()),
                Integer.parseInt(bonus.getText().toString()),
                Integer.parseInt(stock.getText().toString()),
                Integer.parseInt(relocation.getText().toString()),
                Integer.parseInt(holidays.getText().toString()),
                false, 0);
        // Calc job score and set on job
        currJob.setJobScore(JobService.calcJobScore(currJob, latestWeight));

        jobDao.insertJob(currJob);
    }

    private Boolean check(){
        boolean flag = true;
        String title_input = title.getText().toString();
        String company_input = company.getText().toString();
        String city_input = city.getText().toString();
        String state_input = state.getText().toString();
        String costOfLiving_input = costOfLiving.getText().toString();
        String salary_input = salary.getText().toString();
        String bonus_input = bonus.getText().toString();
        String stock_input = stock.getText().toString();
        String relocation_input = relocation.getText().toString();
        String holidays_input = holidays.getText().toString();

        if (title_input.equals("")){
            title.setError("Invalid Entry Text");
            flag = false;
        }
        if (company_input.equals("")){
            company.setError("Invalid Entry Text");
            flag = false;
        }
        if (city_input.equals("")){
            city.setError("Invalid Entry Text");
            flag = false;
        }
        if (state_input.equals("")){
            state.setError("Invalid Entry Text");
            flag = false;
        }
        if (costOfLiving_input.equals("")){
            costOfLiving.setError("Invalid Entry Text");
            flag = false;
        }
        // check cost of living is not 0
        int costOfLiving_input_int;
        try {
            costOfLiving_input_int = Integer.parseInt(costOfLiving_input);
        }
        catch (NumberFormatException e) {
            costOfLiving_input_int = 0;
        }
        if (costOfLiving_input_int == 0){
            costOfLiving.setError("Invalid Entry Text");
            flag = false;
        }
        if (costOfLiving_input_int < 40){
            costOfLiving.setError("cost Of Living Index 40 - 240");
            flag = false;
        }
        if (costOfLiving_input_int > 240){
            costOfLiving.setError("cost Of Living Index 40 - 240");
            flag = false;
        }
        if (salary_input.equals("")){
            salary.setError("Invalid Entry Text");
            flag = false;
        }
        int salary_input_int;
        try {
            salary_input_int = Integer.parseInt(salary_input);
        }
        catch (NumberFormatException e) {
            salary_input_int = 100000000;
        }
        if (salary_input_int < 0){
            salary.setError("Salary 0 - 10,000,000");
            flag = false;
        }
        if (salary_input_int > 10000000){
            salary.setError("Salary 0 - 10,000,000");
            flag = false;
        }
        if (bonus_input.equals("")){
            bonus.setError("Invalid Entry Text");
            flag = false;
        }
        int bonus_input_int;
        try {
            bonus_input_int = Integer.parseInt(bonus_input);
        }
        catch (NumberFormatException e) {
            bonus_input_int = 100000000;
        }
        if (bonus_input_int < 0){
            bonus.setError("Bonus 0 - 1,000,000");
            flag = false;
        }
        if (bonus_input_int > 1000000){
            bonus.setError("Bonus 0 - 1,000,000");
            flag = false;
        }
        if (stock_input.equals("")){
            stock.setError("Invalid Entry Text");
            flag = false;
        }
        int stock_input_int;
        try {
            stock_input_int = Integer.parseInt(stock_input);
        }
        catch (NumberFormatException e) {
            stock_input_int = 100000000;
        }
        if (stock_input_int < 0){
            stock.setError("Stock 0 - 1,000,000");
            flag = false;
        }
        if (stock_input_int > 1000000){
            stock.setError("Stock 0 - 1,000,000");
            flag = false;
        }
        if (relocation_input.equals("")){
            relocation.setError("Invalid Entry Text");
            flag = false;
        }
        int relocation_input_int;
        try {
            relocation_input_int = Integer.parseInt(relocation_input);
        }
        catch (NumberFormatException e) {
            relocation_input_int = 100000000;
        }
        if (relocation_input_int < 0){
            relocation.setError("Relocation 0 - 1,000,000");
            flag = false;
        }
        if (relocation_input_int > 1000000){
            relocation.setError("Relocation 0 - 1,000,000");
            flag = false;
        }
        if (holidays_input.equals("")){
            holidays.setError("Invalid Entry Text");
            flag = false;
        }
        int holidays_input_int;
        try {
            holidays_input_int = Integer.parseInt(holidays_input);
        }
        catch (NumberFormatException e) {
            holidays_input_int = 366;
        }
        if (holidays_input_int < 0){
            holidays.setError("Holidays 0 - 365");
            flag = false;
        }
        if (holidays_input_int > 365){
            holidays.setError("Holidays 0 - 365");
            flag = false;
        }
        return flag;
    }
}