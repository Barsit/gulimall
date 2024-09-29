package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2024-09-27 16:58:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
