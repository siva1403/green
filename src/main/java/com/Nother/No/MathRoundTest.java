package com.Nother.No;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class MathRoundTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double db = -0.915092;
		DecimalFormat numberFormat = new DecimalFormat("0.00");
		numberFormat.setRoundingMode(RoundingMode.UP);
		System.out.println(numberFormat.format(db));

	}

}
