package Queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列======================>");
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' ';     //接收用户输入
        Scanner scanner = new Scanner(System.in);
        //输出一个菜单
        printMenu();
        while(key != 'e') {
            System.out.print("请输入你的选择：");
            key = scanner.next().charAt(0);
            switch(key) {
                case 's':
                    circleArrayQueue.showCircleArrayQueue();
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("成功退出程序");
                    break;  //return; 也行
                case 'a':
                    if(circleArrayQueue.isFull()) {
                        System.out.println("队列已满，不能加入数据");
                    } else {
                        System.out.print("请输入一个数字：");
                        int addValue = scanner.nextInt();
                        circleArrayQueue.addCircleArrayQueue(addValue);
                    }
                    break;
                case 'g':
                    try {
                        int getValue = circleArrayQueue.getCircleArrayQueue();
                        System.out.println("取出的数据是" + getValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int getValue = circleArrayQueue.headCircleArrayQueue();
                        System.out.println("头数据是" + getValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请输入正确的选项！");
            }
        }
    }
    //显示用户选项
    public static void printMenu() {
        System.out.println("s(show)：显示队列");
        System.out.println("e(exit)：退出程序");
        System.out.println("a(add)：添加数据到队列");
        System.out.println("g(get)：从队列取出数据");
        System.out.println("h(head)；查看队列头的数据");
        System.out.println();
    }
}
//使用数组模拟一个环形队列，环形队列的最大存储空间为: maxSize - 1
class CircleArrayQueue {
    private int maxSize;    //表示数组的最大容量，默认值为10
    private int front;      //队列头，指向环形队列的头节点，默认值为0
    private int rear;       //队列尾，指向环形对立的尾节点的下一个节点，默认值为0
    private int[] arr;      //用数组模拟环形队列
    public CircleArrayQueue() {
        this.maxSize = 10;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }
    public int getMaxSize() {
        return maxSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public int getFront() {
        return front;
    }
    public void setFront(int front) {
        this.front = front;
    }
    public int getRear() {
        return rear;
    }
    public void setRear(int rear) {
        this.rear = rear;
    }
    public int[] getArr() {
        return arr;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到环形队列
     * @param data  添加的数据
     */
    public void addCircleArrayQueue(int data) {
        if(isFull()) {
            System.out.println("队列已满，不能加入数据!");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出环形队列的头数据
     * @return  返回头数据
     */
    public int getCircleArrayQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据!");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    //队列中有效数据的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示环形队列的有效数据
     */
    public void showCircleArrayQueue() {
        if(isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        System.out.println("队列中的数据为：");
        for(int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    public int headCircleArrayQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        return arr[front];
    }
}
