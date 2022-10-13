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
    public class Group implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("Group_ID")
      private Integer groupId;

    @TableField("Group_Code")
    private Integer groupCode;

    @TableField("Student_ID1")
    private Integer studentId1;

    @TableField("Student_ID2")
    private Integer studentId2;

    @TableField("Student_ID3")
    private Integer studentId3;

    @TableField("Student_ID4")
    private Integer studentId4;


}
