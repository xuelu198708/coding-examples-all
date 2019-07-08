package example.io;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuelu
 * 2019-05-13.
 */
public class CollectorResultReader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("users.csv")));
        String line = reader.readLine();
        List<String> list = new ArrayList<>();
        while (line!=null){
            list.add(JSON.toJSONString(line));
            line = reader.readLine();
        }
        System.out.println(list);
    }
}
