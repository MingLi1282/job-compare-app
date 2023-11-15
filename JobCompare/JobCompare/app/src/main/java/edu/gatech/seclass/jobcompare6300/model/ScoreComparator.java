package edu.gatech.seclass.jobcompare6300.model;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Job> {
    @Override
    public int compare(Job a, Job b) {
        return a.getJobScore() < b.getJobScore() ? -1 : a.getJobScore() == b.getJobScore() ? 0 : 1;
    }
}
