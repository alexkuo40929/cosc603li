public class Rectangle {
	private Point p1, p2;
	
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Double getArea() {
		return Math.abs((p2.x - p1.x) * (p2.y - p1.y));
	}
	
	public Double getDiagonal() {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}
}
