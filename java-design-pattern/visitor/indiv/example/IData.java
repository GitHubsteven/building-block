package visitor.indiv.example;

public interface IData {
    void accept(Visitor visitor);

     String getSubject();
}
