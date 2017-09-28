import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;

public class Neiron {

	public Neiron(PApplet p, int num) {
		this.p = p;
		weights = new float[num+1];
		for (int i = 0; i < num+1; i++) {
			weights[i] = p.random(1);
		}
		
	}

	boolean learned = false;

	@Override
	public String toString() {
		return "Neiron [weights=" + Arrays.toString(weights) + "]";
	}

	float weights[];
	PApplet p;

	public void startTraining() {
		errors.clear();
	}

	ArrayList<Float> errors = new ArrayList<>();

	public int train(float[] input, int target) {
		if (input.length != weights.length-1) {
			System.out.println("Diferent length of array input and weights");
			return -1;		}
		float out = 0;
		for (int i = 0; i < input.length; i++) {
			out += input[i] * weights[i];
		}
		out+=weights[weights.length-1];
		float error;
		if (p.round(out) == target) {
			error = 0;
		} else {
			error = target - out;
		}
		for (int i = 0; i < input.length; i++) {
			weights[i] +=input[i]*error*0.02;
		}
		weights[weights.length-1]+=error*0.02;
		return p.round(out);
	}

	public void endTraining() {
		if (errors.isEmpty()) {
			learned = true;
			return;
		}
		float sum = 0;
		for (Float f : errors) {
			sum += f*f;
		}
		float k =sum / errors.size();
		System.out.println(errors);
		System.out.println(k);
		System.out.println(toString());
		for (int i = 0; i < weights.length; i++) {
			weights[i] = weights[i]+p.random(-k*0.02f,k*0.02f);
		}
		System.out.println("====");
	}
}
