package bootcamp.data;

import java.util.*;

public class Processor {

    private final ArrayList<Double> doubleArray;

    public Processor(ArrayList<Double> doubleArray) {
        this.doubleArray = doubleArray;
    }

    public Summary process() {
        if (doubleArray.size() == 0) return new Summary(Double.NaN, Double.NaN, Double.NaN, 0, Double.NaN);

        double average = getAverage();
        double count = getCount();
        double min = getMin();
        double max = getMax();
        double sum = getSum();
        return new Summary(min, max, sum, count,average);
    }

    public Optional<Double> getValue(int index){
        if(index > doubleArray.size()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index < 0) {
            Optional.empty();
        }

        return Optional.of(doubleArray.get(index));
    }

    public Double getMax() {
        return doubleArray.isEmpty() ? Double.NaN : Collections.max(doubleArray);
    }
    public Double getMin() {
        return doubleArray.isEmpty() ? Double.NaN : Collections.min(doubleArray);
    }
    public int getCount() {
        return doubleArray.size();
    }
    public Double getSum() {
        double sum = 0.0;
        for(double num :doubleArray) {
           sum += num;
        }
        return doubleArray.isEmpty() ? Double.NaN : sum;
    }
    public double getAverage() {
        return doubleArray.isEmpty() ? Double.NaN : getSum() / getCount();
    }

}



// Process function returns a Summary object containing the minimum and maximum values, number of elements in the array,
// sum of values and the average value.
