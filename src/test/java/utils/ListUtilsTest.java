package utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ListUtilsTest {

    private final List<Integer> listOf10 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void whenPartitionNullList_thenIllegalArgumentExceptionThrownWithExpectedMessage() {

        assertThrows(ListUtils.NULL_LIST_MESSAGE,
                IllegalArgumentException.class,
                () -> ListUtils.partition(null, 1)
        );
    }

    @Test
    public void whenPartitionEmptyList_thenReturnEmptyList() {
        assertEquals(Collections.emptyList(), ListUtils.partition(Collections.emptyList(), 1));
    }

    @Test
    public void whenPartitionByZero_thenIllegalArgumentExceptionThrownWithExpectedMessage() {
        assertThrows(ListUtils.INVALID_SIZE_MESSAGE,
                IllegalArgumentException.class,
                () -> ListUtils.partition(listOf10, 0)
        );
    }

    @Test
    public void whenPartitionByNegativeSize_thenIllegalArgumentExceptionThrownWithExpectedMessage() {
        assertThrows(ListUtils.INVALID_SIZE_MESSAGE,
                IllegalArgumentException.class,
                () -> ListUtils.partition(listOf10, -2)
        );
    }

    @Test
    public void whenPartitionByOne_thenReturnListPartitionedByOne() {
        assertEquals(getListOf10PartitionedBy1(), ListUtils.partition(listOf10, 1));
    }

    @Test
    public void whenPartitionByListSizeDivisor_thenReturnListPartitionedBySize() {
        assertEquals(getListOf10PartitionedBy5(), ListUtils.partition(listOf10, 5));
    }

    @Test
    public void whenPartitionByNonListSizeDivisor_thenReturnListPartitionedBySize() {
        assertEquals(getListOf10PartitionedBy6(), ListUtils.partition(listOf10, 6));
    }

    @Test
    public void whenPartitionByListSize_thenReturnListPartitionedByListSize() {
        assertEquals(ListOf10PartitionedBy10(), ListUtils.partition(listOf10, 10));
    }

    @Test
    public void whenPartitionBySizeGreaterThanListSize_thenReturnListPartitionedByListSize() {
        assertEquals(ListOf10PartitionedBy10(), ListUtils.partition(listOf10, 15));
    }

    private List<List<Integer>> getListOf10PartitionedBy1 (){
        return Arrays.asList(
                Collections.singletonList(1),
                Collections.singletonList(2),
                Collections.singletonList(3),
                Collections.singletonList(4),
                Collections.singletonList(5),
                Collections.singletonList(6),
                Collections.singletonList(7),
                Collections.singletonList(8),
                Collections.singletonList(9),
                Collections.singletonList(10)
        );
    }

    private List<List<Integer>> getListOf10PartitionedBy5 (){
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10)
        );
    }

    private List<List<Integer>> getListOf10PartitionedBy6() {
        return Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10)
        );
    }

    private List<List<Integer>> ListOf10PartitionedBy10() {
        return Collections.singletonList(listOf10);
    }

}
