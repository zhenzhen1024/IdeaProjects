package com.lz.sell.controller;

import com.lz.sell.VO.ProductInfoVO;
import com.lz.sell.VO.ProductVO;
import com.lz.sell.VO.ResultVO;
import com.lz.sell.dataobject.ProductCategory;
import com.lz.sell.dataobject.ProductInfo;
import com.lz.sell.service.CategoryService;
import com.lz.sell.service.Impl.ProductServiceImpl;
import com.lz.sell.service.ProductService;
import com.lz.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductControl {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list")
    public ResultVO list() {

        //1、查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2、查询类目（一次查询）
        List<Integer> categroyTypeList = new ArrayList<>();
        for(ProductInfo productInfo : productInfoList) {
           categroyTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categroyTypeList);
        //3、数据拼装

            List<ProductVO> productVOList = new ArrayList<>();
        for( ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = ResultVOUtil.success(productVOList);
        return  resultVO;
}
}
