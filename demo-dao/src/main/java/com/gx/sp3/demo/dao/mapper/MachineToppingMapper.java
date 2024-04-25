package com.gx.sp3.demo.dao.mapper;

import com.gx.sp3.demo.dao.annotation.MySQLScan;
import com.gx.sp3.demo.dao.pojo.HotelGuestPojo;
import com.gx.sp3.demo.dao.pojo.MachineTeaPojo;
import com.gx.sp3.demo.dao.pojo.MachineToppingPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@MySQLScan
@Repository
public interface MachineToppingMapper {
    /**
     *
     * @param toppingCode
     * @return
     */
    MachineToppingPojo get(@Param("machineCode") String machineCode, @Param("toppingCode") String toppingCode);

    /**
     * 查询所有用户
     * @return
     */
    List<MachineToppingPojo> list();

    /**
     *
     * @param menu
     * @return
     */
    int insert(MachineToppingPojo menu);

    /**
     *
     * @param menu
     * @return
     */
    int update(MachineToppingPojo menu);

    /**
     *
     * @param teaCode
     * @return
     */
    int delete(String teaCode);
}
