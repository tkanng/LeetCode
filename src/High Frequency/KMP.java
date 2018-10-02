import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        System.out.println(KMPMatch("", "pattern"));
        System.out.println(Arrays.toString(getNext("aacaacbbcbadaabcacbd")));
        System.out.println(KMPAllMatch("pppppppppppppppp", "p"));
    }

    public static int[] getNext(String ps) {
        /*
        "前缀"和"后缀"。 "前缀"指除了最后一个字符以外，一个字符串的全部头部组合；"后缀"指除了第一个字符以外，一个字符串的全部尾部组合。
        "部分匹配值"就是"前缀"和"后缀"的最长(最长！)的共有元素的长度。
        http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
         */
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1; // next 数组只有next[0]是-1
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int KMPMatch(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(ps); // 这里的next数组可以通过参数传进来。
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                // 当j为-1时(比如，t中字符串不匹配p[0]，那么j就会置为-1,此时需要移动i，并且将j置为0)，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static ArrayList<Integer> KMPAllMatch(String ts, String ps) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] next = getNext(ps);
        KMPAllMatch(ts, ps, 0, res, next);
        return res;
    }

    private static void KMPAllMatch(String ts, String ps, int start, ArrayList<Integer> res, int[] next) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = start; // 主串的位置
        int j = 0; // 模式串的位置
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            res.add(i - j); // 字符串ts中i-j开始匹配ps
            KMPAllMatch(ts, ps, i - j + 1, res, next); // 递归，寻找下一个index
        }
    }
}
