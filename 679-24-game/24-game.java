
public class Solution {

    public boolean judgePoint24(int[] cards) {
        List<Double> arr = new ArrayList<>();
        for (int card : cards) {
            arr.add((double) card);
        }
        return isPossible(arr);
    }

    private boolean isPossible(List<Double> arr) {
        int n = arr.size();
        if (n == 1) {
            return Math.abs(24.0 - arr.get(0)) <= 1e-6;
        }

        for (int fn = 0; fn < n; fn++) {
            for (int sn = 0; sn < n; sn++) {
                if (sn == fn) continue;

                double firstNumber = arr.get(fn);
                double secondNumber = arr.get(sn);
                List<Double> validOperations = getValidOperations(firstNumber, secondNumber);

                for (double validOperation : validOperations) {
                    List<Double> nextArr = new ArrayList<>();
                    nextArr.add(validOperation);

                    for (int i = 0; i < n; i++) {
                        if (i == fn || i == sn) continue;
                        nextArr.add(arr.get(i));
                    }

                    if (isPossible(nextArr)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> getValidOperations(double a, double b) {
        List<Double> validOperations = new ArrayList<>();
        validOperations.add(a + b);
        validOperations.add(a * b);
        validOperations.add(a - b);
        validOperations.add(b - a);

        if (Math.abs(b) > 1e-6)
            validOperations.add(a / b);
        if (Math.abs(a) > 1e-6)
            validOperations.add(b / a);

        return validOperations;
    }
}
