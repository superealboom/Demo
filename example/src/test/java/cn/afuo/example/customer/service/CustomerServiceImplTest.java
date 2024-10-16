package cn.afuo.example.customer.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    public void batchInsertTest() {
        customerService.batchInsert();
    }

}