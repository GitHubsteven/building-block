package practice;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 20:34
 * @Description:
 * @version: 1.0.0
 */
public class AsaPairAfterErasure {

    public AsaPairAfterErasure(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private Object key;
    private Object value;
}