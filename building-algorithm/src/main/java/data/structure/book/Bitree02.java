package data.structure.book;

public class Bitree02 {
    class BiTreeArray {
        int MAX_SIZE = 16;
        int[] treeData = new int[MAX_SIZE];
        int[] rightNode = new int[MAX_SIZE];
        int[] leftNode = new int[MAX_SIZE];

        public BiTreeArray() {
            for (int i = 0; i < MAX_SIZE; i++) {
                rightNode[i] = -1;
                leftNode[i] = -1;
            }
        }

        //建立二叉树
        public void create(int data) {
            int level = 0;//树的层数
            int position = 0;
            int i;
            //坦白来说，我并没有看懂为什么要这样写！
            for (i = 0; treeData[i] != 0; i++) {
                treeData[i] = data;
            }
            //寻找节点的位置
            while (true) {
                //判断是左子树还是有字数
                if (data > treeData[level]) {
                    //右子树是否有下一层
                    if (rightNode[level] != -1) {
                        //没有下一层
                        level = rightNode[level];
                    } else {
                        position = -1;  //设置为右子树
                        break;
                    }
                } else {
                    //左子树是否有下一层
                    if (leftNode[level] != -1) {
                        level = leftNode[level];
                    } else {
                        position = 1; //设置为左子树
                        break;
                    }
                }
            }
            if (position == 1) {
                leftNode[level] = i;
            } else {
                rightNode[level] = i;
            }
        }

    }
}
