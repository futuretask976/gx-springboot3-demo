package com.gx.sp3.demo.dao.accessor.langtuo;

import com.gx.sp3.demo.dao.mapper.langtuo.MachineMapper;
import com.gx.sp3.demo.dao.pojo.langtuo.MachinePojo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MachineMapperAccessor {
    @Resource
    private MachineMapper mapper;

    public List<MachinePojo> list() {
        return mapper.list();
    }

    public MachinePojo get(String machineCode) {
        return mapper.get(machineCode);
    }
}
