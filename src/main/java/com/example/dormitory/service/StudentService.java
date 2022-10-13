package com.example.dormitory.service;

import com.example.dormitory.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dormitory.form.RuleForm;
import com.example.dormitory.vo.ResultVo;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
public interface StudentService extends IService<Student> {
    public Student queryUserByName(String name);
    public ResultVo login(RuleForm ruleForm);

    public ResultVo infor(UsernamePasswordToken token);

    public ResultVo toInfo();

    public ResultVo unLogged();

    public ResultVo editPwd(String original, String password, String confirm);

    public ResultVo buildings(Integer number);
}
