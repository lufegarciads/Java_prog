// Luis Felipe Garcia de Souza (Leader), Diana Afanasyev, Jessie Moszkowicz, Barry Penner
// COMP 5511 - Principles of Data Structures
// Fall 2023
// Assignment 1 Question 4

import java.util.Random;
import java.util.ArrayList;

public class BinarySearch {

    public static int RECURSIONS = 1; // static variable to help count recursive depth during binary searches

    public static void main(String[] args) {
        run(10000, 10000); // <number of elements per array>, <iterations>
    }

    public static void run(int arrSize, int loops) {
        /*
        for each loop, generate a listset and run both search algorithms on each array in the listset.
        Compile data from each search pass and send to benchmark().
        var runs    : same as (number of arrays * number of test loops)
        var *finds  : count of successful searches for each algorithm. Will always be the same for both algorithms;
                      basically only records whether search target is present in array or not, which is a function
                      of the random list generation.
        var *times  : arrays that store runtime for each algorithm's search run.
        var listSet : array of arrays, created by generator() method call for each test loop
        var target  : search target, generated at random for each test loop
        */
        int runs = 0;
        int standardFinds = 0;
        int offsetFinds = 0;
        ArrayList<Integer> standardTimes = new ArrayList<>();
        ArrayList<Integer> offsetTimes   = new ArrayList<>();
        ArrayList<Integer> standardRecursions = new ArrayList<>();
        ArrayList<Integer> offsetRecursions = new ArrayList<>();

        for (int i = 0; i < loops; i++) {
            // new array and target value for each run loop
            int[] arr = generator(arrSize);
            Random random = new Random();
            int target = random.nextInt(arr[arrSize-1])+1; // target = random integer between 1 and max value in array

            // STANDARD RUN:
            long startStandardTime = System.nanoTime();
            int[] standardResult = standardBinarySearch(arr, 0, arr.length-1, target);
            long endStandardTime = System.nanoTime();
            if (standardResult[0] == 1) {
                standardFinds++;
                int standardDuration = (int)(endStandardTime - startStandardTime);
                standardTimes.add(standardDuration);
                standardRecursions.add(standardResult[1]);
            }
            
            // OFFSET RUN:
            long startOffsetTime = System.nanoTime();
            int[] offsetResult = offsetBinarySearch(arr, 0, arr.length-1, target, 5);
            long endOffsetTime = System.nanoTime();
            if (offsetResult[0] == 1) {
                offsetFinds++;
                int offsetDuration = (int)(endOffsetTime - startOffsetTime);
                offsetTimes.add(offsetDuration);
                offsetRecursions.add(offsetResult[1]);
            }
            runs++;
        }

        // send results to handler method for processing and string output
        int[] stdSummary = benchmark("standard", arrSize, standardTimes, runs, standardFinds, standardRecursions);
        int[] offSummary = benchmark("offset", arrSize, offsetTimes, runs, offsetFinds, offsetRecursions);
        // send processed results to second handler method for comparison
        compare(stdSummary, offSummary);

        return;
    }

    // SEARCH ALGORITHMS
    /*
    The two search algorithms are nearly identical; only difference is inclusion of a variable pivot point in 
    the offset algorithm. With some more fussing they probably could be combined, but this is easy to read
    and debug.
    Both are set to return boolean values, as there is no need to see the search result.
    Algorithm: to to pivot point in sorted array. If target is larger than pivot value, recurse on
    right (larger) subarray; if target is smaller than pivot value, recurse on left (smaller) subarray.
    Return when value is found, or when subarray is reduced to length 1.
    */
    public static int[] standardBinarySearch(int[] array, int low, int high, int target) {
        // standard algorithm: pivot is always the midpoint of the array
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                int rec = RECURSIONS;
                RECURSIONS = 1;
                return new int[] {1, rec};
            } else if (array[mid] > target) {
                RECURSIONS++;
                return standardBinarySearch(array, low, mid-1, target);
            } else {
                RECURSIONS++;
                return standardBinarySearch(array, mid+1, high, target);
            }
        } else {
            int rec = RECURSIONS;
            RECURSIONS = 1;
            return new int[] {0, rec};
        }
    }

    public static int[] offsetBinarySearch(int[] array, int low, int high, int target, int pivot) {
        // offset algorithm: pivot is 1/5 from start of (sub) array, unless the array to be searched is
        // the longer of the two (i.e. search target is greater than the mid[] value), in which case the pivot
        // is the midpoint of that larger array.
        if (high >= low) {
            int mid = low + (high - low) / pivot;
            if (array[mid] == target) {
                int rec = RECURSIONS;
                RECURSIONS = 1;
                return new int[] {1, rec};
            } else if (array[mid] > target) {
                RECURSIONS++;
                return offsetBinarySearch(array, low, mid-1, target, 5); // left, smaller, subarray; recursion will 
                                                                         // use 1/5 strategy for one pass
            } else {
                RECURSIONS++;
                return offsetBinarySearch(array, mid+1, high, target, 2); // right, larger, subarray; recursion will
                                                                          // use 1/2 (standard binary) strategy for one pass
            }
        } else {
            int rec = RECURSIONS;
            RECURSIONS = 1;
            return new int[] {0, rec};
        }
    }

    // UTILITY FUNCTIONS
    // Summary statistics for each algorithm:
    public static int[] benchmark(String algorithm,
                                 int arrSize,
                                 ArrayList<Integer> times,
                                 int runs,
                                 int finds,
                                 ArrayList<Integer> recursions) {
                                 // takes data generated during search runs and outputs summary statistics
        // TIME:
        int timeSum = 0;
        int shortestTime = Integer.MAX_VALUE;
        int longestTime  = 0;
        for (int t : times) {
            timeSum += t;
            if (t < shortestTime)
                shortestTime = t;
            if (t > longestTime)
                longestTime = t;
        }

        // RECURSIONS:
        int recSum = 0;
        int shortestRec = Integer.MAX_VALUE;
        int longestRec  = 0;
        for (int r : recursions) {
            recSum += r;
            if (r < shortestRec)
                shortestRec = r;
            if (r > longestRec)
                longestRec = r;
        }

        int timeAvg = timeSum / times.size();
        int recAvg  = recSum  / recursions.size();
        double rate = finds/(runs * 1.0) * 100.0;
        System.out.printf("-------------------------------------------------------------------------\n");
        System.out.printf("%s algorithm:\n", algorithm);
        System.out.printf("\t   %d arrays of %d elements searched\n", runs, arrSize);
        System.out.printf("\t   %d successful searches (%.1f%% hit rate)\n", finds, rate);
        System.out.printf("\t   fewest recursions: %d | most: %d | average: %d\n", shortestRec, longestRec, recAvg);
        System.out.printf("\t   shortest time: %d ns | longest: %d ns | average: %d ns\n", shortestTime, longestTime, timeAvg);
        return new int[] {finds, recAvg, timeAvg}; //success count, avg recursions, avg time
    }

    // comparison results:
    public static void compare(int[] stdSummary, int[] offSummary) {
        String findsResult;
        String recursionsResult;
        String timingResult;
        // compare number of successful searches
        if (stdSummary[0] != offSummary[0]) { // finds
            findsResult = "FAIL: algorithms did not find the same number of targets.";
        } else {
            findsResult = "both algorithms found the same number of targets.";
        }
        // compare average runtimes
        if (stdSummary[1] > offSummary[1]) {
            recursionsResult = "1/5 offset algorithm required fewer average recursive calls.";
        } else if (stdSummary[1] < offSummary[1]) {
            recursionsResult = "standard algorithm required fewer average recursive calls.";
        } else {
            recursionsResult = "algorithms had the same average recursive depth.";
        }
        // compare average recursion depths
        if (stdSummary[2] > offSummary[2]) {
            timingResult = "1/5 offset algorithm was faster, on average.";
        } else if (stdSummary[2] < offSummary[2]) {
            timingResult = "standard algorithm was faster, on average.";
        } else {
            timingResult = "algorithms had the same average time.";
        }
        System.out.printf("-------------------------------------------------------------------------\n");
        System.out.printf("Comparison:\n");
        System.out.printf("Searches   %s\nRecursion  %s\nTiming     %s\n", findsResult, recursionsResult, timingResult);
        System.out.printf("-------------------------------------------------------------------------\n");
        return;
    }

    // array generator
    private static int[] generator(int n) {
        // generate an array of n integers each, constructed using pseudorandom increments <10 between elements.
        Random random = new Random();
        // int[][] listSet = new int[m][n];
        // int[] arr;
        // for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            arr[0] = random.nextInt(99-1)+1; // seed value, 1 <= seed <= 99
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j-1] + random.nextInt(9-1)+1; // array increments, 1 <= incr. <= 9
            }
        return arr;
    }

}
