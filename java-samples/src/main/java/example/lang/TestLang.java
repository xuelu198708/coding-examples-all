package example.lang;

import java.util.Date;

/**
 * Created by xuelu
 * 2019-04-30.
 */
public class TestLang {
    /**
     * null对象做强转
     * @param args
     */
    public static void main(String[] args) {
        Date date = (Date) null;
        System.out.println(date);
    }
}
