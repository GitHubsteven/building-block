package visitor.indiv.example;

@FunctionalInterface
public interface Visitor {
    void visit(IData data);
}
