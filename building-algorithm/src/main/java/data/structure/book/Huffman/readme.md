**哈夫曼树，最优二叉树**
n个的带权重的节点集合C(n)，组成n个独根的组数T(n),构成一个有N个叶子节点的二叉树，设每个叶子节点权重为Wk，路径为Lk,
树的带权路径为 WPL=Sum(路径*叶子节点权重）最小的数被称为huffman树(最优二叉树)

**哈夫曼树的建立**
前提条件：数据集合C(n)

1. 找出给定值集合C(n)中两个权重最小(least,secLeast)的，新建父节vir_parent点，权重为两者之和，小的为左孩子，大的为右孩子

2. 从C(n)中删除 least,secLeast;

3. vir_parent节点增加到C(n)

循环到C(n)的size 为1；

Huffman树的应用，编码和解码的优化，参考HFMEncode类测试case