package cn.afuo.example.customer.service;

import cn.afuo.example.customer.entity.Customer;
import cn.afuo.example.customer.mapper.CustomerMapper;

import cn.afuo.common.util.RandomNumberUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements IService<Customer> {

    public void batchInsert() {
        int i = baseMapper.batchInsert(generateCustomers());
    }

    private List<Customer> generateCustomers() {
        List<Customer> customerList = new ArrayList<>();
        for (int j=0;j<100000;j++) {
            Customer customer = new Customer();
            customer.setPhone(RandomNumberUtil.getRandom(11));
            customer.setIdNo(RandomNumberUtil.getRandom(18));
            customerList.add(customer);
        }
        return customerList;
    }



}
