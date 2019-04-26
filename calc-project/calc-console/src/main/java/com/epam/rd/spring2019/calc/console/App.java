package com.epam.rd.spring2019.calc.console;


import com.epam.rd.spring2019.calc.core.CalcImpl;

public class App {


    public static void main( String[] args )
    {
        System.out.println("<<<Start>>>");

        CalcImpl calc = new CalcImpl();

        if (CalcImpl.isValid(args)) {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            String sign = args[2];

            System.out.println("number1 = " + a + ", number2 = " + b +", operator = \"" + sign + "\", result = " + calc.calculate(a, b, sign));
        } else {

            System.out.println("User input is not valid!");
        }



    }
}
