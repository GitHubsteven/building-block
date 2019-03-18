package data.structure.book.graph.conduct;

import bean.GraphicArc;
import bean.GraphicVertex;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 定义树的行为
 * @Date: Created at 12:03 2019/3/18.
 */
public interface IGraphicOperation<T extends Comparable<T>> {
    /**
     * 生成图
     *
     * @param vertices     顶点
     * @param arcs         弧
     * @param isDirected   是否为有向图
     * @param isWithWeight 是否带有权值
     */
    void createGraph(List<GraphicVertex<T>> vertices, List<GraphicArc<T>> arcs, boolean isDirected, boolean isWithWeight);

    /**
     * 销毁树
     */
    void destroyGraph();

    /**
     * 定位顶点的位置，如果存在的话
     *
     * @param vertex 顶点
     * @return 坐标位置
     */
    int locateVex(GraphicVertex<T> vertex);

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    GraphicVertex<T> firstAdjVex(GraphicVertex<T> vertex);

    /**
     * 增加一个新的节点
     *
     * @param vertex 节点信息
     * @return 成功返回true， 是否返回false
     */
    boolean insertVex(GraphicVertex<T> vertex);

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    boolean deleteVex(GraphicVertex<T> vertex);

    /**
     * 插入弧
     *
     * @param arc   弧
     * @param isDel 是否删除
     * @return 成功返回true， 是否返回false
     */
    boolean insertArc(GraphicArc<T> arc);

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertex 顶点
     * @return 连接点集合
     */
    List<GraphicVertex<T>> listAdjVerByIdx(GraphicVertex<T> vertex);


    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertexIdx 顶点的索引
     * @return 连接点集合
     */
    List<GraphicVertex<T>> listAdjVerByIdx(int vertexIdx);

    /**
     * 获取顶点的弧
     *
     * @param vertex 顶点
     * @return 顶点弧的集合
     */
    List<GraphicArc<T>> listVerArcs(GraphicVertex<T> vertex);

    /**
     * 通过顶点的索引获取顶点的弧
     *
     * @param vertexIdx 顶点的索引
     * @return 顶点弧的集合
     */
    List<GraphicArc<T>> listVerArcs(int vertexIdx);

    /**
     * @param arc 弧
     * @return 是否删除成功
     */
    boolean deleteArc(GraphicArc<T> arc);

    /**
     * 深度优先遍历
     *
     * @return 遍历的节点
     */
    List<GraphicVertex<T>> DFSTraverse();

    /**
     * 广度优先遍历
     *
     * @return 遍历的节点
     */
    List<GraphicVertex<T>> HFSTraverse();

}