public class FractionCounter {
    private Fraction fraction;
    private int count;

    public FractionCounter(Fraction fraction) {
        this.fraction = fraction;
        this.count = 1;
    }

    public boolean compareAndIncrement(Fraction newFraction) {
        if (fraction.equals(newFraction)) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return fraction + " has a count of " + count;
    }
}