package com.example.dormitory.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Dormitory implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("Dormitory_ID")
      private Integer dormitoryId;

    @TableField("Building_ID")
    private Integer buildingId;

    @TableField("Dormitory_Name")
    private String dormitoryName;

      /**
     * 上床下桌；上下床；平床
     */
      @TableField("Dormitory_Type")
    private String dormitoryType;

    @TableField("Dormitory_Number")
    private Integer dormitoryNumber;

    @TableField("Remain_Number")
    private Integer remainNumber;

    @TableField("Dormitory_Sex")
    private String dormitorySex;


}
