package ru.sky.Test.HW2._2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sky.Test.HW2._2.exception.ZeroDivideException;
import ru.sky.Test.HW2._2.service.CalculatorServiceImpl;

@RestController
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "/calculator")
    public String hello() {
        return calculatorService.hello();
    }

    @GetMapping(path = "/plus")
    public String plusNumbers(@RequestParam(required = false) Integer num1, @RequestParam Integer num2) {
        if (num1 == null) {
            return "Параметр не передан";
        } else if (num2 == null) {
            return "Параметр не передан";
        }
        int result = calculatorService.plus(num1, num2);
        return message(num1, num2, '+', result);
    }

    @GetMapping(path = "/minus")
    public String minusNumbers(@RequestParam(required = false) Integer num1, @RequestParam Integer num2) {
        if (num1 == null) {
            return "Параметр num1 не передан";
        } else if (num2 == null) {
            return "Параметр num2 не передан";
        }
        int result = calculatorService.minus(num1, num2);
        return message(num1, num2, '-', result);
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam(required = false) Integer num1, @RequestParam Integer num2) {
        if (num1 == null) {
            return "Параметр num1 не передан";
        } else if (num2 == null) {
            return "Параметр num2 не передан";
        }
        int result = calculatorService.multiply(num1, num2);
        return message(num1, num2, '*', result);
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam Integer num1, @RequestParam Integer num2) throws ZeroDivideException {
        if (num1 == null) {
            return "Параметр num1 не передан";
        } else if (num2 == null) {
            return "Параметр num2 не передан";
        } else if (num2 == 0) {
            throw new ZeroDivideException();
        }
        int result = calculatorService.divide(num1, num2);
        return message(num1, num2, '/', result);
    }

    private String message(Integer num1, Integer num2, char action, int result) {
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }
}