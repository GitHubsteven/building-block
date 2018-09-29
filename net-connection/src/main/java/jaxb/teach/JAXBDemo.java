package jaxb.teach;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: jet.xie
 * @Date: 2018/9/27
 * @Description:
 * @version: 1.0.0
 */
public class JAXBDemo {
    public static void main(String[] args) throws JAXBException {

        Order order = new Order();
        order.setId(2L);
        order.setCategory("3C");
        Set<String> tags = new HashSet<String>();
        tags.add("3C");
        tags.add("手机");
        order.setTags(tags);

        List<ShoppingItem> shopping_list = new ArrayList<ShoppingItem>();
        ShoppingItem shoppingItem1 = new ShoppingItem();
        shoppingItem1.setName("Apple 6s Plus 64G");
        shoppingItem1.setPrice(6499f);
        shoppingItem1.setNum(1);
        shopping_list.add(shoppingItem1);

        ShoppingItem shoppingItem2 = new ShoppingItem();
        shoppingItem2.setName("魅蓝Note3 32G");
        shoppingItem2.setPrice(999f);
        shoppingItem2.setNum(1);
        shopping_list.add(shoppingItem2);

        order.setShoppingList(shopping_list);

        order.setTotalPrice(7498f);

        Address address = new Address();
        address.setProvince("湖北省");
        address.setCity("武汉市");
        address.setDistrict("武昌区");
        address.setStreet("复兴路");
        order.setAddress(address);

        String xml = JAXBUtils.marshal(order);
        System.out.println("marshaller order:" + xml);

        Order o = JAXBUtils.unmarshal(xml, Order.class);
        System.out.println("unmarshaller order:" + o);
    }

}