package com.example.dormitory.controller;


import com.example.dormitory.form.RuleForm;
import com.example.dormitory.service.StudentService;
import com.example.dormitory.vo.ResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 跳转到登录页面
     */


    @PostMapping("/login")
    public ResultVo login(RuleForm ruleForm){
        return this.studentService.login(ruleForm);
    }

//    @GetMapping("/info")
//    public ResultVo infor(UsernamePasswordToken token){
//
//        return this.studentService.infor(token);
//    }
    /**
     * 跳转到个人信息页面
     */
    @GetMapping("/userInfo")
    @RequiresAuthentication
    public ResultVo toInfo(){
        ResultVo resultVo = studentService.toInfo();
        return resultVo;
    }

    @RequestMapping("/Hello")
    public ResultVo unLogged(){
        return this.studentService.unLogged();
    }
    /**
    *退出登录
    **/
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    /**
     *修改密码
     **/
    @PostMapping("/editPwd")
    public ResultVo editPwd(String original, String password, String confirm){
        return this.studentService.editPwd(original,password,confirm);
    }
    /**
     *获取可以选宿舍楼列表
     **/
    @GetMapping("/buildings")
    public ResultVo buildings(Integer number){

        return this.studentService.buildings(number);
    }


    /**
     *获取每个楼的空余床位总数
     **/

}

