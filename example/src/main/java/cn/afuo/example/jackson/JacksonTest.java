package cn.afuo.example.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JacksonTest {

    public static void main(String[] args) throws Exception {
        // 对象转换成json字符串
        object2JsonString();
    }

    private static void object2JsonString() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 18);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(map);
        log.info(jsonString);
    }
}
