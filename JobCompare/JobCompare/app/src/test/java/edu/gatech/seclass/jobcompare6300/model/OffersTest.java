package edu.gatech.seclass.jobcompare6300.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OffersTest {

    private Offers myTestOffers;

    @Before
    public void setUp() throws Exception {
        myTestOffers = new Offers();
    }

    @After
    public void tearDown() throws Exception {
        myTestOffers = null;
    }

    @Test
    public void getOffers() {
    }

    @Test
    public void setOffers() {
    }

    @Test
    public void isCurrentJobExists() {
        myTestOffers.setCurrentJobExists(true);
        assertEquals(true, myTestOffers.isCurrentJobExists());
    }

    @Test
    public void setCurrentJobExists() {
        myTestOffers.setCurrentJobExists(false);
        assertEquals(false, myTestOffers.isCurrentJobExists());
    }
}