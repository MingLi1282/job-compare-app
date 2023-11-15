package edu.gatech.seclass.jobcompare6300.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Weight {

    @PrimaryKey()
    private int weightId;

    @ColumnInfo(name = "salary_weight")
    private int salary = 1;

    @ColumnInfo(name = "bonus_weight")
    private int bonus = 1;

    @ColumnInfo(name = "stock_weight")
    private int stock = 1;

    @ColumnInfo(name = "relocation_weight")
    private int relocation = 1;

    @ColumnInfo(name = "holiday_weight")
    private int holiday = 1;

    @ColumnInfo(name = "sum_weight")
    private int sum = calcSum();

    public Weight(int weightId, int salary, int bonus, int stock, int relocation, int holiday) {
        this.weightId = weightId;
        this.salary = salary;
        this.bonus = bonus;
        this.stock = stock;
        this.relocation = relocation;
        this.holiday = holiday;
        this.sum = calcSum();
    }

    public Weight() {}

    private int calcSum() {
        return this.salary + this.bonus + this.stock + this.relocation + this.holiday;
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getWeightId() {
        return weightId;
    }

    public void setWeightId(int weightId) {
        this.weightId = weightId;
    }
}
