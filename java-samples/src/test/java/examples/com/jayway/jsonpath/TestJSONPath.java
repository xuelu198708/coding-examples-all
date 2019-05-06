package examples.com.jayway.jsonpath;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xuelu
 * 2019-05-05.
 */
@Slf4j
public class TestJSONPath {

    @Test
    public void testRead(){
        //language=JSON
        String json = "{\"name\": \"xuelu\", \"address\": {\"province\": \"sd\", \"city\": \"jn\"}, \"interests\": [\"basketball\", \"football\"], \"others\": {\"idcard\": \"1111\", \"sex\": \"man\"}}";
        ReadContext context = JsonPath.parse(json);
        Assert.assertEquals("xuelu",context.read("$.name"));
        Assert.assertEquals("sd",context.read("$.address.province"));
        Assert.assertEquals("[\"basketball\",\"football\"]", context.read("$.interests").toString());
        HumanInfo humanInfo = new HumanInfo();
        humanInfo.setIdcard("1111");
        humanInfo.setSex("man");
        Assert.assertEquals(humanInfo, context.read("$.others", HumanInfo.class));
    }

    @Test(expected = PathNotFoundException.class)
    public void testRead_path_not_exists(){
        //language=JSON
        String json = "{\"name\": \"xuelu\", \"address\": {\"province\": \"sd\", \"city\": \"jn\"}, \"interests\": [\"basketball\", \"football\"]}";
        ReadContext context = JsonPath.parse(json);
        Assert.assertEquals("xuelu",context.read("$.name2"));
    }

    @Data
    static class HumanInfo{
        String idcard;
        String sex;
    }
}

