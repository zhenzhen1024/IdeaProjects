package com.lz.sell.service.Impl;

import com.lz.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception{
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> typeList = Arrays.asList(1,2,10);
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(typeList);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("女生最爱",6);
        ProductCategory productCategory1 = categoryService.save(productCategory);
        Assert.assertNotNull(productCategory1);
    }
}