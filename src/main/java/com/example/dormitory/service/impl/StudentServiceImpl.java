package com.example.dormitory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.dormitory.entity.Bed;
import com.example.dormitory.entity.Building;
import com.example.dormitory.entity.Dormitory;
import com.example.dormitory.entity.Student;
import com.example.dormitory.form.RuleForm;
import com.example.dormitory.mapper.BedMapper;
import com.example.dormitory.mapper.BuildingMapper;
import com.example.dormitory.mapper.StudentMapper;
import com.example.dormitory.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dormitory.vo.ResultVo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.apache.shiro.SecurityUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private BedMapper bedMapper;


    @Override
    public Student queryUserByName(String name) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("Student_Username",name);
        Student student = studentMapper.selectOne(wrapper);
        return student;
    }

    //登录接口实现
    @Override
    public ResultVo login(RuleForm ruleForm) {
        //验证非空
        ResultVo resultVo=new ResultVo();
        if (StringUtils.isEmpty(ruleForm.getUsername()) || StringUtils.isEmpty(ruleForm.getPassword())) {
            resultVo.setCode(402);
            resultVo.setMsg("账号密码不能为空");
            return resultVo;
        }
        //登录
        Subject subject =SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(ruleForm.getUsername(),ruleForm.getPassword());
        try {
            subject.login(token);
            resultVo.setCode(200);
            resultVo.setMsg("登录成功");
            return resultVo;
        }catch (UnknownAccountException e){
            resultVo.setCode(101);
            resultVo.setMsg("用户名不存在");
            return resultVo;
        }catch (IncorrectCredentialsException e){
            resultVo.setCode(102);
            resultVo.setMsg("密码错误");
            return resultVo;
        }

//        验证码功能

    }

    //个人信息查询
    @Override
    public ResultVo infor(UsernamePasswordToken token) {

        return null;
    }

    @Override
    public ResultVo toInfo() {
        Student student = (Student) SecurityUtils.getSubject().getPrincipal();
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMsg("操作成功");
        resultVo.setData(student);
        return resultVo;
    }

    @Override
    public ResultVo unLogged() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(301);
        resultVo.setMsg("未登录");

        return resultVo;
    }

    @Override
    public ResultVo editPwd(String original, String password, String confirm) {
        ResultVo resultVo = new ResultVo();
        // 判断原来密码是否有误
        Student student = (Student) SecurityUtils.getSubject().getPrincipal();
        String oldPwd = student.getStudentPassword();
        if (original.isEmpty() || !original.equals(oldPwd)||"".equals(original.trim())) {
            resultVo.setCode(302);
            resultVo.setMsg("原来密码不正确");
            return resultVo;
        }

        // 判断密码是否为空
        if (password.isEmpty() || "".equals(password.trim())) {
            resultVo.setCode(303);
            resultVo.setMsg("密码不能为空");
            return resultVo;
        }

        // 判断两次密码是否一致
        if (!password.equals(confirm)) {
            resultVo.setCode(304);
            resultVo.setMsg("两次密码不一致");
            return resultVo;
        }

        // 修改密码，对密码进行加密

        student.setStudentPassword(password);


        // 保存数据
        if(studentMapper.updateById(student)!=0){
            resultVo.setCode(200);
            resultVo.setMsg("修改成功");
            return resultVo;
        };//修改数据库
        resultVo.setCode(307);
        resultVo.setMsg("修改失败");
        return resultVo;
    }

    @Override
    public ResultVo buildings(Integer number) {
        ResultVo resultVo=new ResultVo();
        if (number==null){
            //如果不带参数访问，默认访问楼列表
            List<Building> building = buildingMapper.selectList(null);
            resultVo.setCode(200);
            resultVo.setMsg("查询成功");
            resultVo.setData(building);
            return resultVo;
        }
        if ((number != 1) &&(number != 2)&&(number != 3) && (number != 4) && (number != 5)){
            resultVo.setCode(305);
            resultVo.setMsg("楼号非法");

            return resultVo;
        }

//        带参数访问，则访问剩余床位数量

        QueryWrapper<Bed> wrapper = new QueryWrapper<>();
        wrapper.eq("Building_ID",number);
        wrapper.eq("Available",1);
        Integer Remain = bedMapper.selectCount(wrapper);
        resultVo.setCode(200);
        resultVo.setMsg("查询成功");
        resultVo.setData(Remain);
        return resultVo;
    }


}
