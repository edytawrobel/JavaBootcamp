package bootcamp.data;

public class Summary {
    private final double min = Double.MIN_VALUE;
    private final double max = Double.MAX_VALUE;
    private final double sum = Double.sum(min, max);
    private final double count = Double.SIZE;
    private final double average = Double.valueOf(max / min);

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }
}
