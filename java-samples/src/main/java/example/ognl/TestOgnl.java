package example.ognl;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

/**
 * Created by xuelu
 * 2019-05-14.
 */
@Slf4j
public class TestOgnl {

    @Test
    public void testOgnl() throws OgnlException {
        User user = new User();
        user.setId(1000);
        user.setName("Jack");
        OgnlContext context = new OgnlContext();
        context.put("user", user);
        context.put("name", "xuelu");

        Object name = Ognl.getValue("#name", context, context.getRoot());
        log.info(name.toString());

        Object id = Ognl.getValue("#user.id", context, context.getRoot());
        log.info(id.toString());

        Object name2 = Ognl.getValue("name", context, user);
        log.info(name2.toString());

        String json = JSON.toJSONString(user);
        Object name3 = Ognl.getValue("name", context, JSON.parse(json));
        log.info(name3.toString());

        log.info(Ognl.getValue(Ognl.parseExpression("id in {1000,200}"), user).toString());

        log.info(Ognl.getValue(Ognl.parseExpression("id not in {1000,200}"), user).toString());

        log.info(Ognl.getValue(Ognl.parseExpression("id == 1000"), user).toString());

        log.info(Ognl.getValue(Ognl.parseExpression("id != 1000"), user).toString());

        log.info(Ognl.getValue(Ognl.parseExpression("(id == 1000) && (name=='Jack')"), user).toString());

        log.info(Ognl.getValue(Ognl.parseExpression("(id == 1000) || (name=='Jack2')"), user).toString());

    }

    @Data
    private static class User{
        private int id;
        private String name;
    }
}
