package utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtils {

    public static final String NULL_LIST_MESSAGE = "list must not be null";
    public static final String INVALID_SIZE_MESSAGE = "size must be greater than 0";

    private ListUtils() {
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        if(null == list) {
            throw new IllegalArgumentException(NULL_LIST_MESSAGE);
        }

        if(0 >= size ) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }

        return IntStream.range(0, ceilingDivision(list.size(), size))
                .mapToObj(i -> subList(list, i * size, size))
                .collect(Collectors.toList());
    }

    private static int ceilingDivision(int dividend, int divisor) {
        return (dividend + divisor - 1) / divisor;
    }

    private static <T> List<T> subList(List<T> list, int start, int size){
        return list.subList(start, Math.min((start + size), list.size()));
    }


}
