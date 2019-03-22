package data.structure.book.graph.store;

import bean.GraphicArc;
import bean.GraphicVertex;
import data.structure.book.graph.conduct.IGraphicOperation;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:20 2019/3/22.
 */
public class AdajacencyTable<T extends Comparable<T>> implements IGraphicOperation<T> {
    /**
     * 生成图
     *
     * @param graphicVertices 顶点
     * @param graphicArcs     弧
     * @param isDirected      是否为有向图
     * @param isWithWeight    是否带有权值
     */
    @Override
    public void createGraph(List<GraphicVertex<T>> graphicVertices, List<GraphicArc<T>> graphicArcs, boolean isDirected, boolean isWithWeight) {

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
    public int locateVex(GraphicVertex<T> vertex) {
        return 0;
    }

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    @Override
    public GraphicVertex<T> firstAdjVex(GraphicVertex<T> vertex) {
        return null;
    }

    /**
     * 增加一个新的节点
     *
     * @param vertex 节点信息
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertVex(GraphicVertex<T> vertex) {
        return false;
    }

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean deleteVex(GraphicVertex<T> vertex) {
        return false;
    }

    /**
     * 插入弧
     *
     * @param arc 弧
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertArc(GraphicArc<T> arc) {
        return false;
    }

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertex 顶点
     * @return 连接点集合
     */
    @Override
    public List<GraphicVertex<T>> listAdjVerByIdx(GraphicVertex<T> vertex) {
        return null;
    }

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertexIdx 顶点的索引
     * @return 连接点集合
     */
    @Override
    public List<GraphicVertex<T>> listAdjVerByIdx(int vertexIdx) {
        return null;
    }

    /**
     * 获取顶点的弧
     *
     * @param vertex 顶点
     * @return 顶点弧的集合
     */
    @Override
    public List<GraphicArc<T>> listVerArcs(GraphicVertex<T> vertex) {
        return null;
    }

    /**
     * 通过顶点的索引获取顶点的弧
     *
     * @param vertexIdx 顶点的索引
     * @return 顶点弧的集合
     */
    @Override
    public List<GraphicArc<T>> listVerArcs(int vertexIdx) {
        return null;
    }

    /**
     * @param arc 弧
     * @return 是否删除成功
     */
    @Override
    public boolean deleteArc(GraphicArc<T> arc) {
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @return 遍历的节点
     */
    @Override
    public List<GraphicVertex<T>> DFSTraverse() {
        return null;
    }

    /**
     * 广度优先遍历
     *
     * @return 遍历的节点
     */
    @Override
    public List<GraphicVertex<T>> HFSTraverse() {
        return null;
    }
}