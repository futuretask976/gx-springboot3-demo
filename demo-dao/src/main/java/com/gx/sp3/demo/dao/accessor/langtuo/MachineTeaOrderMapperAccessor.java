package com.gx.sp3.demo.dao.accessor.langtuo;

import com.gx.sp3.demo.dao.mapper.langtuo.MachineTeaOrderMapper;
import com.gx.sp3.demo.dao.pojo.langtuo.MachineTeaOrderPojo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MachineTeaOrderMapperAccessor {
    @Resource
    private MachineTeaOrderMapper mapper;

    public List<MachineTeaOrderPojo> list() {
        return mapper.list();
    }

    public MachineTeaOrderPojo get(String orderId) {
        return mapper.get(orderId);
    }
}
