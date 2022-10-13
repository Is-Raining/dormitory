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
    public class Bed implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("Bed_ID")
      private Integer bedId;

    @TableField("Dormitory_ID")
    private Integer dormitoryId;

    @TableField("Dormitory_Sex")
    private String dormitorySex;

      /**
     * 0可用，1不可用
     */
      @TableField("Available")
    private Integer Available;


}
