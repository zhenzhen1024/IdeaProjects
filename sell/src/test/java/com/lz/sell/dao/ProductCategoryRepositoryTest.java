package com.lz.sell.dao;

import com.lz.sell.dataobject.ProductCategory;
import com.lz.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    @Transactional
    public void  findOneTest(){
        ProductCategory productCategory = productCategoryRepository.getOne(1);
        System.out.print(productCategory);
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = productCategoryRepository.findOne(3);
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryId(3);
//        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(10);
        productCategoryRepository.save(productCategory);
//        productCategory = productCategoryRepository.getOne(3);
//        Assert.assertEquals("10",productCategory.getCategoryType());
    }

    @Test
    public void findByCategoryTypeInTest() {

        List<Integer> list = Arrays.asList(1,2,3);
       List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        System.out.println(result);
    }
}