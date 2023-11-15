package edu.gatech.seclass.jobcompare6300.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobTest {

    private Job myTestJob;

    private Weight myTestWeight;

    @Before
    public void setUp() throws Exception {
        myTestJob = new Job();
        myTestWeight = new Weight();
    }

    @After
    public void tearDown() throws Exception {
        myTestJob = null;
        myTestWeight = null;
    }

    @Test
    public void getSetTitle() {
        myTestJob.setTitle("ThisIsATest");
        assertEquals("ThisIsATest", myTestJob.getTitle());
    }

    @Test
    public void getSetCompany() {
        myTestJob.setCompany("ThisIsATest");
        assertEquals("ThisIsATest", myTestJob.getCompany());
    }

    @Test
    public void getSetAddress() {
        myTestJob.setAddress("ThisIsATest");
        assertEquals("ThisIsATest", myTestJob.getAddress());
    }

    @Test
    public void getSetCostLiving() {
        myTestJob.setCostLiving(25);
        assertEquals(25, myTestJob.getCostLiving());
    }

    @Test
    public void getSetSalary() {
        myTestJob.setSalary(25000);
        assertEquals(25000, myTestJob.getSalary());
    }

    @Test
    public void getSetBonus() {
        myTestJob.setBonus(25000);
        assertEquals(25000, myTestJob.getBonus());
    }

    @Test
    public void getSetStock() {
        myTestJob.setStock(25);
        assertEquals(25, myTestJob.getStock());
    }

    @Test
    public void getSetRelocation() {
        myTestJob.setRelocation(1);
        assertEquals(1, myTestJob.getRelocation());
    }

    @Test
    public void getSetHoliday() {
        myTestJob.setHoliday(1);
        assertEquals(1, myTestJob.getHoliday());
    }

    @Test
    public void getSetCurJob() {
        myTestJob.setCurJob(true);
        assertEquals(true, myTestJob.getCurJob());
    }

    @Test
    public void getSetJobScore() {
        myTestJob.setJobScore(1.1);
        assertEquals(1.1, myTestJob.getJobScore(), 0);
    }

    @Test
    public void getSetJobId() {
        myTestJob.setJobId(7);
        assertEquals(7, myTestJob.getJobId());
    }

    @Test
    public void testGetJobScore() {
        //assertEquals(27.0, myTestJob.getJobScoreWeight(myTestWeight));
    }
}