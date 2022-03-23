package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //将节点加入链表中
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.printSingleLinkedList();
    }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    private int no;
    private String name;
    private String nickname;    //昵称
    private HeroNode next;      //指向下一个节点
    public HeroNode() {
    }
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public HeroNode getNext() {
        return next;
    }
    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

//定义 SingleLinkedList(带头节点的单链表) 实现一些功能
class SingleLinkedList {
    //先初始化一个头结点
    private HeroNode head = new HeroNode(0,null,null);
    //返回头结点
    public HeroNode getHead() {
        return this.head;
    }

    /**
     * 得到单链表的最后一个节点
     * @return  单链表的最后一个节点
     */
    public HeroNode getEndHeroNode() {
        HeroNode temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 把新的节点加入到链表最后 (不考虑编号no的顺序)
     * @param heroNode 新加入的节点
     */
    public void add(HeroNode heroNode) {
        HeroNode endHeroNode = this.getEndHeroNode();
        endHeroNode.setNext(heroNode);
        //其实可以不写，heroNode.next默认为null
        heroNode.setNext(null);
    }

    /**
     * 打印输出单链表
     */
    public void printSingleLinkedList() {
        HeroNode temp = head;
        while(temp.getNext() != null) {
            System.out.println(temp.getNext().toString());
            temp = temp.getNext();
        }
        if(temp == head) {
            System.out.println("单链表为空，头结点后没有节点!");
        }
        System.out.println();
    }
}