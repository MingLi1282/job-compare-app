package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.database.WeightDao;
import edu.gatech.seclass.jobcompare6300.model.Weight;
import edu.gatech.seclass.jobcompare6300.services.WeightService;

public class AdjustSettings extends AppCompatActivity {

    private Button cancelReturn;
    private Button saveReturn;

    private EditText salary;
    private EditText bonus;
    private EditText stock;
    private EditText relocation;
    private EditText holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_settings);

        salary = (EditText) findViewById(R.id.YearlySalary_AdjustSettings);
        bonus = (EditText) findViewById(R.id.YearlyBonus_AdjustSettings);
        stock = (EditText) findViewById(R.id.Stock_AdjustSettings);
        relocation = (EditText) findViewById(R.id.Relocation_AdjustSettings);
        holidays = (EditText) findViewById(R.id.Holidays_AdjustSettings);

        try{
            Weight weight = WeightService.getWeight(getApplicationContext());

            salary.setText(Integer.toString(weight.getSalary()));
            bonus.setText(Integer.toString(weight.getBonus()));
            stock.setText(Integer.toString(weight.getStock()));
            relocation.setText(Integer.toString(weight.getRelocation()));
            holidays.setText(Integer.toString(weight.getHoliday()));
        } catch (SQLiteException e){
            salary.setText("1");
            bonus.setText("1");
            stock.setText("1");
            relocation.setText("1");
            holidays.setText("1");
        }



    }
    public void handleCancelReturnClick(View view){
        Intent intent = new Intent(AdjustSettings.this, MainActivity.class);
        startActivity(intent);
    }

    public void handleSaveReturnClick(View view){
        /*
        1. check data
        2. Save setting data to DB
        3. return to main
         */

        WeightDao weightDao = WeightService.getWeightDao(getApplicationContext());

        if(!check()){
            return;
        }
        Weight userWeight = new Weight(0,
                Integer.parseInt(salary.getText().toString()),
                Integer.parseInt(bonus.getText().toString()),
                Integer.parseInt(stock.getText().toString()),
                Integer.parseInt(relocation.getText().toString()),
                Integer.parseInt(holidays.getText().toString()));
        //userWeight.setSum(userWeight.getSum());
        weightDao.updateWeight(userWeight);
        startActivity(new Intent(AdjustSettings.this, MainActivity.class));
    }

    private Boolean check(){
        boolean flag = true;
        String salary_input = salary.getText().toString();
        String bonus_input = bonus.getText().toString();
        String stock_input = stock.getText().toString();
        String relocation_input = relocation.getText().toString();
        String holidays_input = holidays.getText().toString();

        if (salary_input.equals("")){
            salary.setError("Invalid Entry Text");
            flag = false;
        }
        int salary_input_int;
        try {
            salary_input_int = Integer.parseInt(salary_input);
        }
        catch (NumberFormatException e) {
            salary_input_int = 101;
        }
        if (salary_input_int < 1){
            salary.setError("Salary Weight 1 - 100");
            flag = false;
        }
        if (salary_input_int > 100){
            salary.setError("Salary Weight 1 - 100");
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
            bonus_input_int = 101;
        }
        if (bonus_input_int < 1){
            bonus.setError("Bonus Weight 1 - 100");
            flag = false;
        }
        if (bonus_input_int > 100){
            bonus.setError("Bonus Weight 1 - 100");
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
            stock_input_int = 101;
        }
        if (stock_input_int < 1){
            stock.setError("Stock Weight 1 - 100");
            flag = false;
        }
        if (stock_input_int > 100){
            stock.setError("Stock Weight 1 - 100");
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
            relocation_input_int = 101;
        }
        if (relocation_input_int < 1){
            relocation.setError("Relocation Weight 1 - 100");
            flag = false;
        }
        if (relocation_input_int > 100){
            relocation.setError("Relocation Weight 1 - 100");
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
            holidays_input_int = 101;
        }
        if (holidays_input_int < 1){
            holidays.setError("Holiday Weight 1 - 100");
            flag = false;
        }
        if (holidays_input_int > 100){
            holidays.setError("Holidays Weight 1 - 100");
            flag = false;
        }
        return flag;
    }
}