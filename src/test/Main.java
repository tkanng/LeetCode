import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        System.out.println(a.getClass() == b.getClass());
        System.out.println(a.getClass().getClassLoader());

    }
}
