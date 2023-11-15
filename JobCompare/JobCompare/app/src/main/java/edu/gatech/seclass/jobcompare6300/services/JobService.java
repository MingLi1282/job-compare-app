package edu.gatech.seclass.jobcompare6300.services;

import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.JOB_DB_NAME;

import android.content.Context;

import androidx.room.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.database.JobDatabase;
import edu.gatech.seclass.jobcompare6300.model.Job;
import edu.gatech.seclass.jobcompare6300.model.Weight;

public class JobService {

    public static double calcJobScore(Job job, Weight weights){
        /*
        First we must adjust to cost of living.
        Here I've scaled everything using this formula:
        adjustedMetric = metric / cost of living index
        e.g. salary, $100,000 in high col (10) vs low col(1)
        high col = 100,000 / 10
        low col = 100,000/ 1
         */

        //Prof Orso Salary Formula: AYS = YS * 100 / INDEX
        double adjustedYearlySalary = (job.getSalary() * 100) / (double) job.getCostLiving();
        double adjustedYearlyBonus = (job.getBonus() * 100) / (double) job.getCostLiving();

        // 2/7 * AYS + 1/7 * AYB + 1/7 * (RSUA / 4) + 2/7 * RELO + 1/7 * (PCH * AYS / 260)


        // Convert values to double
        double sumWeightDouble = weights.getSum();
        double salaryWeightDouble = weights.getSalary();
        double salaryBonusWeightDouble = weights.getBonus();
        double stockWeightBonus = weights.getStock();
        double stockJobDouble = job.getStock();
        double holidayWeightDouble = weights.getHoliday();
        double holidayJobDouble = job.getHoliday();
        double relocationWeight = weights.getRelocation();
        double jobRelocation = job.getRelocation();

        // Calculate Job Score
        double dataToNormalize = (((salaryWeightDouble / sumWeightDouble) * adjustedYearlySalary) + //Weighted salary
                ((salaryBonusWeightDouble / sumWeightDouble) * adjustedYearlyBonus) + // Weighted Bonus
                ((stockWeightBonus / sumWeightDouble) * (stockJobDouble / 4)) + // Weighted stock
                ((relocationWeight / sumWeightDouble) * jobRelocation) + // Weighted relocation
                ((holidayWeightDouble / sumWeightDouble) * ((holidayJobDouble * adjustedYearlySalary) / 260.0)));

        // Normalized data to 100000 and round to 2 places
        double normalizedData = ((dataToNormalize - 0 ) / (2336538.4615384616 - 0)) * 100000;
        BigDecimal scoreRound = new BigDecimal(normalizedData).setScale(2, RoundingMode.HALF_UP);
        double roundedScore = scoreRound.doubleValue();

        return roundedScore;
    }

    public static JobDao getJobDao(Context context) {
        JobDatabase db = Room.databaseBuilder(context,
                JobDatabase.class, JOB_DB_NAME).allowMainThreadQueries().build();
        return db.jobDao();
    }
}
