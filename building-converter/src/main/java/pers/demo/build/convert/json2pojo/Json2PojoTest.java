package pers.demo.build.convert.json2pojo;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/24
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Json2PojoTest {
    /**
     * @param args
     */
    public static void main(String[] args) {

        String packageName = "com.cooltrickshome";
        File inputJson = new File("." + File.separator + "input.json");
        File outputPojoDirectory = new File("." + File.separator + "convertedPojo");
        outputPojoDirectory.mkdirs();
        try {
            new Json2PojoTest().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException {
        JCodeModel codeModel = new JCodeModel();

        URL source = inputJson;

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, className, packageName, source);

        codeModel.build(outputPojoDirectory);
    }
}
