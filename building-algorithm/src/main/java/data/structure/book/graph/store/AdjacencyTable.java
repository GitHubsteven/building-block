package data.structure.book.graph.store;

import algorithm.AdjArc;
import algorithm.AdjLinkNode;
import algorithm.AdjVertex;
import data.structure.book.graph.conduct.IGraphicOperation2;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 邻接表描述或存储图，其实我不明白为什么要用索引来描述，直接描述不行吗？索引一旦改变，这个邻接表几乎都要被改变
 * 这是非常繁琐和不合理的，这只是一个疑问而已
 * @Date: Created at 16:20 2019/3/22.
 */
public class AdjacencyTable<T extends Comparable<T>> implements IGraphicOperation2<AdjVertex<T>, AdjArc<T>> {
    /**
     * 顶点集合
     */
    private List<AdjVertex<T>> vertices;

    /**
     * 是否有向图
     */
    private boolean isDirected;

    /**
     * 是否为带权图
     */
    private boolean isWithWeight;

    /**
     * 生成图
     *
     * @param vertices     顶点
     * @param arcs         弧
     * @param isDirected   是否为有向图
     * @param isWithWeight 是否带有权值
     */
    @Override
    public void createGraph(List<AdjVertex<T>> vertices, List<AdjArc<T>> arcs, boolean isDirected, boolean isWithWeight) {
        //在描述图的过程就是在不停的补充顶点的信息
        this.vertices = vertices;
        this.isWithWeight = isWithWeight;
        this.isDirected = isDirected;

        //遍历弧，初始化邻接表
        for (AdjArc<T> arc : arcs) {
            int fromIdx = indexByValue(this.vertices, arc.getFrom());
            int toIdx = indexByValue(this.vertices, arc.getTo());
            //为from创建一个链接对象
            addAdjVerNode(arc.getWeight(), fromIdx, toIdx);
            //如果不是有向图的话，那么同时在目的顶点的旁边及单链表也加入连接点
            if (!isDirected) addAdjVerNode(arc.getWeight(), toIdx, fromIdx);
        }
    }

    /**
     * 往顶点中插入连接点
     *
     * @param weight  权重
     * @param fromIdx 起点索引
     * @param toIdx   终点索引
     */
    private void addAdjVerNode(BigDecimal weight, int fromIdx, int toIdx) {
        AdjVertex<T> vertex = this.vertices.get(fromIdx);
        AdjLinkNode<T> firstEdge = vertex.getFirstEdge();
        AdjLinkNode<T> toAdj = new AdjLinkNode<>();
        toAdj.setVerIdx(toIdx);
        if (this.isWithWeight) toAdj.setWeight(weight);
        if (firstEdge == null) {
            vertex.setFirstEdge(toAdj);
        } else {
            insert2Link(firstEdge, toAdj);
        }
    }

    /**
     * 往链表插入对象
     *
     * @param head       头结点
     * @param insertNode 待插入的节点
     * @return 结果，true表示成功，false表示失败
     */
    private boolean insert2Link(AdjLinkNode<T> head, AdjLinkNode<T> insertNode) {
        if (head == null) {
            return true;
        }
        //找到最后一个节点
        AdjLinkNode<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(insertNode);
        return true;
    }


    /**
     * 不重写hashcode+ equals，因为适用范围小
     *
     * @param vertices 链接表的顶点
     * @param vertex   待检测的对象
     * @return 在顶点集合的索引
     */
    int indexByValue(List<AdjVertex<T>> vertices, AdjVertex<T> vertex) {
        for (int i = 0; i < vertices.size(); i++) {
            AdjVertex<T> item = vertices.get(i);
            if (vertex.getValue().compareTo(item.getValue()) == 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 销毁树
     */
    @Override
    public void destroyGraph() {
        this.vertices = null;
        this.isWithWeight = false;
        this.isDirected = false;
    }

    /**
     * 定位顶点的位置，如果存在的话
     *
     * @param vertex 顶点
     * @return 坐标位置
     */
    @Override
    public int locateVex(AdjVertex<T> vertex) {
        return indexByValue(this.vertices, vertex);
    }

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    @Override
    public AdjVertex<T> firstAdjVex(AdjVertex<T> vertex) {
        AdjLinkNode<T> firstEdge = vertex.getFirstEdge();
        if (firstEdge == null) return null;
        return this.vertices.get(firstEdge.getVerIdx());
    }

    /**
     * 增加一个新的节点
     *
     * @param vertex 节点信息
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertVex(AdjVertex<T> vertex) {
        return this.vertices.add(vertex);
    }

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean deleteVex(AdjVertex<T> vertex) {
        /*
        1. 删除和vertex相关的idx
        2. 修改链接点的索引
         */
        int index = locateVex(vertex);
        for (int idx = 0; idx < this.vertices.size(); idx++) {
            AdjLinkNode<T> firstEdge = vertex.getFirstEdge();
            if (firstEdge != null) {
                //如果相邻链表不为空，那么就做如下处理
                AdjLinkNode<T> delNode = new AdjLinkNode<T>();
                delNode.setVerIdx(index);
                whenDelNode(firstEdge, delNode);
            }
        }
        return false;
    }

    /**
     * 删除链表节点
     *
     * @param head    链表头
     * @param delNode 待删除的链表
     */
    private void whenDelNode(AdjLinkNode<T> head, AdjLinkNode<T> delNode) {
        if (head == null) return;
        //保存头结点
        AdjLinkNode<T> tmp = head;
        AdjLinkNode<T> pre = head;
        int delIdx = delNode.getVerIdx();
        do {
            int curVerIdx = tmp.getVerIdx();
            if (curVerIdx == delIdx) {
                //判断是否为头结点，如果是的话，那么同时会改变头结点
                if (head.getVerIdx() == delIdx) {
                    head = tmp.getNext();
                    pre = tmp.getNext();
                } else {
                    pre.setNext(tmp.getNext());
                }
            } else if (curVerIdx > delIdx) {
                //如果顶点索引大于被删顶点索引的话，那么就-1
                tmp.setVerIdx(curVerIdx - 1);
            } else {
                //如果是小于的话，那么不做处理
                pre = tmp;
            }
            tmp = tmp.getNext();
        } while (tmp.getNext() != null);
    }


    /**
     * 插入弧
     *
     * @param arc 弧
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertArc(AdjArc<T> arc) {
        return false;
    }

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertex 顶点
     * @return 连接点集合
     */
    @Override
    public List<AdjVertex<T>> listAdjVerByIdx(AdjVertex<T> vertex) {
        return null;
    }

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertexIdx 顶点的索引
     * @return 连接点集合
     */
    @Override
    public List<AdjVertex<T>> listAdjVerByIdx(int vertexIdx) {
        return null;
    }

    /**
     * 获取顶点的弧
     *
     * @param vertex 顶点
     * @return 顶点弧的集合
     */
    @Override
    public List<AdjArc<T>> listVerArcs(AdjVertex<T> vertex) {
        return null;
    }

    /**
     * 通过顶点的索引获取顶点的弧
     *
     * @param vertexIdx 顶点的索引
     * @return 顶点弧的集合
     */
    @Override
    public List<AdjArc<T>> listVerArcs(int vertexIdx) {
        return null;
    }

    /**
     * @param arc 弧
     * @return 是否删除成功
     */
    @Override
    public boolean deleteArc(AdjArc<T> arc) {
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @return 遍历的节点
     */
    @Override
    public List<AdjVertex<T>> DFSTraverse() {
        return null;
    }

    /**
     * 广度优先遍历
     *
     * @return 遍历的节点
     */
    @Override
    public List<AdjVertex<T>> HFSTraverse() {
        return null;
    }
}