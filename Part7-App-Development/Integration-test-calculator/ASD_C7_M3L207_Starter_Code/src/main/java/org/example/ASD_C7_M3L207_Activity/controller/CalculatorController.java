package org.example.ASD_C7_M3L207_Activity.controller;

import org.example.ASD_C7_M3L207_Activity.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    // Setter method for manual injection during testing
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {
        return calculatorService.calculate(num1, num2, operation);
    }
}
