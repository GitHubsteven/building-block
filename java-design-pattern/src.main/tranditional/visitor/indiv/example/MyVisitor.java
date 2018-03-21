package tranditional.visitor.indiv.example;

public class MyVisitor implements Visitor {
    @Override
    public void visit(IData data) {
        System.out.println(String.format("tranditional.visitor is visiting data's attribute[%s]: " ,data.getSubject()));
    }
}
