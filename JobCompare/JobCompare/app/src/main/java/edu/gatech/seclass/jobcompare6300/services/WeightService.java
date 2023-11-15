package edu.gatech.seclass.jobcompare6300.services;

import static edu.gatech.seclass.jobcompare6300.utility.ConstantsUtility.WEIGHT_DB_NAME;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.WeightDao;
import edu.gatech.seclass.jobcompare6300.database.WeightDatabase;
import edu.gatech.seclass.jobcompare6300.model.Weight;

public class WeightService {

    public static Weight getWeight(Context appContext) {
        WeightDao weightDao = getWeightDao(appContext);

        // TODO: TEST LATEST WEIGHT IS BEING GOT
        List<Weight> weightList = weightDao.getAll();

        if (weightList.isEmpty()) {
            return new Weight();
        }
        return weightList.get(weightList.size() - 1);
    }

    public static WeightDao getWeightDao(Context appContext) {
        // Load DBs and Get Latest Saved Weight
        WeightDatabase weightDb = Room.databaseBuilder(appContext,
                WeightDatabase.class, WEIGHT_DB_NAME).allowMainThreadQueries().build();

        return weightDb.weightDao();
    }
}
