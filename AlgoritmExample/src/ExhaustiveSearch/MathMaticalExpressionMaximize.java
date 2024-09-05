package ExhaustiveSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MathMaticalExpressionMaximize {
  //해당 문제 파악 위해서 해설 보고 품
  public static void main(String[] args) {
    String exp = "100-200*300-500+20";
    solution(exp);
  }

  private static long solution(String expressions) {
    StringTokenizer tokenizer = new StringTokenizer(expressions, "+-*", true);
    List<String> tokens = new ArrayList<>();
    while (tokenizer.hasMoreTokens()) {
      tokens.add(tokenizer.nextToken());
    }
    System.out.println("tokens" + tokens );
    long result = 0;
    for (String[] precedence : precedences) {
      List<String > clonedTokens = new ArrayList<>(tokens);
      result = Math.max(result,Math.abs(calcucate(clonedTokens, precedence)));
    }

    return result;
  }

  private static final String[][] precedences = {
      "+-*".split(""),
      "+*-".split(""),
      "-+*".split(""),
      "-*+".split(""),
      "*+-".split(""),
      "*-+".split(""),
  };

  private static long calculate(long lhs, long rhs, String op) {
    return switch (op) {
      case "+" -> lhs + rhs;
      case "-" -> lhs - rhs;
      case "*" -> lhs * rhs;
      default -> 0;
    };
  }

  private static long calcucate(List<String> tokens, String[] precedence) {
    long result = 0;
    for (String op : precedence) {
      for (int i = 0; i < tokens.size(); i++) {
        if (tokens.get(i).equals(op)) {
          long lhs = Long.parseLong(tokens.get(i - 1));
          long rhs = Long.parseLong(tokens.get(i + 1));
          tokens.remove(i - 1);
          tokens.remove(i - 1);
          tokens.remove(i - 1);
           result = calculate(lhs, rhs, op);
          tokens.add(i - 1, String.valueOf(result));
          i--;
        }
      }
    }
    return result;
  }
}
