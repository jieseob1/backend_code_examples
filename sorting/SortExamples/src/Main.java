import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  private static void primitiveSortTest() {
    int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr)); // [6, 7, 9, 13, 21, 45, 101, 102]
    //toString으로 해서 배열 보여준다
  }

  private static void CollectionSortTest() {
    List<Integer> list = new ArrayList<>(Arrays.asList(13, 7, 6, 45, 21, 9, 101, 102));
    Collections.sort(list);
    System.out.println(list); // [6, 7, 9, 13, 21, 45, 101, 102]
  }

  private static void streamSortTest() {
    List<Integer> list = new ArrayList<>(Arrays.asList(13, 7, 6, 45, 21, 9, 101, 102));
    Stream<Integer> streamList = list.stream();
    Stream<Integer> sortedStreamList = streamList.sorted();
    sortedStreamList.collect(Collectors.toList()); //collector란 stream을 다시 list로 만들어준다

    streamList.mapToInt(Integer::intValue).sorted().toArray(); //stream을 int형 배열로 바꾼다
    //maptoint는 stream을 int형으로 바꾸는 것이다
    //toArray는 stream을 배열로 바꾸는 것이다
    //stream이란 데이터의 흐름이다
    // 6
    // 7
    // 9
    // 13
    // 21
    // 45
    // 101
    // 102
  }

  private static void primitiveCompatatorTest() {
    int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
    int[] reversed = Arrays.stream(arr)
        .boxed() //boxed란 int를 Integer로 바꾸는 것이다 왜 Integer로 바꾸냐면 comparator를 쓰기 위해서 int는 comparator를 왜 못 쓰는지=> int는 primitive type이라서
        //boxed => Stream<Integer>
        .sorted((v1, v2) -> v2 - v1)
        .mapToInt(Integer::intValue)
        .toArray();
    System.out.println(Arrays.toString(reversed)); // [102, 101, 45, 21, 13, 9, 7, 6]
  }

  private static void stringComparatorSortTest() {
    String[] words = {"java", "programming", "happy", "fun", "coding"};
    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length()); //길이순으로 정렬
    System.out.println(Arrays.toString(words)); // [fun, java, happy, coding, programming]
  }

  private static void objectCompareToSortTest() {

  }
}