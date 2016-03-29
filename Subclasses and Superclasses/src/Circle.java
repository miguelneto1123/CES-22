
public class Circle extends Shape {
	private double radius;
	
	Circle(String aName, double aRadius){
		super(aName);
		radius = aRadius;
	}
	Circle(){
		this("NO_NAME", 3);
	}
	Circle(String aName){
		this(aName, 3);
	}
	
	public double calculateArea(){
		return Math.PI * radius * radius;
	}
}