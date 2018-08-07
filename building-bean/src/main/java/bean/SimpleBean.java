package bean;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/25
 * @Time: 11:10
 * @Description:
 * @version: 1.0.0
 */
public class SimpleBean {
    private String name;
    private Date created;
    private Double idCord;
    private List<String> list;
    private SimpleBean self;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getIdCord() {
        return idCord;
    }

    public void setIdCord(Double idCord) {
        this.idCord = idCord;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public SimpleBean getSelf() {
        return self;
    }

    public void setSelf(SimpleBean self) {
        this.self = self;
    }
}