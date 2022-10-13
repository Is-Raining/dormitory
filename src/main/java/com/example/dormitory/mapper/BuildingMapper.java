package com.example.dormitory.mapper;

import com.example.dormitory.entity.Building;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
@Repository
@Mapper
public interface BuildingMapper extends BaseMapper<Building> {

}
