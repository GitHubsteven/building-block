package tranditional.prototype;

import java.io.*;

public class Prototype implements Cloneable,Serializable{

    private  String string;
    private  SerializableObject obj;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public  Object deepClone() throws IOException, ClassNotFoundException {
        /*
         * write current object stream
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /*
         *read new stream to create new Object
         */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois =  new  ObjectInputStream(bis);

        return ois.readObject();
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    static class SerializableObject implements Serializable{
        private String note;

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }
}
