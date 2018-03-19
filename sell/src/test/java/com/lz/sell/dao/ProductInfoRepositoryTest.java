package com.lz.sell.dao;

import com.lz.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("鸡米花");
        productInfo.setProductPrice(new BigDecimal(7.5));
        productInfo.setProductDescription("鲜嫩多汁，又香又脆");
        productInfo.setProductStock(100);
        productInfo.setProductStatus(0);
        productInfo.setProductIcon("http://wwwbcjwn");
        productInfo.setCategoryType(2);

       ProductInfo result =  repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotNull(list);
    }
}