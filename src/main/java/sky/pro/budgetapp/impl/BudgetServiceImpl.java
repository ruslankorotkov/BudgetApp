package sky.pro.budgetapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.budgetapp.services.BudgetService;

import java.time.LocalDate;

@Service
public class BudgetServiceImpl implements BudgetService {
    public static final double SALARY = 21_000.0;

    @Override
    public double getDailyBydget() {
        return SALARY / LocalDate.now().lengthOfMonth();
    }

    @Override
    public double getBalanceMonch() {
        return LocalDate.now().getDayOfMonth() * getDailyBydget();
    }

    @Override
    public double getBalanceYear() {
        return LocalDate.now().getDayOfYear() * getDailyBydget();
    }
}
