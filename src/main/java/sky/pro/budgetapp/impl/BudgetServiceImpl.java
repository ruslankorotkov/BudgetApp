package sky.pro.budgetapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.budgetapp.services.BudgetService;

import java.time.LocalDate;
@Service
public class BudgetServiceImpl implements BudgetService {
    public static final double SALARY = 21_000.0;
    @Override
    public double getDailyBydget() {
        return SALARY / 31;
    }

    @Override
    public double getBalance() {
        return SALARY -LocalDate.now().getDayOfMonth() * getDailyBydget();
    }
}
