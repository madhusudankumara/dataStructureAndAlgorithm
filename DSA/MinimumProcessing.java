package java_collection.DSA;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
* same as painters problem | split array largest sum | Dual core processor
* https://www.youtube.com/watch?v=thUd_WJn6wk
* */

public class MinimumProcessing {
    public static void main(String[] args) {
        List<Integer> tt = new LinkedList<>(Arrays.asList(10, 21, 10, 21, 10));
        int numberOfprocessor = 2;
        int mpt = getMinimumProcessing(tt,numberOfprocessor);
        List<Long> maxProcess = getMaxProcess(tt,numberOfprocessor);
        System.out.println(mpt);
        System.out.println(maxProcess);
    }

    private static List<Long> getMaxProcess(List<Integer> tt, int numberOfprocessor) {
        long firstProcessorTime = getMinimumProcessing(tt,numberOfprocessor);
        long secondProcessorTime = tt.stream().reduce(0 ,Integer::sum)-firstProcessorTime;
        return new LinkedList<>(Arrays.asList(firstProcessorTime,secondProcessorTime));
    }

    private static int getMinimumProcessing(List<Integer> tt,int np) {
        int low = Collections.max(tt);
        int high = tt.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int countDevisions = countDevision(tt, mid);

            if(countDevisions > np){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int countDevision(List<Integer> tt, int mid) {
        int processor = 1;
        int processComplete = 0;

        for (int i = 0; i < tt.size(); i++) {
            if(processComplete+ tt.get(i) <= mid){
                processComplete+=tt.get(i);
            }else{
                processor++;
                processComplete = tt.get(i);
            }
        }
        return processor;
    }
}
