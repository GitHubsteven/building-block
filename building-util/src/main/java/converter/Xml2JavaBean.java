package converter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Xml2JavaBean {

    public static void main(String[] args) throws Exception {
        File xml = new File("D:\\k-mediods\\building-block\\building-util\\src\\main\\java\\converter\\test.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(xml);
        Element root = document.getRootElement();
        if (root != null) {
            Map<String, Object> nodes = new LinkedHashMap<>();
            parseElement(root, nodes);
            System.out.printf("public class %sInfo {\n", firstUpperCase(root.getName()));
            printElement(nodes.get(root.getName()), 1);
            System.out.println("}");
        }
    }

    @SuppressWarnings("unchecked")
    protected static void printElement(Object node, int indent) {
        if (node != null) {
            Map<String, Object> nodeMap = (Map<String, Object>) node;
            nodeMap.forEach((name, subNode) -> {
                String pad = IntStream.range(0, indent).mapToObj(i -> "\t").collect(Collectors.joining());
                if (subNode == null) {
                    System.out.printf("%sprivate String %s;\n", pad, name);
                } else {
                    String clazz = firstUpperCase(name) + "Info";
                    System.out.printf("%sprivate %s %s;\n", pad, clazz, name);
                    System.out.printf("%spublic static class %s {\n", pad, clazz);
                    printElement(subNode, indent + 1);
                    System.out.printf("%s}\n", pad);
                }
            });
        }
    }

    private static String firstUpperCase(String input) {
        if (input != null) {
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
        return "";
    }

    protected static void parseElement(Element element, Map<String, Object> nodes) {
        Map<String, Object> subNodes = null;
        if (element != null) {
            List<?> elements = element.elements();
            if (elements != null && !elements.isEmpty()) {
                subNodes = new LinkedHashMap<>();
                for (int i = 0; i < elements.size(); i++) {
                    Object subNode = elements.get(i);
                    if (subNode instanceof Element) {
                        parseElement((Element) subNode, subNodes);
                    }
                }
            }
        }
        nodes.put(element.getName(), subNodes);
    }

}
