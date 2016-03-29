
public class Square extends Shape {
	private double side;
	
	Square(String aName, double aSide){
		super(aName);
		side = aSide;
	}
	Square(){
		this("NO_NAME", 3);
	}
	Square(String aName){
		this(aName, 3);
	}
	
	public double calculateArea(){
		return side * side;
	}
}