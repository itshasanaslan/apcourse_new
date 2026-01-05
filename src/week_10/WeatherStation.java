package week_10;

public class WeatherStation {
    private double[] temperatures;


    public WeatherStation (int size) {
        this.temperatures = new double[size];
    } 

    public void setTemp(int index, double val) {
        this.temperatures[index] = val;
    }

    public double getAverage() {
        double sum = 0;
        for (double temp : this.temperatures) {
               sum += temp; 
        }
        return sum / this.temperatures.length;
    }


    public double getMax() {
        double maxTemp = Double.MIN_VALUE;

       for (double temp : this.temperatures) {
               if ( temp > maxTemp)  maxTemp = temp;
        }

        return maxTemp;
    }

    public int countAbove(double threshold) {
        int hotDays = 0;
           for (double temp : this.temperatures) {
               if ( temp > threshold) hotDays++;
        }


        // sorting & merging
        // a to z

        return hotDays;
    }
}
