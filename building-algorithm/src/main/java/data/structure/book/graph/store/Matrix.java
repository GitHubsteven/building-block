package data.structure.book.graph.store;

import bean.GraphicArc;
import bean.GraphicVertex;
import data.structure.book.graph.conduct.IGraphicOperation;
import lombok.AccessLevel;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 矩阵存储树
 * 1. 如何描述
 * 两个存储空间，一个是顶点，一个是关系矩阵，设顶点数组为v[4] = {v0,v1,v2,v3}
 * 矩阵为二维数组arc[n][n],对于当前的顶点n= 4;
 * if(vi->vj相连)
 * arc[i][j] = 1;
 * else
 * arc[i][j] = 0;
 * <p>
 * 无向图时，如果：vi-vj = 1， 那么vj->vi = 1，那么矩阵就是对称矩阵，但是对于有向图来说，那么就不同了
 * 上述条件不会相等，那么就不一定是堆成矩阵。
 * <p>
 * 下面是是对矩阵的描述的实现
 * @Date: Created at 10:37 2019/3/18.
 */
@Getter
public class Matrix<T extends Comparable<T>> implements IGraphicOperation<T> {
    private final int INFINITY = Integer.MAX_VALUE;

    /**
     * 顶点
     */
    @Getter(AccessLevel.NONE)
    private List<GraphicVertex<T>> vertices;

    /**
     * 边或者弧的集合
     */
    private int[][] matrix;

    /**
     * 是否为有向图，true表示是，否表示否
     */
    private boolean isDirected;

    /**
     * 是否带有权值，true表示是，否表示否
     */
    private boolean isWithWeight;

    /**
     * 输入可视化的边，和顶点
     *
     * @param vertices   顶点
     * @param arcs       边的集合
     * @param isDirected 是否为有向边，true表示是，false表示否
     */
    public Matrix(List<GraphicVertex<T>> vertices, List<GraphicArc<T>> arcs,
                  boolean isDirected, boolean isWithWeight) {
        this.isDirected = isDirected;
        this.isWithWeight = isWithWeight;
        createGraph(vertices, arcs, isDirected, isWithWeight);
    }


    /**
     * 生成图
     *
     * @param vertices     顶点
     * @param arcs         弧
     * @param isDirected   是否为有向图
     * @param isWithWeight 是否有权值
     */
    @Override
    public void createGraph(List<GraphicVertex<T>> vertices, List<GraphicArc<T>> arcs,
                            boolean isDirected, boolean isWithWeight) {
        if (arcs == null || arcs.size() == 0) throw new IllegalArgumentException("输入边不能为空!");
        if (vertices == null || vertices.size() == 0) throw new IllegalArgumentException("输入的顶点不能为空!");
        int matrixSize = vertices.size();
        matrix = new int[matrixSize][matrixSize];
        //根据可视化弧来构建矩阵
        for (GraphicArc<T> arc : arcs) {
            int fromIdx = vertices.indexOf(arc.getFrom());
            int toIdx = vertices.indexOf(arc.getTo());
            //如果没有权值的话，那么设置为默认为1
            int defaultWeight = 1;
            if (isWithWeight) {
                defaultWeight = arc.getWeight().intValue();
            }
            matrix[fromIdx][toIdx] = defaultWeight;
            if (!isDirected) {
                //如果是无向图，那么对称点也是1
                matrix[toIdx][fromIdx] = 1;
            }
        }
        //如果是网的话，那么就把不连接的权值设为无穷大
        if (isWithWeight) {
            for (int[] row : matrix) {
                for (int colIdx = 0; colIdx < row.length; colIdx++) {
                    if (row[colIdx] == 0) row[colIdx] = INFINITY;
                }
            }
        }
    }

    /**
     * 销毁树
     */
    @Override
    public void destroyGraph() {
        this.vertices = null;
        this.isDirected = false;
        this.isWithWeight = false;
        this.matrix = null;
    }

    /**
     * 定位顶点的位置，如果存在的话
     *
     * @param vertex 顶点
     * @return 坐标位置
     */
    @Override
    public int locateVex(GraphicVertex<T> vertex) {
        return this.vertices.indexOf(vertex);
    }

    /**
     * 获取第一个连接点
     *
     * @param vertex 顶点
     * @return 第一个连接点
     */
    @Override
    public GraphicVertex<T> firstAdjVex(GraphicVertex<T> vertex) {
        int[] targetVertex = this.matrix[locateVex(vertex)];
        for (int j = 0; j < targetVertex.length; j++) {
            if (targetVertex[j] == 1) return vertices.get(j);
        }
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
        vertices.add(vertex);
        int newSize = vertices.size();
        int[][] newMatrix = new int[newSize][newSize];
        int originalSize = this.matrix.length;
        for (int rowIdx = 0; rowIdx < originalSize; rowIdx++) {
            System.arraycopy(this.matrix[rowIdx], 0, newMatrix[rowIdx], 0, originalSize);
        }
        this.matrix = newMatrix;
        return true;
    }

    /**
     * 删除节点
     *
     * @param vertex 节点
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean deleteVex(GraphicVertex<T> vertex) {
        int verIdx = vertices.indexOf(vertex);
        this.vertices.remove(vertex);
        //重构矩阵
        int size = this.vertices.size();
        int[][] newMatrix = new int[size][size];
        for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
            //如果是删除顶点的索引的话，那么跳过不复制
            if (rowIdx == verIdx) continue;
            int[] row = this.matrix[rowIdx];
            for (int colIdx = 0; colIdx < row.length; colIdx++) {
                if (colIdx == verIdx) continue;
                if (colIdx < verIdx) newMatrix[rowIdx][colIdx] = row[colIdx];
                if (colIdx > verIdx) newMatrix[rowIdx][colIdx - 1] = row[colIdx];
            }
        }
        this.matrix = newMatrix;
        //从顶点集合中删除顶点
        return vertices.remove(vertex);
    }

    /**
     * 插入弧
     *
     * @param arc 弧
     * @return 成功返回true， 是否返回false
     */
    @Override
    public boolean insertArc(GraphicArc<T> arc) {
        int fromIdx = vertices.indexOf(arc.getFrom());
        int toIdx = vertices.indexOf(arc.getTo());
        int weight = isWithWeight ? arc.getWeight().intValue() : 1;
        matrix[fromIdx][toIdx] = weight;
        //如果不是有向图，那么对称点也设为weight
        if (!isDirected) matrix[toIdx][fromIdx] = weight;

        return true;
    }

    /**
     * @param arc 弧
     * @return 是否删除成功
     */
    @Override
    public boolean deleteVex(GraphicArc<T> arc) {
        //把弧的路径设置为最大值(如果要求带有权重的话）或者0
        BigDecimal disConnect = isWithWeight ? new BigDecimal(INFINITY) : BigDecimal.ZERO;
        arc.setWeight(disConnect);
        return insertArc(arc);
    }

    /**
     * 描述图
     */
    public void descript() {
        for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
            String tag = this.isDirected ? "----->" : "------";
            System.out.println(String.format("vertex[value:%s]", vertices.get(rowIdx).getValue().toString()));
            for (GraphicArc<T> arc : listVerArcs(rowIdx)) {
                System.out.print(String.format("Arc[from: %s %s to: %s, weight:%d]\t",
                        arc.getFrom().getValue().toString(), tag,
                        arc.getTo().getValue().toString(), arc.getWeight().intValue()));
            }
            System.out.println();
        }
    }

    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertex 顶点
     * @return 连接点集合
     */
    public List<GraphicVertex<T>> listAdjVerByIdx(GraphicVertex<T> vertex) {
        return listAdjVerByIdx(vertices.indexOf(vertex));
    }


    /**
     * 获取顶点的相邻的顶点
     *
     * @param vertexIdx 顶点的索引
     * @return 连接点集合
     */
    @Override
    public List<GraphicVertex<T>> listAdjVerByIdx(int vertexIdx) {
        List<GraphicVertex<T>> adjVertices = new ArrayList<>();
        int[] row = this.matrix[vertexIdx];
        int disConnect = isWithWeight ? INFINITY : 0;
        //遍历矩阵
        for (int colIdx = 0; colIdx < row.length; colIdx++) {
            if (row[colIdx] != disConnect) {
                adjVertices.add(vertices.get(colIdx));
            }
        }
        return adjVertices;
    }


    /**
     * 获取顶点的弧
     *
     * @param vertex 顶点
     * @return 顶点弧的集合
     */
    @Override
    public List<GraphicArc<T>> listVerArcs(GraphicVertex<T> vertex) {
        return listVerArcs(this.vertices.indexOf(vertex));
    }

    /**
     * 通过顶点的索引获取顶点的弧
     *
     * @param vertexIdx 顶点的索引
     * @return 顶点弧的集合
     */
    @Override
    public List<GraphicArc<T>> listVerArcs(int vertexIdx) {
        List<GraphicArc<T>> verArcs = new ArrayList<>();
        int[] row = this.matrix[vertexIdx];
        GraphicVertex<T> vertex = this.vertices.get(vertexIdx);
        int disconnect = isWithWeight ? INFINITY : 0;
        for (int idx = 0; idx < row.length; idx++) {
            if (row[idx] != disconnect) {
                GraphicArc<T> arc = new GraphicArc<>();
                arc.setFrom(vertex);
                arc.setTo(this.vertices.get(idx));
                arc.setWeight(new BigDecimal(row[idx]));
                verArcs.add(arc);
            }
        }
        return verArcs;
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

    /**
     * 测试case，V= {v0,v1,v2,v3}
     * VR = {v0-v1, v0-v2,v0-v3,v1-v0,v1-v2,}
     * @param args main函数的参数
     */
    public static void main(String[] args) {
        // TODO: 2019/3/18 待测试
    }

}