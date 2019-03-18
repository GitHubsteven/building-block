package data.structure.book.graph.store;

import bean.GraphicArc;
import bean.GraphicVertex;
import data.structure.book.graph.conduct.IGraphicOperation;

import java.util.List;

/**
 * @author: asaland
 * @date: 2019/3/19
 * @time: 1:05
 * @version: 1.0.0
 * @description: 数组+ 链表表示图
 **/
public class ArrayLink<T extends Comparable<T>> implements IGraphicOperation<T> {
    @Override
    public void createGraph(List<GraphicVertex<T>> graphicVertices, List<GraphicArc<T>> graphicArcs,
                            boolean isDirected, boolean isWithWeight) {

    }

    @Override
    public void destroyGraph() {

    }

    @Override
    public int locateVex(GraphicVertex<T> vertex) {
        return 0;
    }

    @Override
    public GraphicVertex<T> firstAdjVex(GraphicVertex<T> vertex) {
        return null;
    }

    @Override
    public boolean insertVex(GraphicVertex<T> vertex) {
        return false;
    }

    @Override
    public boolean deleteVex(GraphicVertex<T> vertex) {
        return false;
    }

    @Override
    public boolean insertArc(GraphicArc<T> arc) {
        return false;
    }

    @Override
    public List<GraphicVertex<T>> listAdjVerByIdx(GraphicVertex<T> vertex) {
        return null;
    }

    @Override
    public List<GraphicVertex<T>> listAdjVerByIdx(int vertexIdx) {
        return null;
    }

    @Override
    public List<GraphicArc<T>> listVerArcs(GraphicVertex<T> vertex) {
        return null;
    }

    @Override
    public List<GraphicArc<T>> listVerArcs(int vertexIdx) {
        return null;
    }

    @Override
    public boolean deleteArc(GraphicArc<T> arc) {
        return false;
    }

    @Override
    public List<GraphicVertex<T>> DFSTraverse() {
        return null;
    }

    @Override
    public List<GraphicVertex<T>> HFSTraverse() {
        return null;
    }
}
