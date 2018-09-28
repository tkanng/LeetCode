public class ForTest {


    public static void main(String[] args) {
        char[] chars = new char[3];
        chars[0] = '0';
        chars[1] = ' ';
        chars[2] = '2';
        System.out.println(String.valueOf(chars));
        new ForTest().foo(chars);
        System.out.println(String.valueOf(chars));
        new ForTest().foo2(chars);
        System.out.println(String.valueOf(chars));

    }

    // chars = new char [] {'0', ' ', '2'};
    void foo(char[] chars) {
        chars[1] = '1';  // chars变为{'0','1','2'}
    }

    void foo2(char[] chars) {
        chars = null; // chars不变
    }


}
