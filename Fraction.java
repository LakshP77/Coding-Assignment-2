public class Fraction {
    // encap
    private int numerator;
    private int denominator;

    // Default constructor
    public Fraction() {
        this(0, 1);  // 0/1 is the "empty" fraction
    }

    // Custom constructor
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        // Normalize sign (denominator should be positive)
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / g;
        this.denominator = denominator / g;

    }
    // runs until b = 0, and returns gcd
    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return (a == 0) ? 1 : a;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator( int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0");
        this.denominator = denominator;
    }

    @Override
    // equals() lets Java compare two Fraction objects by value instead of memory.
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator == other.numerator && this.denominator == other.denominator;

    }

    @Override 
    // toString() controls how it prints when you System.out.println() it.
    public String toString() {
        return numerator + "/" + denominator;
    }
}

   

    
