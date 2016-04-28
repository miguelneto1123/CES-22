package ui;

import engine.CalculatorEngine;
import errors.DivideByZeroException;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
	public MainFrame() {
		displayBox.setBounds(10, 10, 274, 50);
		displayBox.setColumns(10);
		displayBox.setEditable(false);
		getContentPane().setLayout(null);
		sumButton.setBounds(223, 70, 61, 25);
		sumButton.addActionListener(this);
		
		getContentPane().add(sumButton);
		subtractButton.setBounds(223, 98, 61, 25);
		subtractButton.addActionListener(this);
		
		getContentPane().add(subtractButton);
		multiplyButton.setBounds(223, 126, 61, 25);
		multiplyButton.addActionListener(this);
		
		getContentPane().add(multiplyButton);
		divideButton.setBounds(223, 154, 61, 25);
		divideButton.addActionListener(this);
		
		getContentPane().add(divideButton);
		equalsButton.setBounds(223, 182, 61, 25);
		equalsButton.addActionListener(this);
		
		getContentPane().add(equalsButton);
		d7.setBounds(10, 98, 61, 25);
		d7.addActionListener(this);
		
		getContentPane().add(d7);
		d4.setBounds(10, 126, 61, 25);
		d4.addActionListener(this);
		
		getContentPane().add(d4);
		d1.setBounds(10, 154, 61, 25);
		d1.addActionListener(this);
		
		getContentPane().add(d1);
		d5.setBounds(81, 126, 61, 25);
		d5.addActionListener(this);
		
		getContentPane().add(d5);
		d8.setBounds(81, 98, 61, 25);
		d8.addActionListener(this);
		
		getContentPane().add(d8);
		d2.setBounds(81, 154, 61, 25);
		d2.addActionListener(this);
		
		getContentPane().add(d2);
		d0.setBounds(81, 182, 61, 25);
		d0.addActionListener(this);
		
		getContentPane().add(d0);
		clearButton.setBounds(152, 70, 61, 25);
		clearButton.addActionListener(this);
		
		getContentPane().add(clearButton);
		d9.setBounds(152, 98, 61, 25);
		d9.addActionListener(this);
		
		getContentPane().add(d9);
		d6.setBounds(152, 126, 61, 25);
		d6.addActionListener(this);
		
		getContentPane().add(d6);
		d3.setBounds(152, 154, 61, 25);
		d3.addActionListener(this);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setSize(294, 217);
		
		getContentPane().add(d3);
		
		getContentPane().add(displayBox);
		
		this.c = new CalculatorEngine();
	}

	private final JButton sumButton = new JButton("+");
	private final JButton subtractButton = new JButton("-");
	private final JButton multiplyButton = new JButton("*");
	private final JButton divideButton = new JButton("/");
	private final JButton equalsButton = new JButton("=");
	private final JButton d7 = new JButton("7");
	private final JButton d4 = new JButton("4");
	private final JButton d1 = new JButton("1");
	private final JButton d5 = new JButton("5");
	private final JButton d8 = new JButton("8");
	private final JButton d2 = new JButton("2");
	private final JButton d0 = new JButton("0");
	private final JButton clearButton = new JButton("C");
	private final JButton d9 = new JButton("9");
	private final JButton d6 = new JButton("6");
	private final JButton d3 = new JButton("3");
	private final JTextField displayBox = new JTextField();
	
	private CalculatorEngine c;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource(); 
		
		if (b == d0) {
			c.digit(0);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d1) {
			c.digit(1);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d2) {
			c.digit(2);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d3) {
			c.digit(3);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d4) {
			c.digit(4);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d5) {
			c.digit(5);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d6) {
			c.digit(6);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d7) {
			c.digit(7);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d8) {
			c.digit(8);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == d9) {
			c.digit(9);
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == sumButton) {
			c.add();
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == subtractButton) {
			c.subtract();
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == multiplyButton) {
			c.multiply();
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == divideButton) {
			c.divide();
			String s = "" + c.display();
			displayBox.setText(s);
		}
		else if (b == equalsButton) {
			try {
				c.compute();
				String s = "" + c.display();
				displayBox.setText(s);
			} catch (DivideByZeroException dbze) {
				displayBox.setText(dbze.getMessage());
			}

		}
		else if (b == clearButton) {
			c.clear();
			String s = "" + c.display();
			displayBox.setText(s);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public static void main(String args[]) {
		MainFrame m = new MainFrame();
		m.setVisible(true);
	}
}