package Queue;

public class ArrayQueueDemo {
}

//使用数组模拟队列编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front;  //队列头，指向队列头部的前一个位置
    private int rear;   //队列尾，指向队列尾部，就是队列最后的一个数据
    private int[] arr;  //数组模拟队列
    //默认最大容量为10
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
        System.out.println("队列中的数据为：");
        for(int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
