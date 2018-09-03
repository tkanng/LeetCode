import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PermGenOomMock {
    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("D:\\Nutstore\\projects\\Java_\\LeetCode\\src\\GeekTime").toURI().toURL();
            URL[] urls = {url};
            ClassLoader loader1 = new URLClassLoader(urls);
            classLoaderList.add(loader1);
            Class<?> obj1 = loader1.loadClass("MyDynamicProxy");
            ClassLoader loader2 = new URLClassLoader(urls);
            classLoaderList.add(loader2);
            Class<?> obj2 =loader2.loadClass("MyDynamicProxy");
            System.out.println(obj1.hashCode());
            System.out.println(obj2.hashCode());
            System.out.println(PermGenOomMock.class.getClassLoader().loadClass("MyDynamicProxy").hashCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}