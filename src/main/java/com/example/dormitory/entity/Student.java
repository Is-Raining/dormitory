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
    public class Student implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId("Student_ID")
      private Integer studentId;

    @TableField("Dormitory_ID")
    private Integer dormitoryId;

      /**
     * 学生学号
     */
      @TableField("Student_Username")
    private String studentUsername;

    @TableField("Student_Password")
    private String studentPassword;

    @TableField("Student_Name")
    private String studentName;

    @TableField("Student_Sex")
    private String studentSex;

    @TableField("Student_Class")
    private String studentClass;

    @TableField("Student_State")
    private String studentState;


}
