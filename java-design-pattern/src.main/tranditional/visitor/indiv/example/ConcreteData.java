package tranditional.visitor.indiv.example;

public class ConcreteData implements IData {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "attr content";
    }
}
