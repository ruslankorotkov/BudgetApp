package sky.pro.budgetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.budgetapp.services.BudgetService;
@RequestMapping("/budget")
@RestController
public class BudgetController {
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    private BudgetService budgetService;
   @GetMapping("/daily")
    public double dailyBudget(){
        return budgetService.getDailyBydget();
    }
    @GetMapping("/balance")
    public double balance(){
       return budgetService.getBalance();
    }
}
