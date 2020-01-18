package com.openmall.product.controller.auto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import com.openmall.product.utils.*;

import com.openmall.product.domain.auto.ProductCategory;
import com.openmall.product.domain.auto.ProductCategoryQuery;
import com.openmall.product.service.auto.ProductCategoryService;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-18
 **/
@RestController
@RequestMapping(value = "/productCategory", produces = "application/json; charset=utf-8")
public class ProductCategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/add")
    public Response<ProductCategory> add(@RequestBody ProductCategory productCategory) {
        Response<ProductCategory> response = new Response<>();
        try {
            BasicResult result = productCategoryService.addProductCategory(productCategory);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/deleteById")
    public Response<ProductCategory> deleteById(Long id) {
        Response<ProductCategory> response = new Response<>();
        try {
            BasicResult result = productCategoryService.deleteById(id);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    @RequestMapping(value = "/updateById")
    public Response<ProductCategory> updateById(@RequestBody ProductCategory productCategory) {
        Response<ProductCategory> response = new Response<>();
        try {
            BasicResult result = productCategoryService.updateProductCategoryById(productCategory);
            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, null);
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }

    /**
     * 查询数据列表
     */
    @RequestMapping("/list")
    public Response<PageListResult> list(@RequestBody PageQuery<ProductCategoryQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<ProductCategory> pageListResult = productCategoryService.searchPageProductCategory(query);
            LOG.info("分页查询数据参数信息resp: {}-{}", pageListResult.getCode(), JSON.toJSONString(pageListResult.getPagenation()));
            APIMsgCode apiMsgCode = CodeConverter.convert(pageListResult.getCode());
            return ResponseTemplate.getResponse(apiMsgCode, pageListResult);
        } catch (Exception e) {
            LOG.error("分页查询数据参数信息exception: ", e);
        }
        return ResponseTemplate.FAILURE.getResponse(null);
    }

    /**
     * 查询数据详情
     */
    @RequestMapping(value = "/detail", method = {RequestMethod.POST,RequestMethod.GET})
    public Response<ProductCategory> getProductCategoryById(@RequestBody ProductCategory productCategory) {
        LOG.info("查询参数 {}",productCategory) ;
        Response<ProductCategory> response = new Response<>();
        try {
            ProductCategory result = productCategoryService.searchProductCategoryById(productCategory);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",productCategory,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
