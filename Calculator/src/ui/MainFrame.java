package ui;

import engine.CalculatorEngine;
import errors.DivideByZeroException;

public class MainFrame {
	public static void main(String [] args) {
		CalculatorEngine c = new CalculatorEngine();
		
		c.digit(1);
		c.digit(3);
		c.add();
		c.digit(1);
		c.digit(1);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
		
		c.subtract();
		c.digit(4);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
		
		c.multiply();
		c.digit(3);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
		
		c.divide();
		c.digit(1);
		c.digit(5);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
		
		c.clear();
		System.out.println(c.display());
		
		c.digit(1);
		c.digit(3);
		c.add();
		c.digit(1);
		c.digit(1);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
		
		c.divide();
		c.digit(0);
		try {
			c.compute();
		} catch (DivideByZeroException e){
			System.out.println(e);
		}
		System.out.println(c.display());
	}
}