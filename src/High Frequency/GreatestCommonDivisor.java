public class GreatestCommonDivisor {

    // m  = nq + r ==> gcd(m,n)==gcd(n, r)

    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
