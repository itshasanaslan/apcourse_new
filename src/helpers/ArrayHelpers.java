package helpers;

public class ArrayHelpers {

    public static int findMax(int[] someArray) {
        int maxValue = Integer.MIN_VALUE;
        for (int index = 0; index < someArray.length; index++) {
            if (someArray[index] > maxValue) {
                maxValue = someArray[index];
            }
        }
        return maxValue;
    }

    public static int findMin(int[] someArray) {
        int minValue = Integer.MAX_VALUE;
        for (int index = 0; index < someArray.length; index++) {
            if (someArray[index] < minValue) {
                minValue = someArray[index];
            }
        }
        return minValue;
    }

}
