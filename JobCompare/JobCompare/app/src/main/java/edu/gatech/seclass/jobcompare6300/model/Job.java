package edu.gatech.seclass.jobcompare6300.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Comparator;
import java.util.Objects;


@Entity
public class Job {
    @PrimaryKey(autoGenerate = true)
    private int jobId;
    @ColumnInfo(name = "job_title")
    private String title;
    @ColumnInfo(name = "job_company")
    private String company;
    @ColumnInfo(name = "job_address")
    private String address;
    @ColumnInfo(name = "cost_living")
    private int costLiving;
    @ColumnInfo(name = "job_salary")
    private int salary;
    @ColumnInfo(name = "job_bonus")
    private int bonus;
    @ColumnInfo(name = "job_stock")
    private int stock;
    @ColumnInfo(name = "job_relocation")
    private int relocation;
    @ColumnInfo(name = "job_holiday")
    private int holiday;
    @ColumnInfo(name = "is_curr_job")
    private boolean curJob;
    @ColumnInfo(name = "job_score")
    private double jobScore;

    public Job(Integer jobId, String title, String company, String address, int costLiving, int salary, int bonus, int stock, int relocation, int holiday, boolean curJob, double jobScore) {
        super();
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.address = address;
        this.costLiving = costLiving;
        this.salary = salary;
        this.bonus = bonus;
        this.stock = stock;
        this.relocation = relocation;
        this.holiday = holiday;
        this.curJob = curJob;
        this.jobScore = jobScore;
    }

    /**
     * Default Constructor
     */
    public Job() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCostLiving() {
        return costLiving;
    }

    public void setCostLiving(int costLiving) {
        this.costLiving = costLiving;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRelocation() {
        return relocation;
    }

    public void setRelocation(int relocation) {
        this.relocation = relocation;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public boolean getCurJob() {
        return curJob;
    }

    public void setCurJob(boolean curJob) {
        this.curJob = curJob;
    }

    public double getJobScore() {
        return jobScore;
    }

    public void setJobScore(double jobScore) {
        this.jobScore = jobScore;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", costLiving=" + costLiving +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", stock=" + stock +
                ", relocation=" + relocation +
                ", holiday=" + holiday +
                ", curJob=" + curJob +
                ", jobScore=" + jobScore +
                '}';
    }

}

