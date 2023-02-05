package sky.pro.budgetapp.impl;

import sky.pro.budgetapp.services.BudgetService;

import java.time.LocalDate;

public class BudgetServiceImpl implements BudgetService {
    public static final double SALARY = 21_000;
    @Override
    public double getDailyBydget() {
        return SALARY / 31;
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
