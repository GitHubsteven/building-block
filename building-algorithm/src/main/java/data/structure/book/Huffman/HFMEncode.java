package data.structure.book.Huffman;

import bean.HFMEnCodeNode;

import java.math.BigDecimal;
import java.util.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:36 2019/3/14.
 */
public class HFMEncode {
    private final static char TURN_LEFT = '0';
    private final static char TURN_RIGHT = '1';
    private final static String ABSTRACT_NODE = "#";


    public static <T extends Comparable<T>> HFMEnCodeNode<T> construct(List<HFMEnCodeNode<T>> values, T tmp) {
        //先排序,请输入size >2的集合
        values.sort(Comparator.comparing(HFMEnCodeNode::getWeight));
        HFMEnCodeNode<T> least;
        HFMEnCodeNode<T> secLeast;
        //设置一个指向哈夫曼二叉树根节点的指针
        HFMEnCodeNode<T> root = null;
        //1.合并这两个节点，创建新的节点，2.从集合中删除least和secLeast 3.往values中增加新添加的节点
        while (values.size() > 1 && (least = values.get(0)) != null && (secLeast = values.get(1)) != null) {
            HFMEnCodeNode<T> node = new HFMEnCodeNode<>(tmp, least.getWeight().add(secLeast.getWeight()));
            node.setLeft(least);
            node.setRight(secLeast);
            //删除两个节点
            values.remove(least);
            values.remove(secLeast);
            //添加新节点
            values.add(node);
            root = node;
            //重新排序（这里可以优化，但是，现在暂时不管）,重新获取最小，第二个最小的节点
            values.sort(Comparator.comparing(HFMEnCodeNode::getWeight));
        }
        return root;
    }


    /**
     * 给Huffman树编码
     *
     * @param root 树的根节点
     * @return 明文->密文
     */
    public static <T extends Comparable<T>> Map<String, String> createCode(HFMEnCodeNode<T> root) {
        //因为要计算路径，这里使用层次遍历，如果用其他的话应该也可以，但是暂时不管
        List<HFMEnCodeNode<T>> curNodes = new ArrayList<>();
        //第一次层为1，root层，根节点code为"",通常来说，非叶子节点并没有name,也就没什么意义。
        curNodes.add(root);
        root.setCode("");
        List<HFMEnCodeNode<T>> nodesTmp = new ArrayList<>();
        //编码方式，向左为0，向右为1
        Map<String, String> codeDir = new HashMap<>();
        while (!curNodes.isEmpty()) {
            //给root设置code，公式为：父类的code+ 左孩子?0 ：1
            for (HFMEnCodeNode<T> curNode : curNodes) {
                String parentCode = curNode.getCode();
                //如果是叶子节点，那么就直接放在字典中，并且跳出循环
                if (curNode.isLeaf()) {
                    codeDir.put(curNode.getElement().toString(), parentCode);
                    continue;
                }
                HFMEnCodeNode<T> left = (HFMEnCodeNode<T>) curNode.getLeft();
                if (left != null) {
                    left.setCode(parentCode + TURN_LEFT);
                    nodesTmp.add(left);
                }
                HFMEnCodeNode<T> right = (HFMEnCodeNode<T>) curNode.getRight();
                if (right != null) {
                    right.setCode(parentCode + TURN_RIGHT);
                    nodesTmp.add(right);
                }
            }
            //重置当前的节点集合
            curNodes = new ArrayList<>(nodesTmp);
            //清空交换区
            nodesTmp.clear();
        }
        return codeDir;
    }

    /**
     * 密文解码
     *
     * @param enCodedContext 被加密的文本
     * @param <T>            类型
     * @return 明文
     */
    public static <T extends Comparable<T>> String decode(String enCodedContext, HFMEnCodeNode<T> root) {
        char[] codes = enCodedContext.toCharArray();
        StringBuilder result = new StringBuilder();
        HFMEnCodeNode<T> curNode = root;
        //遍历完所有的码文
        for (int i = 0; i < codes.length; i++) {
            char code = codes[i];
            curNode = (HFMEnCodeNode<T>) (code == TURN_LEFT ? curNode.getLeft() : curNode.getRight());
            if (curNode.isLeaf()) {
                result.append(curNode.getElement().toString());
                //如果是叶子节点（数据），那么重新从头开始
                curNode = root;
            }
        }
        return result.toString();
    }


    /**
     * 给明文加密
     *
     * @param plainText 明文
     * @return 密文
     */
    public static String encode(String plainText, Map<String, String> dictionary) {
        if (dictionary == null || dictionary.isEmpty()) throw new IllegalArgumentException("字典不能为空！");
        StringBuilder result = new StringBuilder();
        for (char letter : plainText.toCharArray()) {
            result.append(dictionary.getOrDefault(String.valueOf(letter), "-"));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //数据分别为 A(27)，B（8），C(15),D(15），E(30),F(5)
        List<HFMEnCodeNode<String>> hfmEnCodeNodes = new ArrayList<>();
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("A", new BigDecimal("27")));
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("B", new BigDecimal("8")));
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("C", new BigDecimal("15")));
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("D", new BigDecimal("15")));
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("E", new BigDecimal("30")));
        hfmEnCodeNodes.add(new HFMEnCodeNode<>("F", new BigDecimal("5")));

        HFMEnCodeNode<String> hfmTree = construct(hfmEnCodeNodes, ABSTRACT_NODE);
        //生成编码，编码正常应该为：
        // A    B       C   D   E   F
        //01    1001    101 00  11  1000
        Map<String, String> codeDir = createCode(hfmTree);
        //输出编码
        codeDir.forEach((chara, code) -> System.out.println(String.format("character: %s <---> code: %s", chara, code)));
        String plainText = "ABDE";
        String cipherText = encode(plainText, codeDir);
        System.out.println(String.format("--------------plainText：[%s]，cipherText：%s", plainText, cipherText));
        //解码
        System.out.println(String.format("--------------plainText from cipherText[%s] is %s", cipherText, decode(cipherText, hfmTree)));
    }
}