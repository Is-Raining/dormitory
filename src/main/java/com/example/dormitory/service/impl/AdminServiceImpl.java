package com.example.dormitory.service.impl;

import com.example.dormitory.entity.Admin;
import com.example.dormitory.mapper.AdminMapper;
import com.example.dormitory.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiaozeng
 * @since 2022-10-12
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
