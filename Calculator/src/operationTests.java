import static org.junit.Assert.assertEquals;

import org.junit.Test;

import engine.CalculatorEngine;
import errors.DivideByZeroException;

public class operationTests {

	@Test
	public void addTest() {
		CalculatorEngine calc = new CalculatorEngine();
		int res;
		calc.digit(1);
		calc.digit(1);
		calc.add();
		calc.digit(3);
		try {
			calc.compute();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res = calc.display();
		assertEquals(14, res);
	}
	
	@Test
	public void subtractTest() {
		CalculatorEngine calc = new CalculatorEngine();
		int res;
		calc.digit(1);
		calc.digit(1);
		calc.subtract();
		calc.digit(3);
		try {
			calc.compute();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res = calc.display();
		assertEquals(8, res);
	}
	
	@Test
	public void multiplyTest() {
		CalculatorEngine calc = new CalculatorEngine();
		int res;
		calc.digit(1);
		calc.digit(1);
		calc.multiply();
		calc.digit(3);
		try {
			calc.compute();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res = calc.display();
		assertEquals(33, res);
	}
	
	@Test
	public void divideTest() {
		CalculatorEngine calc = new CalculatorEngine();
		int res;
		calc.digit(1);
		calc.digit(1);
		calc.divide();
		calc.digit(3);
		try {
			calc.compute();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res = calc.display();
		assertEquals(3, res);
	}
	
	@Test(expected = DivideByZeroException.class)
	public void divisionByZeroTest() throws DivideByZeroException{
		CalculatorEngine calc = new CalculatorEngine();
		calc.digit(1);
		calc.digit(1);
		calc.divide();
		calc.digit(0);
		calc.compute();
	}

}
