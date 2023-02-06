package sky.pro.budgetapp.impl;

import org.springframework.stereotype.Service;
import sky.pro.budgetapp.model.Transaction;
import sky.pro.budgetapp.services.BudgetService;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class BudgetServiceImpl implements BudgetService {
    public static final double SALARY = 21_000.0;
    public static final double SAVING = 7_000;
    public static final double DAILY_BUDGET = (SALARY - SAVING)/ LocalDate.now().lengthOfMonth() ;
    public static double balance = 0;
    private static long lastId = 0;
    private Map<Month,Map<Long, Transaction>> transactions = new TreeMap<>();

    @Override
    public double getDailyBydget() {
        return DAILY_BUDGET;
    }

    @Override
    public double getBalanceMonch() {
        return LocalDate.now().getDayOfMonth() * getDailyBydget();
    }

    @Override
    public double getBalanceYear() {
        return LocalDate.now().getDayOfYear() * getDailyBydget();
    }

    @Override
    public double getBalance() {
        return SALARY - SAVING - getAllSpend();
    }

    public void addTransaction(Transaction transaction){
        Map<Long,Transaction> monchTransaction = transactions.getOrDefault(LocalDate.now().getMonth(),new LinkedHashMap<>());
        monchTransaction.put(lastId++,transaction);

    }
    private double getAllSpend(){
        Map<Long,Transaction> monchTransaction = transactions.getOrDefault(LocalDate.now().getMonth(),new LinkedHashMap<>());
        int sum = 0;
        for (Transaction element : monchTransaction.values()){
            sum += element.getSum();
        }
        return sum;
    }

}
