package com.gx.sp3.demo.dao.mapper;

import com.gx.sp3.demo.dao.annotation.MySQLScan;
import com.gx.sp3.demo.dao.pojo.HotelGuestPojo;
import com.gx.sp3.demo.dao.pojo.MachinePojo;
import com.gx.sp3.demo.dao.pojo.MachineTeaOrderPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@MySQLScan
@Repository
public interface MachineTeaOrderMapper {
    /**
     *
     * @param orderId
     * @return
     */
    MachineTeaOrderPojo get(@Param("orderId") String orderId);

    /**
     *
     * @return
     */
    List<MachineTeaOrderPojo> list();

    /**
     *
     * @param machineTeaOrderPojo
     * @return
     */
    int insert(MachineTeaOrderPojo machineTeaOrderPojo);

    /**
     *
     * @param machineTeaOrderPojo
     * @return
     */
    int update(MachineTeaOrderPojo machineTeaOrderPojo);

    /**
     *
     * @param orderId
     * @return
     */
    int delete(String orderId);
}
