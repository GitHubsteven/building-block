package xstream.generic.online.test.generic.custom;

import com.thoughtworks.xstream.XStream;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Response<B> responseB = new Response<>(5, new B());
        String xml = new XStream().toXML(responseB);
        System.out.println("marshalled:\n" + xml);
        Response<B> resultB = (Response<B>) new XStream().fromXML(xml);
        System.out.println("unmarshalled: " + resultB);

        Response<C> responseC = new Response<>(10, new C());
        xml = new XStream().toXML(responseC);
        System.out.println("marshalled:\n" + xml);
        Response<C> resultC = (Response<C>) new XStream().fromXML(xml);
        System.out.println("unmarshalled: " + resultC);
    }

    static class Response<T extends Foo> {
        int id;
        T field;

        Response(int id, T field) {
            this.id = id;
            this.field = field;
        }

        public int getId() { return id; }
        public T getField() { return field; }
    }

    static class Foo {}

    static class B extends Foo {}

    static class C extends Foo {}
}