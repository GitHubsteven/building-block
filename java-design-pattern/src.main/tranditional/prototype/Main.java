package tranditional.prototype;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        prototype.setString("hello");
        Prototype.SerializableObject obj = new Prototype.SerializableObject();
        obj.setNote("world");
        prototype.setObj(obj);

        Prototype cloneObject = (Prototype)prototype.deepClone();
        System.out.println(cloneObject.getObj().getNote());
    }
}
