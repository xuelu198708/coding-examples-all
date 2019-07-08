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

    @Test
    public void testJsonPath(){
        String json = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"Herman Melville\",\"title\":\"Moby Dick\",\"isbn\":\"0-553-21311-3\",\"price\":8.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}},\"expensive\":10}";
        ReadContext context = JsonPath.parse(json);
        log.info("返回结果：{}",context.read("$.store.book[*].author").toString());
        log.info("expensive返回结果：{}",context.read("$.expensive").toString());
    }

    @Data
    static class HumanInfo{
        String idcard;
        String sex;
    }
}

