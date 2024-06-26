import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    biggestNumberSortingTest();
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

  private static void charsString() {
    String mystr = "helloWorld";
    String answer = mystr.chars().boxed().sorted((v1,v2) -> v2-v1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    System.out.print(answer); // rllWooedh
  }

//  private static void charsWithoutUsingAppendCodePoint() {
//    String str1 = "helloJava";
//    String str2 = str1.chars().boxed().sorted((v1,v2) -> v2-v1).collect(StringBuilder::new, StringBuilder::append).toString();
//    System.out.print(str2); // 106111118101101108
//  }

  private static void stringArraySortingTest1() {
    String[] strs = {"apple", "banana", "cherry", "date", "elderberry"};
    Arrays.sort(strs, Comparator.reverseOrder()); // 반대는 이런식으로
    //결과값 : elderberry, date, cherry, banana, apple
  }

  //comparator, compareto, comparable, Collections 알기
  //comparator란 두 객체를 비교할 때 사용하는 인터페이스
  //compareto란 두 객체를 비교할 때 사용하는 메소드
    //comparable란 객체를 비교할 때 사용하는 인터페이스 => compareto를 구현해야 한다
    //Collections란 자바에서 제공하는 유틸리티 클래스 => 배열을 다루는데 유용한 메소드들이 많이 있다
  private static void biggestNumberSortingTest() {
    //이 부분 잘 이해 안되긴 함
    int[] numbers = {6,10,2,4}; // n * n-1 번 만큼 도는듯
    String ans = Arrays.stream(numbers) //arrays.stream으로 하네
        .mapToObj(String::valueOf) //int를 string으로 바꾸는 것 mabtoobj란 int를 object로 바꾸는 것이다
        .sorted((s1, s2) -> {
          int original = Integer.parseInt(s1 + s2); //s1+s2란 s1s2란 문자열을 만들어서 정수로 바꾸는 것이다
          int reversed = Integer.parseInt(s2 + s1);
          System.out.println("s1 => " + s1);
          System.out.println("s2 => " + s2);
          System.out.println("reversed => " + reversed);
          System.out.println("original => " + original);
          return reversed - original;
        }).collect(Collectors.joining(""));
    System.out.println("number outcome");
    System.out.println(ans);
  }

  //comparable 사용 예시 메소드
    private void comparableTest() {
        List<ComparableStudent> students = new ArrayList<>();
        students.add(new ComparableStudent("John", 25));
        students.add(new ComparableStudent("Steve", 30));
        students.add(new ComparableStudent("Martin", 20));
        students.add(new ComparableStudent("Tom", 18));
        students.add(new ComparableStudent("Jim", 40));
        Collections.sort(students);
        students.forEach(System.out::println); // Student{name='Tom', age=18} Student{name='Martin', age=20} Student{name='John', age=25} Student{name='Steve', age=30} Student{name='Jim', age=40}
    }

    class ComparableStudent implements Comparable<ComparableStudent> {
        private String name;
        private int age;

        public ComparableStudent(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(ComparableStudent o) {
            return this.age - o.age; //나이순으로 정렬 => 오름차순
        }

        @Override
        public String toString() { // toString을 오버라이딩해서 출력을 원하는대로 바꿀 수 있다
            return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}