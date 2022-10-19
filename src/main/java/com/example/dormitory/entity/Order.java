package com.example.dormitory.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
    public class Order implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("Order_ID")
      private Integer orderId;

    @TableField("Student_ID")
    private Integer studentId;

    @TableField("Building_ID")
    private Integer buildingId;

    @TableField("Group_ID")
    private Integer groupId;

    @TableField("Student_Sex")
    private String studentSex;

    //填充时间
    @TableField(value = "Submit_Time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime submitTime;

    @TableField("Order_State")
    private String orderState;


}
