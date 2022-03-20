package Queue;

public class CircleArrayQueueDemo {

}

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
}
