import java.util.HashMap;
import java.util.Map;

public class ChangeKeyInHashMap {

    public static void main(String[] args) {
        Map<Person, Integer> map = new HashMap<Person, Integer>();
        Person p = new Person("zhangsan", 12);

        map.put(p, 1);
        p.setName("lisi"); // 因为p.name参与了hash值的计算，修改了之后hash值发生了变化，所以下面删除不掉
        map.remove(p);

        System.out.println(map.size());
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()   +  "==>" + entry.getValue());
        }
        System.out.println(map.get(p));
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return name.hashCode() * 123;
        }

        @Override
        public String toString() {
            return "name: " +name + " age:" + age;
        }
    }
}



