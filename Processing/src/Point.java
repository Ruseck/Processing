import processing.core.PApplet;

public class Point {

	float x;
	float y;
	int label;
	PApplet p;

	public Point(float x, float y, PApplet p) {
		this.p = p;
		this.x = x;
		this.y = y;
		label = x+y>300?1:0;
	}

	public void show() {
		p.fill(label == 1 ? 0 : 255);
		p.noStroke();
		p.ellipse(x, y, 6, 6);
	}

}
