package calculator.ui;

import calculator.engine.CalculatorEngine;

public class MainFrame {
	public static void main(String [] args) {
		CalculatorEngine c = new CalculatorEngine();
		
		c.digit(1);
		c.digit(3);
		c.add();
		c.digit(1);
		c.digit(1);
		c.compute();
		System.out.println(c.display());
		
		c.subtract();
		c.digit(4);
		c.compute();
		System.out.println(c.display());
		
		c.multiply();
		c.digit(3);
		c.compute();
		System.out.println(c.display());
		
		c.divide();
		c.digit(1);
		c.digit(5);
		c.compute();
		System.out.println(c.display());
		
		c.clear();
		System.out.println(c.display());
		
		c.digit(1);
		c.digit(3);
		c.add();
		c.digit(1);
		c.digit(1);
		c.compute();
		System.out.println(c.display());
	}
}
