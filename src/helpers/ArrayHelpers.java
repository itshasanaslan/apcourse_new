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

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }


     public static void printArray(String[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }

   public static void print2DArray(int[][] grid) {
		String t = "[";

		for (int i = 0; i < grid.length; i++) {
			for (int c = 0; c < grid[i].length; c++) {
				t += grid[i][c] + ", ";
			}

			t = t.substring(0, t.length() - 2) + "]\n[";
		}

		t = t.substring(0, t.length() - 1);

		System.out.println(t);
	}


    // 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22

// binary(array, 15)

    public boolean includesBinarySearch(int[] numbers, int target) {
       int left  = 0;
       int right = numbers.length - 1;


       while (left <= right){
        int mid = left + (right - left) / 2;

        if (numbers[mid] == target) {
            return true;
        }
        
        if (numbers[mid ] < target) {
            left = mid + 1;
        }
        else  {
            right = mid -1;
        }


       }

       return false;
    }

    public static boolean includes(int[][] grid, int x) {
        // if item x exist in the grid.
        // jsut itereate the rows
        // and the cols
        // if array[row][col] == x;return true;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == x) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int findOccurrences(int[][] grid, int x) {
        int occurs = 0;
        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == x) {
                    occurs++;
                }
            }
        }

        return occurs;
    }

    public static int[] getLocation(int x, int[][] grid) {
        int[] location = { -1, -1 };
        if (ArrayHelpers.includes(grid, x)) {
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    if (grid[row][col] == x) {
                        location[0] = row;
                        location[1] = col;
                    }
                }
            }
        }
        return location;
    }


    public static void insertionSort(int[] array) {
        // start from 2nd item
        for (int i = 1; i < array.length; i++ ) {
            int key = array[i];
            int j = i -1; // index for the item on the left

            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

    }

    


    public static void selectionSort(int[] arr) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }


    public static void mergeSort(int[] elements, int from, int to) {
        // Base Case: If from is not less than to, the subarray has 1 or 0 items
        if (from < to) {
            int middle = (from + to) / 2;

            // Recursively sort the left and right halves
            mergeSort(elements, from, middle);
            mergeSort(elements, middle + 1, to);

            // Merge the sorted halves back together
            merge(elements, from, middle, to);
        }
    }

    // 2. The "Zipper" (Merge Helper Method)
    private static void merge(int[] elements, int from, int middle, int to) {
        // Create a temporary array to hold the merged result
        int[] temp = new int[to - from + 1];

        int i = from;       // Pointer for the left half
        int j = middle + 1; // Pointer for the right half
        int k = 0;          // Pointer for the temp array

        // Compare elements and pick the smaller one
        while (i <= middle && j <= to) {
            if (elements[i] < elements[j]) {
                temp[k] = elements[i];
                i++;
            } else {
                temp[k] = elements[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left half
        while (i <= middle) {
            temp[k] = elements[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right half
        while (j <= to) {
            temp[k] = elements[j];
            j++;
            k++;
        }

        // Copy everything from temp back into the original array
        for (int n = 0; n < temp.length; n++) {
            elements[from + n] = temp[n];
        }
    }


    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Using this formula prevents potential integer overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found!
            }

            if (nums[mid] < target) {
                left = mid + 1; // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
        }

        return -1; // Target not found
    }



    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        int index = 0;

        while (index < size) {
            array[index++] =(int) (Math.random() * (max - min + 1)) + min;
        }
        return array;
    }
}
