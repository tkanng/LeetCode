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
        int t =1;

        Integer i = 1;
        System.out.println(i);
        new ForTest().foo3(i);
        System.out.println(i);


    }

    // chars = new char [] {'0', ' ', '2'};
    void foo(char[] chars) {
        chars[1] = '1';  // chars变为{'0','1','2'}
    }

    void foo2(char[] chars) {
        chars = null; // chars不变
    }

    void foo3(Integer i){
        i=100;
    }
}
