package tuan2Bai5Rational;

public class Rational {
	private double numerator;
	private double denominator;
	
	public double getNumerator() {
		return numerator;
	}
	public void setNumerator(double numerator) {
		this.numerator = numerator;
	}
	public double getDenominator() {
		return denominator;
	}
	public void setDenominator(double denominator) throws Exception {
		if (denominator != 0)
			this.denominator = denominator;
		else 
			throw new Exception("Mẫu không thể bằng 0");
	}

	public Rational reduce() {
		int sign = (getNumerator()*getDenominator() >= 0) ? 1: -1;

		long count = countDecimalPlaces(getNumerator()) > countDecimalPlaces(getDenominator()) 
				? countDecimalPlaces(getNumerator()) 
				: countDecimalPlaces(getDenominator());
		
		long intNumrator = (long)(getNumerator() * Math.pow(10, count));
		long intDenominator = (long)(getDenominator() * Math.pow(10, count));
		long UCLN = greatestCommonDivisor(intNumrator, intDenominator);
		
		intNumrator = sign * Math.abs(intNumrator)/UCLN;
		intDenominator = Math.abs(intDenominator)/UCLN;
		
		Rational rat = new Rational((double)intNumrator, (double)intDenominator);
		return rat;
	}
	
	public long greatestCommonDivisor(long num1, long num2) {
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		while(num2 != 0) {
			long temp = num1%num2;
			num1 = num2;
			num2 = temp;
		}
		return num1;
	}
	
	public long countDecimalPlaces(double number) {
		String numString = Double.toString(number);
		long indexOfDot = numString.indexOf(".");
		if (indexOfDot >= 0 && !numString.endsWith(".0")) return numString.length() - (indexOfDot + 1);
 			else return 0;
	}
	
	public Rational reciprocal() throws Exception {
		if (this.numerator != 0) {
			Rational rat = new Rational(this.denominator, this.numerator);
			return rat.reduce();
		}else
			throw new Exception("Phân số không có nghịch đảo");
	}
	
	public static Rational add(Rational ra1, Rational ra2) {
		Rational ra3 = new Rational(ra1.numerator * ra2.denominator + ra2.numerator * ra1.denominator, ra1.denominator * ra2.denominator);
		ra3 = ra3.reduce();
		return ra3;
	}
	
	public static Rational subtract(Rational ra1, Rational ra2) {
		Rational ra3 = new Rational(ra1.numerator * ra2.denominator - ra2.numerator * ra1.denominator, ra1.denominator * ra2.denominator);
		ra3 = ra3.reduce();
		return ra3;
	}
	
	public static Rational multiply(Rational ra1, Rational ra2) {
		Rational ra3 = new Rational(ra1.numerator * ra2.numerator, ra1.denominator * ra2.denominator);
		ra3 = ra3.reduce();
		return ra3;
	}
	
	public static Rational divide(Rational ra1, Rational ra2) throws Exception {
		if (ra2.numerator != 0) {
			Rational ra3 = new Rational(ra1.numerator * ra2.denominator, ra1.denominator * ra2.numerator);
			ra3 = ra3.reduce();
			return ra3;
		}else
			throw new Exception("Không thể chia cho 0");
	}
	
	public static int tolerance(Rational ra1, Rational ra2) {
		double epsilon = Rational.subtract(ra1, ra2).toDouble();
		if (Math.abs(epsilon) < 0.0001) return 0;
		else if (epsilon > 0) return 1;
		else return -1;
	}
	
	public double toDouble() {
		return this.numerator/this.denominator;
	}
	
	public Rational() {
		super();
	}
	
	public Rational(double numerator, double denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	@Override
	public String toString() {
		String str;
		if (getDenominator() == 1) {
			str = String.format("%s", (long)getNumerator());
		}else {
			str = String.format("%s/%s", (long)getNumerator(), (long)getDenominator());
		}
		return str;
	}
	
}
