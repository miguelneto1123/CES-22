
public class Shape {
	private String name;
	
	Shape(String aName) {name = aName;};
	Shape(){this("NO_NAME");}
	
	public String getName(){
		return name;
	}
	public void setName(String aName){
		name = aName;
	}
	
	public double calculateArea(){
		return 0.0;
	}
	
	public static void main(String[] args){
		Circle c = new Circle("circle c");
		Square s = new Square("square s");
		
		Shape shapeArray[] = {c,s};
		for(Shape elem:shapeArray){
			System.out.println("The area of " + elem.getName() +
					" is " + elem.calculateArea() + "cm^2");
		}
	}
}