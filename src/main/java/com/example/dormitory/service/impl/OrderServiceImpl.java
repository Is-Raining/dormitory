package com.example.dormitory.service.impl;

import com.example.dormitory.entity.Order;
import com.example.dormitory.mapper.OrderMapper;
import com.example.dormitory.service.OrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
