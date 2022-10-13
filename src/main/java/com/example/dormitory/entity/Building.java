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
    public class Building implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("Building_ID")
      private Integer buildingId;

    @TableField("Building_Name")
    private String buildingName;

    @TableField("Building_Introduction")
    private String buildingIntroduction;


}
