public class CodeRunOrder {
    /**
     * 构造代码
     */
    /**
     * 无参构造函数
     */
    public CodeRunOrder() {
        System.out.println("执行无参构造函数...");
    }

    /**
     * 有参构造函数
     *
     * @param id id
     */
    public CodeRunOrder(String id) {
        System.out.println("执行有参构造函数...");
    }

    {
        System.out.println("执行构造代码块...");
    }

    public static void main(String[] args) {
        new CodeRunOrder();
        System.out.println("----------------");
        new CodeRunOrder("1");
    }


}