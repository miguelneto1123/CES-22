
public class Triangle extends Shape {
	private double height, base;
	
	Triangle(String aName, double aHeight, double aBase){
		super(aName);
		height = aHeight;
		base = aBase;
	}
	Triangle(){
		this("NO_NAME", 4, 2);
	}
	
	public double calculateArea(){
		return 0.5 * height * base;
	}
}