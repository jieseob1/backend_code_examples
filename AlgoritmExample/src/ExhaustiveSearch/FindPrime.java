package ExhaustiveSearch;

import java.util.Arrays;

public class FindPrime {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    boolean[] isVisited = new boolean[arr.length];
    int[] permutatedArr = new int[arr.length];
//    permutation(arr, isVisited, permutatedArr, 0);
    combination(arr, isVisited, 0, 0,permutatedArr);

    System.out.println();

  }

  public int solution(String numbers) {
    int answer = 0;
    return answer;
  }

  private static void combination(int[] elements, boolean[] visitedArr, int start, int depth,int[] resultArr) {
    if (depth == 3) {
      System.out.println(Arrays.toString(resultArr));
      System.out.println();
    } else {
      for (int i = start; i < elements.length; i++) {
        visitedArr[i] = true;
        resultArr[depth] = elements[i];
        combination(elements, visitedArr, i + 1, depth + 1,resultArr);
        visitedArr[i] = false;
      }
    }
  }
  private static void permutation(int[] elements, boolean[] visitedArr, int[] resultArr,
      int depth) {
    if (depth == elements.length) {
      System.out.println(Arrays.toString(resultArr));
    } else {
      for (int i = 0; i < elements.length; i++) { //for 문 도는 것을 생각하지 못했음
        if (!visitedArr[i]) { // 중복 순열 제거용
          visitedArr[i] = true;
          System.out.println();
          System.out.println("depth => " + depth);
          resultArr[depth] = elements[i];
          System.out.println();
          System.out.println("visitedArr");
          System.out.println();
          for (boolean b : visitedArr) {
            System.out.print(b + " ");
          }
          System.out.println();
          System.out.println("resultArr");
          for (int i1 : resultArr) {
            System.out.print(i1 + " ");

          }
          permutation(elements, visitedArr, resultArr, depth + 1);

          System.out.println("after permutation i => " + i);
          visitedArr[i] = false;
          System.out.println();
          for (boolean b : visitedArr) {
            System.out.print(b + " ");
          }
          System.out.println();
        }
      }

    }
  }
}
