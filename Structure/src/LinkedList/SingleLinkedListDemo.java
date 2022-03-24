package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //HeroNode newHeroNode = new HeroNode(4, "林冲====", "豹=子=头");

        //创建节点直接加入到尾部的单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.updateHeroNode(newHeroNode);
        //将节点加入链表中
        singleLinkedList.add(heroNode1);
        //singleLinkedList.updateHeroNode(newHeroNode);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode2);
        //singleLinkedList.updateHeroNode(newHeroNode);
        singleLinkedList.deleteHeroNode(3);
        singleLinkedList.deleteHeroNode(3);
        singleLinkedList.printSingleLinkedList();


        //创建节点按no顺序添加的单链表
        SingleLinkedList singleLinkedListByOrder = new SingleLinkedList();
        singleLinkedListByOrder.addByOrder(heroNode1);
        singleLinkedListByOrder.addByOrder(heroNode4);
        singleLinkedListByOrder.addByOrder(heroNode2);
        singleLinkedListByOrder.addByOrder(heroNode3);
        singleLinkedListByOrder.addByOrder(heroNode1);
        singleLinkedListByOrder.printSingleLinkedList();

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
     * 把新的节点按no的顺序加入到链表中
     * @param heroNode 新插入的节点
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        //为了找出插入节点的位置
        while(true) {
            if(temp.getNext() == null) {
                flag = true;
                break;
            }
            if(heroNode.getNo() == temp.getNext().getNo()) {
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.getNo());
                break;
                //throw new RuntimeException("将要插入的节点的no已存在，插入失败!");
            }
            /*  heroNode.getNo() > temp.getNo() && 不能加入判断条件，加入判断条件的可能会倒是no比
             *  头结点小的节点插入到链表的尾部
             */
            if(heroNode.getNo() < temp.getNext().getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        //插入节点 flag == true
        if(flag) {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }
    /**
     * 打印输出单链表
     */
    public void printSingleLinkedList() {
        HeroNode temp = head;
        while(temp.getNext() != null) {
            System.out.println(temp.getNext());
            temp = temp.getNext();
        }
        if(temp == head) {
            System.out.println("单链表为空，头结点后没有节点!");
        }
        System.out.println();
    }

    /**
     * 根据no修改节点的信息
     * @param newHeroNode 用此节点的信息修改
     */
    public void updateHeroNode(HeroNode newHeroNode) {
        //判断链表是否为空
        if(head.getNext() == null) {
            System.out.println("链表为空，无法修改!");
            return;
        }
        HeroNode temp = head.getNext();
        boolean flag = false;   //true表示找到了相同no的节点
        while(temp != null) {
            if(temp.getNo() == newHeroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if(flag) {
            temp.setName(newHeroNode.getName());
            temp.setNickname(newHeroNode.getNickname());
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.getNo());
        }
    }

    /**
     * 删除指定的节点
     * @param no  根据no删除节点
     */
    public void deleteHeroNode(int no) {
        if(head.getNext() == null) {
            System.out.println("链表为空，无法删除节点！");
            return;
        }
        HeroNode temp = head;
        while(temp.getNext() != null) {
            if(temp.getNext().getNo() == no) {
                // 删除目标节点
                temp.setNext(temp.getNext().getNext());
                System.out.printf("%d节点已经成功删除！\n",no);
                return;
            }
            temp = temp.getNext();
        }
        System.out.printf("要删除的 %d 节点不存在\n", no);
    }
}