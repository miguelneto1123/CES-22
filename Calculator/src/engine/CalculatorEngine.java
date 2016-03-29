package engine;

public class CalculatorEngine {
	private int value;
	private int keep;
	private char toDo;
	
	public CalculatorEngine(){
		value = 0;
		keep = 0;
	}
	
	public void clear() {
		value = 0;
		keep = 0;
	}
	
	public int display () {
		return value;
	}
	
	public void digit(int x) {
		value = value * 10 + x;
	}
	
	public void binaryOperation (char op) {
		keep = value;
		value = 0;
		toDo = op;
	}
	
	public void add() {
		binaryOperation('+');
	}
	
	public void subtract() {
		binaryOperation('-');
	}
	
	public void multiply() {
		binaryOperation('*');
	}
	
	public void divide() {
		binaryOperation('/');
	}
	
	public void compute() {
		boolean hasOperator = false;
		
		switch (toDo) {
		case '+':
			hasOperator = true;
			value = keep + value;
			break;
		case '-':
			hasOperator = true;
			value = keep - value;
			break;
		case '*':
			hasOperator = true;
			value = keep * value;
			break;
		case '/':
			hasOperator = true;
			value = keep / value;
			break;
		default:
			break;
		}
		if (hasOperator) {
			keep = 0;
		}
	}
}