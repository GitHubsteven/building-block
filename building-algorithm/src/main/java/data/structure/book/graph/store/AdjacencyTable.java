package data.structure.book.graph.store;

import algorithm.AdjArc;
import algorithm.AdjVertex;
import data.structure.book.graph.conduct.IGraphicOperation2;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 邻接表描述或存储图
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
            int fromIdx = vertices.indexOf(arc.getFrom());
            int toIdx = vertices.indexOf(arc.getTo());
            

        }


    }

    /**
     * 销毁树
     */
    @Override
    public void destroyGraph() {

    }

    /**
     * 定位顶点的位置，如果存在的话
     *
     * @param vertex 顶点
     * @return 坐标位置
     */
    @Override
    public int locateVex(AdjVertex<T> vertex) {
        return 0;
    }

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    @Override
    public AdjVertex<T> firstAdjVex(AdjVertex<T> vertex) {
        return null;
    }

    /**
     * 增加一个新的节点
     *
     * @param vertex 节点信息
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertVex(AdjVertex<T> vertex) {
        return false;
    }

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean deleteVex(AdjVertex<T> vertex) {
        return false;
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