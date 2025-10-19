public class Fraction {
    private int numerator;
    private int denominator;

    // No-arg constructor: defaults to 0/1
    public Fraction() {
        this(0, 1);
    }

    // Two-arg constructor: reduces and normalizes sign
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        // Normalize sign so denominator is always positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    // Euclid's algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return (a == 0) ? 1 : a;
    }

    // Getters & Setters (setters re-reduce and normalize)
    public int getNumerator() { return numerator; }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        int g = gcd(Math.abs(this.numerator), Math.abs(this.denominator));
        this.numerator /= g;
        this.denominator /= g;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    public int getDenominator() { return denominator; }
    public void setDenominator(int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.denominator = denominator;
        int g = gcd(Math.abs(this.numerator), Math.abs(this.denominator));
        this.numerator /= g;
        this.denominator /= g;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Override equals to compare reduced forms
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Fraction)) return false;
        Fraction f = (Fraction) other;
        return this.numerator == f.numerator && this.denominator == f.denominator;
    }

    // Good practice when overriding equals
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + numerator;
        result = 31 * result + denominator;
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
