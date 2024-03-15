import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {
      List<Integer> ls = new ArrayList<>();
      Random rm = new Random();
      int size = 10_000;
      for(int i=1; i<=size; i++){
        ls.add(rm.nextInt(100));
      }
      long startseq = System.currentTimeMillis();
      int sum = ls.stream().map(i -> i+2).mapToInt(i -> i).sum();
      System.out.println(sum);
      long endSeq = System.currentTimeMillis();
      System.out.println("Time Taken for seq"+(endSeq-startseq));

      long startPara = System.currentTimeMillis();
      int paraSum = ls.parallelStream().map(i -> i+2).mapToInt(i -> i).sum();
      System.out.println(paraSum);
      long endPara = System.currentTimeMillis();
      System.out.println("Time Taken for para"+(endPara-startPara));


      List<String> allName = Arrays.asList("mue","mugi");

      String output = allName.stream()
                        .filter(n -> n.contains("k"))
                        .findFirst().orElse("Loser");

      System.out.println("output::"+output);
    }
}