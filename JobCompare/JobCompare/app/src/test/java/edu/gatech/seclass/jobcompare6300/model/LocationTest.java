package edu.gatech.seclass.jobcompare6300.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {

    private Location myTestLocation;

    @Before
    public void setUp() throws Exception {
        myTestLocation = new Location();
    }

    @After
    public void tearDown() throws Exception {
        myTestLocation = null;
    }

    @Test
    public void getSetCity() {
        myTestLocation.setCity("testCity");
        assertEquals("testCity", myTestLocation.getCity());
    }

    @Test
    public void getSetState() {
        myTestLocation.setState("testCity");
        assertEquals("testCity", myTestLocation.getState());
    }

}