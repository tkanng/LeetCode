import java.util.Stack;

public class HanoiTower {
    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
        doTowersNoRecursive(nDisks);
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from "
                    + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk "
                    + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    //  非递归实现
    public static void doTowersNoRecursive(int diskNum) {
        Stack<Disk> stack = new Stack<>();
        stack.push(new Disk(diskNum, 'A', 'B', 'C'));
        while (!stack.isEmpty()) {
            Disk popDisk = stack.pop();
            if (popDisk.status == 1) {
                System.out.println(popDisk.A + " -> " + popDisk.C);
            } else {
                // 反顺序添加
                // 将执行移动 popDisk 的下一步的Disk添加到Stack
                stack.push(new Disk(popDisk.status - 1, popDisk.B, popDisk.A,
                        popDisk.C));
                // 将一个status为 "1" 且移动顺序与 popDisk 相同的Disk 添加到Stack中
                stack.push(new Disk(1, popDisk.A, popDisk.B, popDisk.C));
                // 将执行移动 popDisk 的前一步的Disk添加到Stack中
                stack.push(new Disk(popDisk.status - 1, popDisk.A, popDisk.C,
                        popDisk.B));
            }
        }
    }


}

class Disk {

    int status;
    char A, B, C;

    public Disk(int status, char from, char inter, char to) {
        this.status = status;
        this.A = from;
        this.B = inter;
        this.C = to;
    }

}