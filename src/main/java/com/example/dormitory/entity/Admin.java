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
    public class Admin implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 宿管id
     */
        @TableId("Admin_ID")
      private Integer adminId;

      /**
     * 宿管用户名
     */
      @TableField("Admin_Username")
    private String adminUsername;

      /**
     * 宿管密码
     */
      @TableField("Admin_Password")
    private String adminPassword;

      /**
     * 宿管姓名
     */
      @TableField("Admin_Name")
    private String adminName;

      /**
     * 宿管性别
     */
      @TableField("Admin_Sex")
    private String adminSex;

      /**
     * 宿管电话
     */
      @TableField("Admin_Tel")
    private Integer adminTel;


}
