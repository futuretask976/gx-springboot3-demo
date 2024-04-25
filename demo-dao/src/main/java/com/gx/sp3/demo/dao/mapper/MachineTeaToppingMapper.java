package com.gx.sp3.demo.dao.mapper;

import com.gx.sp3.demo.dao.annotation.MySQLScan;
import com.gx.sp3.demo.dao.pojo.HotelGuestPojo;
import com.gx.sp3.demo.dao.pojo.MachineTeaPojo;
import com.gx.sp3.demo.dao.pojo.MachineTeaToppingPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@MySQLScan
@Repository
public interface MachineTeaToppingMapper {
    /**
     *
     * @param teaCode
     * @return
     */
    MachineTeaToppingPojo get(@Param("machineCode") String machineCode, @Param("teaCode") String teaCode, @Param("toppingCode") String topping);

    /**
     * 查询所有用户
     * @return
     */
    List<MachineTeaToppingPojo> list();

    /**
     *
     * @param machineTeaToppingPojo
     * @return
     */
    int insert(MachineTeaToppingPojo machineTeaToppingPojo);

    /**
     *
     * @param machineTeaToppingPojo
     * @return
     */
    int update(MachineTeaToppingPojo machineTeaToppingPojo);

    /**
     *
     * @param teaCode
     * @return
     */
    int delete(String teaCode);
}
