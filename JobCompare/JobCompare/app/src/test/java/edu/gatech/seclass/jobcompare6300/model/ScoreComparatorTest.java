package edu.gatech.seclass.jobcompare6300.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreComparatorTest {

    private Job myTestJobA;

    private Job myTestJobC;

    private ScoreComparator myTestScore;

    @Before
    public void setUp() throws Exception {
        myTestJobA = new Job();
        myTestJobC = new Job();
        myTestScore = new ScoreComparator();
    }

    @After
    public void tearDown() throws Exception {
        myTestJobA = null;
        myTestJobC = null;
        myTestScore = null;
    }

    @Test
    public void compare() {
        myTestJobA.setJobScore(27);
        myTestJobC.setJobScore(3);
        assertEquals(1, myTestScore.compare( myTestJobA, myTestJobC));
    }
}