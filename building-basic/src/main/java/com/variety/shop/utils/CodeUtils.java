package com.variety.shop.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readLines;
import static org.apache.commons.io.FileUtils.write;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 12:36 2018/3/23.
 */
public class CodeUtils {

    private final static String template = "private " + "%s" + " " + " " + "%s";
    private final static String suffix = ".java";
    private final static String source_root = "G:\\source";
    private final static String target_root = "G:\\target";
    private final static String enter = "\n";
    private final static String start = "public class %s{";
    private final static String end = enter + "}";
    private final static String annotation = "package com.voyageone.ecerp.interfaces.third.nxubuy.model;\n"+
            "/**\n" +
            " * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.\n" +
            " * @Author rongbin.xie\n" +
            " * @Description:\n" +
            " * @Date: Created at 14:30 2018/4/17.\n" +
            " */\n";

    public static enum Type {
        Decimal
    }

    public static void main(String[] args) throws IOException {
//        createFromString();
        File file = new File(source_root+"\\context.txt");
        List<String> sentences;
        sentences = readFile(file);
        analysisSentence(sentences, "QueryProductResponse");
    }

    public static void analysisSentence(List<String> sentence, String clazzName) throws IOException {
        Path outputPath = Paths.get(target_root, clazzName + suffix);
        List<AttrValue> attrs = sentence.stream()
                .map(CodeUtils::analysiseOneSen)
                .collect(Collectors.toList());

        File output = outputPath.toFile();
        if(output.isFile() && output.exists()) output.delete();
        FileUtils.write(output, String.format(annotation + start, clazzName) + enter, "utf-8", true);

        attrs.forEach(attrValue -> {
            String anno = enter + "/**" + enter + attrValue.getAnnotation() + enter + "**/" + enter;
            String realContext = String.format(template, convertType(attrValue.getType()), attrValue.getName());
            try {
                write(output, anno + realContext + ";", "utf-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        write(output, end, "utf-8", true);
        System.out.println("end");
    }

    static String convertType(String original) {
        if (original.startsWith("var")) return "String";
        if (original.startsWith("dec")) return "BigDecimal";
        if (original.startsWith("date")) return "Date";
        if(original.startsWith("int")) return "Integer";
        return null;
    }


    static AttrValue analysiseOneSen(String sentence) {
        sentence = sentence.replaceAll("<", "");
        sentence = sentence.replaceAll(">", "");
//        sentence = sentence.replaceAll("\\.", "");
        String[] attrs = sentence.split("(\\t)+");
        AttrValue attr = new AttrValue();
        String name = attrs[0].substring(0, 1).toLowerCase() + attrs[0].substring(1);
        attr.setName(name);
        attr.setType(attrs[1]);
        String ann = attrs[2].contains("是") ? "需要" : attrs[2];
        attr.setAnnotation(ann + enter + attrs[3]);
        return attr;
    }


    private static void createFromString() {
        System.out.println("INSERT INTO voyageone_wms.wms_mt_sku_info (channel_id, sku, origin, ingredients, specification, origin_product_name, length, width, height, actual_length, actual_width, actual_height, measured, net_weight, gross_weight, actual_net_weight, actual_gross_weight, weighed, price, price_unit, origin_price, origin_price_unit, hs_code, declare_name, declare_unit, origin_declare_name, origin_declare_unit, invoice_category, active, created, creater, modified, modifier) VALUES ");
        List<String> attrs = Arrays.asList(
                "foodSku1",
                "notfoodsku1",
                "notfoodsku1",
                "notfoodsku2"
        );
        Set<String> skuSet = new HashSet<>(attrs);

        skuSet.forEach(attr -> {
            String methodName = attr.substring(0, 1).toUpperCase() + attr.substring(1);
            String category = attr.length() % 2 == 0 ? "非食品保健品类" : "食品保健品类";
            String weight = attr.substring(attr.length() - 1).equalsIgnoreCase("1") ? "450" : "1050";
            String sentence = String.format(
                    "('058','%s', 'AF', '', '1cm*2cm*3cm', '', 0.00, 0.00, 0.00, 228.60, 152.40, 152.40, 1, %s, 0.00, 0.00, 0.00, 0, 0.000, '', 0.000, '', '2104200000', 'voyageone-good-name1%s', '台', '', '', \"%s\", 1, '2018-04-03 18:44:00', 'wms-439-test', '2018-04-11 16:54:35', 'wms-439-test')", attr, weight, attr, category);
            System.out.println(", ");
            System.out.println(sentence);
        });
    }

    public static List<String> readFile(File file) {
        List<String> sentences = null;
        try {
            sentences = readLines(file, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentences;
    }
}
