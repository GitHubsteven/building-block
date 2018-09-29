package jaxb.teach;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
@Setter
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"id", "totalPrice", "category", "shoppingList", "tags", "address"})
public class Order {
    @XmlAttribute(name = "id")
    private Long id;
    private String category;

    @XmlElementWrapper(name = "shopping_list")
    @XmlElement(name = "shopping_item")
    private List<ShoppingItem> shoppingList;

    @XmlElementWrapper(name = "tags")
    @XmlElement(name = "tag")
    private Set<String> tags;

    @XmlElement(name = "addr", required = true)
    private Address address;

    @XmlElement(name = "total_price")
    private float totalPrice;
}