package edu.gatech.seclass.jobcompare6300.model;

import java.util.List;

public class Offers {
    private List<Job> offers;
    private boolean currentJobExists;

    public List<Job> getOffers() {
        return offers;
    }

    public void setOffers(List<Job> offers) {
        this.offers = offers;
    }

    public boolean isCurrentJobExists() {
        return currentJobExists;
    }

    public void setCurrentJobExists(boolean currentJobExists) {
        this.currentJobExists = currentJobExists;
    }
}
