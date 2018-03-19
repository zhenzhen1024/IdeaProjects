package com.lz.sell.service.Impl;

import com.lz.sell.dataobject.ProductInfo;
import com.lz.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productService.findOne("123456");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAll() throws  Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
      //  System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("炸鸡排");
        productInfo.setProductPrice(new BigDecimal(10.5));
        productInfo.setProductDescription("鲜嫩多汁，又香又脆");
        productInfo.setProductStock(100);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductIcon("http://wwwbcjwn");
        productInfo.setCategoryType(2);

       ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}