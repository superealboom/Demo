package cn.afuo.example.serializable;

import cn.afuo.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class SerializableServiceTest {

    @Autowired
    private SerializableService serializableService;

    @Test
    public void testSerializable() throws Exception {
        SerializableEntity serializableEntity = new SerializableEntity();
        serializableEntity.setName("test");
        serializableService.serializable(serializableEntity);
    }


    /**
     * java.io.InvalidClassException: cn.afuo.demo.serializableTest.entity.SerializableEntity;
     * local class incompatible: stream classdesc serialVersionUID = 3970795840286854294,
     * local class serialVersionUID = 4701407582113416362
     */
    @Test
    public void testDeserializable() throws Exception {
        SerializableEntity deserializable = serializableService.deserializable();
        log.info("反序列化得到:{}", JsonUtil.toJson(deserializable));
    }

}