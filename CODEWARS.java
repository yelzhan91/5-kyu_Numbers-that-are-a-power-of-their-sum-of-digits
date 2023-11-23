import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
public class CODEWARS {
    private static final int MAX_POWER = 50;
    private static final int MAX_NUMBER_TO_CHECK = 500;
    private static final List<Long> resultList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 1;
        long result = powerSumDigTerm(n);
        System.out.println(result);//81
        n = 2;
        result = powerSumDigTerm(n);
        System.out.println(result);//512
        n = 3;
        result = powerSumDigTerm(n);
        System.out.println(result);//2401
        n = 4;
        result = powerSumDigTerm(n);
        System.out.println(result);//4913
    }
    public static long powerSumDigTerm(int n) {
        if (resultList.size() < n) {
            for (int i = 2; i < MAX_NUMBER_TO_CHECK; i++) {
                for (int j = 2; j < MAX_POWER; j++) {
                    long product = (long) Math.pow(i, j);
                    if (sumOfDigits(product) == i) {
                        resultList.add(product);
                    }
                }
            }
            Collections.sort(resultList);
        }
        return resultList.get(n-1);
    }
    private static long sumOfDigits(long n) {
        return Stream.of(Long.toString(n).split(""))
                .mapToInt(x -> Integer.parseInt(x))
                .sum();
    }
}