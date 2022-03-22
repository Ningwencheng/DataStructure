package SparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组，大小为11×11
        //0：表示没有棋子，1：表示黑子，2：表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        printArray(chessArr1);
        //将二维数组转成稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        /* 第一种遍历方式
        for (int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0)
                    sum++;
            }
        }
        */
        // 第二种遍历方式
        for(int[] row : chessArr1) {
            for(int data : row) {
                if(data != 0) {
                    sum++;
                }
            }
        }
        //sum即为非0数据的个数
        //System.out.println(sum);
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;  //用于记录是第几个非0数据
        for(int i = 0; i < chessArr1.length; i++) {
            for(int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0)
                {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println("得到的稀疏数组为：");
        printArray(sparseArr);

        //  序列化(Serialize)
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("map.data"));
            oos.writeObject(sparseArr);
            oos.flush();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //  反序列化(deserialize)
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("map.data"));
            int[][] sparseArr1 = (int[][])ois.readObject();
            //将稀疏数组恢复成原始的二维数组
            //1.先读取稀疏数组的第一行，根据第一行的数组，创建原始的二维数组
            int[][] chessArr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
            //2.读取稀疏数组后几行的数据，并赋给二维数组
            for(int i = 1; i < sparseArr1.length; i++) {
                chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
            }
            //输出恢复后的二维数组
            System.out.println("恢复后的二维数组为：");
            printArray(chessArr2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印二维数组
     * @param arr 二维数组
     */
    public static void printArray(int[][] arr) {
        //foreach循环输出
        for(int[] row : arr) {
            for(int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}