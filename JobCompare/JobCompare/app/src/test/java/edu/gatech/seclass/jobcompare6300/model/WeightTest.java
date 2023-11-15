package edu.gatech.seclass.jobcompare6300.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeightTest {

    private Weight myTestWeight;

    @Before
    public void setUp() throws Exception {
        myTestWeight = new Weight();
    }

    @After
    public void tearDown() throws Exception {
        myTestWeight = null;
    }

    @Test
    public void getSetSalary() {
        myTestWeight.setSalary(25);
        assertEquals(25, myTestWeight.getSalary());
    }

    @Test
    public void getSetBonus() {
        myTestWeight.setBonus(25);
        assertEquals(25, myTestWeight.getBonus());
    }

    @Test
    public void getSetStock() {
        myTestWeight.setStock(25);
        assertEquals(25, myTestWeight.getStock());
    }

    @Test
    public void getRelocation() {
        myTestWeight.setRelocation(25);
        assertEquals(25, myTestWeight.getRelocation());
    }

    @Test
    public void getHoliday() {
        myTestWeight.setHoliday(25);
        assertEquals(25, myTestWeight.getHoliday());
    }

    @Test
    public void getSum() {
        assertEquals(5, myTestWeight.getSum());
    }

    @Test
    public void setSum() {
        myTestWeight.setSum(10);
        assertEquals(10, myTestWeight.getSum());
    }

    @Test
    public void getSetWeightId() {
        myTestWeight.setWeightId(5);
        assertEquals(5, myTestWeight.getWeightId());
    }
}