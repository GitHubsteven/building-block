package tranditional.visitor.indiv.example;

public class Environment {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        IData data = new ConcreteData();
        data.accept(visitor);
    }
}
