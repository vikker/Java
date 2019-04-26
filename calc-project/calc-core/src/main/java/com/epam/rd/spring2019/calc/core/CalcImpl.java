package com.epam.rd.spring2019.calc.core;

import com.epam.rd.spring2019.calc.interfaces.Calc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcImpl implements Calc {


    static Logger logger = LoggerFactory.getLogger(Calc.class);


    public double addition(double a, double b) {
        return a + b;
    }

    public double subtraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public double division(double a, double b) {
        return a / b;
    }

    public double calculate(double a, double b, String operator) {

        if (operator.equals("+")) {
            return addition(a, b);
        } else if (operator.equals("-")) {
            return subtraction(a, b);
        } else if (operator.equals("*")) {
            return multiplication(a, b);
        } else {
            return division(a, b);
        }
    }

    public static boolean isValid(String[] arr) {

        logger.info("<<<Validation test is starting>>>");
        logger.info("<<Check the count of passing parameters>>");

        if (arr.length != 3) {

            logger.error("You should pass 3 parameters for calculating: number1, number2, operator");
            logger.warn("You should pass 3 parameters for calculating: number1, number2, operator");
            logger.info("You should pass 3 parameters for calculating: number1, number2, operator");
            return false;

        }

        logger.info("<<Check first parameter>>");

        if (!isDouble(arr[0])) {

            logger.error("First parameter is not a number!");
            logger.warn("First parameter is not a number!");
            logger.info("First parameter is not a number!");
            return false;

        }

        logger.info("<<Check second parameter>>");

        if (!isDouble(arr[1])) {

            logger.error("Second parameter is not a number!");
            logger.warn("Second parameter is not a number!");
            logger.info("Second parameter is not a number!");
            return false;

        }

        logger.info("<<Check the count of symbols for third parameter>>");

        if (arr[2].length() != 1) {

            logger.error("You should input the third parameter as an operator. It must be one symbol");
            logger.warn("You should input the third parameter as an operator. It must be one symbol");
            logger.info("You should input the third parameter as an operator. It must be one symbol");
            return false;

        }

        logger.info("<<Check is a third parameter a mathematical operator>>");

        if (!isMathOperator(arr[2])) {

            logger.error("Third parameter is not an math operator. It can be one from \"+\", \"-\", \"*\", \"/\"");
            logger.warn("Third parameter is not an math operator. It can be one from \"+\", \"-\", \"*\", \"/\"");
            logger.info("Third parameter is not an math operator. It can be one from \"+\", \"-\", \"*\", \"/\"");
            return false;

        }

        logger.info("<<Check dividing by zero>>");

        if ( Double.parseDouble(arr[1]) == 0 && arr[2].equals("/")) {

            logger.error("Dividing by zero");
            logger.warn("Dividing by zero");
            logger.info("Dividing by zero");
			return false;
        }

        logger.info("<<<Validation test is complete>>>");

        return true;
    }

    public static boolean isDouble(String s) {

        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {

            return false;
        }
        return true;
    }

    public static boolean isMathOperator(String s) {

        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

            return true;

        } else {

            return false;
        }
    }


}
