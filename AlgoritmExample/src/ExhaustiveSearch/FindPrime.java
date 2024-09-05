package ExhaustiveSearch;

public class FindPrime {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    boolean[] isVisited = new boolean[arr.length];
    int[] permutatedArr  = new int[arr.length];
    permutation(arr, isVisited, permutatedArr);
    System.out.println();

  }
  public int solution(String numbers) {
    int answer = 0;
    return answer;
  }

  private void permutation(int[] elements, boolean[] visitedArr ,int[] resultArr,int depth) {
    if (depth == elements.length - 1) {

    } else {

    }
  }
}
