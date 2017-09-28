import java.util.ArrayList;

import processing.core.PApplet;

public class UsingProcessing extends PApplet {

	public static void main(String[] args) {
		PApplet.main("UsingProcessing");
	}

	public void settings() {
		size(500, 500);
	}

	ArrayList<Point> ps = new ArrayList<>();
	Neiron n;

	public void setup() {
		
		n = new Neiron(this, 2);
		for (int i = 0; i < 250; i++) {
			ps.add(new Point(random(width), random(height), this));
		}
	}

	public void draw() {
		if(!mousePressed)return;
		background(155);
		n.startTraining();
		for (Point p : ps) {
			int res=n.train(new float[] {map(p.x,0,width,0,1), map(p.y,0,height,0,1), 1}, p.label);
			
			p.show();
			fill(res==1?255:0);
			ellipse(p.x,p.y,3,3);
		}
		System.out.println(n.toString());
		//n.endTraining();
	}

}
