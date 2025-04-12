class Solution {
    public static long[] factorial = new long[11];
    public static boolean isFirstTestCase = true;
    public static long[][] cache = new long[11][10];
    public long countGoodIntegers(int n, int k) {
        if(isFirstTestCase){
            computeFactorial();
            for(long[] c : cache)Arrays.fill(c,-1);
            isFirstTestCase = false;
        }

        if(cache[n][k] != -1)return cache[n][k];

        Set<String> vis = new HashSet<>();
        char[] temp = new char[n];
        return cache[n][k] = countAnswer(0,(n % 2 == 0) ? (n/2) - 1 : n/2,n, k,temp ,vis);
    }

    public long countAnswer(int pos, int end, int n, int k ,char[] temp, Set<String> vis){
        if(pos == end + 1){
            char[] copy = temp.clone();
            Arrays.sort(copy);
            String key = new String(copy);
            if(!vis.contains(key)){
                long num = charToInt(temp);
                if(num % k == 0){
                    long count = totalPermutation(temp);
                    vis.add(key);
                    return count;
                }
            }
            return 0;
        }

        long count = 0;
        char start = pos == 0 ? '1': '0';
        for(char digit = start; digit <= '9'; digit++){
            temp[pos] = digit;
            temp[n - pos - 1] = digit;
            count += countAnswer(pos + 1,end, n, k , temp, vis);
        }
        return count;
    }

    public long charToInt(char[] temp){
        long ans = 0;
        for(char d : temp){
            ans = (ans * 10) + (d - '0');
        }
        return ans;
    }

    public long totalPermutation(char[] temp){
        int[] freq = new int[10];
        for(char d : temp){
            freq[d - '0']++;
        }

        long valid = factorial[temp.length];
        for(int f : freq){
            valid /= factorial[f];
        }

        return freq[0] == 0 ? valid : valid - findInvalid(temp.length - 1,freq);
    }

    public long findInvalid(int n , int[] freq){
        long invalid = factorial[n];
        freq[0]--;
        for(int f : freq){
            invalid /= factorial[f];
        }
        return invalid;
    }

    public void computeFactorial(){
        factorial[0] = 1;
        for(int i = 1; i <= 10; i++){
            factorial[i] = factorial[i - 1] * i;
        }
    }
}