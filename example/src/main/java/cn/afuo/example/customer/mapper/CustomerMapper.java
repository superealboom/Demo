package cn.afuo.example.customer.mapper;

import cn.afuo.example.customer.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    int batchInsert(List<Customer> list);

}
