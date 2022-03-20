package Queue;

import java.util.Scanner;

//测试程序
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';     //接收用户输入
        Scanner scanner = new Scanner(System.in);
        //输出一个菜单
        printMenu();
        while(key != 'e') {
            System.out.print("请输入你的选择：");
            key = scanner.next().charAt(0);
            switch(key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    System.out.println("成功退出程序");
                    break;
                case 'a':
                    if(arrayQueue.isFull()) {
                        System.out.println("队列已满，不能加入数据");
                    } else {
                        System.out.print("请输入一个数字：");
                        int addValue = scanner.nextInt();
                        arrayQueue.addQueue(addValue);
                    }
                    break;
                case 'g':
                    try {
                        int getValue = arrayQueue.getQueue();
                        System.out.println("取出的数据是" + getValue);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int getValue = arrayQueue.headQueue();
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

//使用数组模拟队列编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; //表示数组的最大容量，默认最大容量为10
    private int front;  //队列头，指向队列头部的前一个位置，默认值为-1
    private int rear;   //队列尾，指向队列尾部，就是队列最后的一个数据，默认值为-1
    private int[] arr;  //数组模拟队列
    public ArrayQueue() {
        this.maxSize = 10;
        this.arr = new int[10];
        this.front = -1;
        this.rear = -1;
    }
    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }
    //Getter and Setter
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
        return rear == maxSize -1;  //并不表示队列真的满了，只是代表数据不能直接插入到队列尾部
        //return (rear - front) == maxSize;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }
    /**
     * 添加数据到队列
     * @param data 加入队列的数据
     */
    public void addQueue(int data) {
        if(isFull()) {
            System.out.println("队列已满，不能加入数据！");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    /**
     * 获取出对列的数据
     * @return 抛出异常或返回数据
     */
    public int getQueue() {
        if(isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        System.out.println("队列中的数据为：");
        for(int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 返回队列的头结点数据
     * @return 头结点数据
     */
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arr[front + 1];
    }
}
