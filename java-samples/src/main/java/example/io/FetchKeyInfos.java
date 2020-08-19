package example.io;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchKeyInfos {

    public static void main(String[] args) throws IOException {
        String file = "/Users/zhuhan/IdeaProjects/apps/java-samples/src/main/resources/demo.txt";
        List<String> lines = IOUtils.readLines(new FileInputStream(file), "utf-8");
        Splitter splitter = Splitter.on("|");
        Map<String, List<String>> map = new HashMap<>();
        for (String line : lines) {
            List<String> contents = splitter.splitToList(line);
            String key = contents.get(2);
            String value = contents.get(5).substring(0, contents.get(5).indexOf("["));
            MsgDTO msgDTO = JSON.parseObject(value, MsgDTO.class);
            String sourceOrderCode = msgDTO.getHuChangePropertiesDTO().getExtendFields().get("sourceOrderCode");
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(sourceOrderCode);
        }
//        System.out.println(JSON.toJSONString(map));
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"  "+ Joiner.on(",").join(entry.getValue()));
        }

    }

    static class MsgDTO{
        private String bizCode;
        private HuChangePropertiesDTO huChangePropertiesDTO;

        public String getBizCode() {
            return bizCode;
        }

        public void setBizCode(String bizCode) {
            this.bizCode = bizCode;
        }

        public HuChangePropertiesDTO getHuChangePropertiesDTO() {
            return huChangePropertiesDTO;
        }

        public void setHuChangePropertiesDTO(HuChangePropertiesDTO huChangePropertiesDTO) {
            this.huChangePropertiesDTO = huChangePropertiesDTO;
        }
    }

    static class HuChangePropertiesDTO{
        Map<String, String> extendFields;

        public Map<String, String> getExtendFields() {
            return extendFields;
        }

        public void setExtendFields(Map<String, String> extendFields) {
            this.extendFields = extendFields;
        }
    }
}
