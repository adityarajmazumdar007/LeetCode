/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int res=n;
        int lo = 1, hi = n, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)){hi=mid-1;res=mid;}
            else lo = mid+1;
        }
        return res;
    }
}