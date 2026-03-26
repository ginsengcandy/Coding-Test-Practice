import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int k, int m, int[] score) {
        if (score.length < m) {
            return 0;
        }
        int numSaleApple = m * (score.length / m);
        List<Integer> collect = Arrays.stream(score)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(numSaleApple)
                .collect(Collectors.toList());
        return IntStream.range(0, collect.size())
                .filter(i -> i % m == m - 1)
                .map(collect::get)
                .reduce(Integer::sum)
                .getAsInt() * m;
    }
}