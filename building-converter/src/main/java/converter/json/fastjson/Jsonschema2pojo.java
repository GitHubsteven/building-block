package converter.json.fastjson;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.net.URL;
import java.nio.file.Files;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 18:55 2019/4/3.
 */
public class Jsonschema2pojo {
    public static void main(String[] args) {
        JCodeModel codeModel = new JCodeModel();

//        URL source = Example.class.getResource("/schema/required.json");

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
//        mapper.generate(codeModel, "ClassName", "com.example", source);

//        codeModel.build(Files.createTempDirectory("required").toFile());
    }
}