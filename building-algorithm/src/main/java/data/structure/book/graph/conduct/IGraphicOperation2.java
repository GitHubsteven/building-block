package data.structure.book.graph.conduct;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 16:46 2019/3/22.
 */
public interface IGraphicOperation2<V, A> {
    /**
     * 生成图
     *
     * @param vertices     顶点
     * @param arcs         弧
     * @param isDirected   是否为有向图
     * @param isWithWeight 是否带有权值
     */
    void createGraph(List<V> vertices, List<A> arcs,
                     boolean isDirected, boolean isWithWeight);

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
    int locateVex(V vertex);

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    V firstAdjVex(V vertex);

    /**
     * 增加一个新的节点
     *
     * @param vertex 节点信息
     * @return 成功返回true， 是否返回false
     */
    boolean insertVex(V vertex);

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    boolean deleteVex(V vertex);

    /**
     * 插入弧
     *
     * @param arc 弧
     * @return 成功返回true， 是否返回false
     */
    boolean insertArc(A arc);

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertex 顶点
     * @return 连接点集合
     */
    List<V> listAdjVerByIdx(V vertex);


    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertexIdx 顶点的索引
     * @return 连接点集合
     */
    List<V> listAdjVerByIdx(int vertexIdx);

    /**
     * 获取顶点的弧
     *
     * @param vertex 顶点
     * @return 顶点弧的集合
     */
    List<A> listVerArcs(V vertex);

    /**
     * 通过顶点的索引获取顶点的弧
     *
     * @param vertexIdx 顶点的索引
     * @return 顶点弧的集合
     */
    List<A> listVerArcs(int vertexIdx);

    /**
     * @param arc 弧
     * @return 是否删除成功
     */
    boolean deleteArc(A arc);

    /**
     * 深度优先遍历
     *
     * @return 遍历的节点
     */
    List<V> DFSTraverse();

    /**
     * 广度优先遍历
     *
     * @return 遍历的节点
     */
    List<V> HFSTraverse();
}