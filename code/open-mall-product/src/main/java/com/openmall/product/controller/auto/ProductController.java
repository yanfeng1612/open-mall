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

import com.openmall.product.domain.auto.Product;
import com.openmall.product.domain.auto.ProductQuery;
import com.openmall.product.service.auto.ProductService;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-14
 **/
@RestController
@RequestMapping(value = "/product", produces = "application/json; charset=utf-8")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/add")
    public Response<Product> add(@RequestBody Product product) {
        Response<Product> response = new Response<>();
        try {
            BasicResult result = productService.addProduct(product);
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
    public Response<Product> deleteById(Long id) {
        Response<Product> response = new Response<>();
        try {
            BasicResult result = productService.deleteById(id);
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
    public Response<Product> updateById(@RequestBody Product product) {
        Response<Product> response = new Response<>();
        try {
            BasicResult result = productService.updateProductById(product);
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
    public Response<PageListResult> list(@RequestBody PageQuery<ProductQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<Product> pageListResult = productService.searchPageProduct(query);
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
    public Response<Product> getProductById(@RequestBody Product product) {
        LOG.info("查询参数 {}",product) ;
        Response<Product> response = new Response<>();
        try {
            Product result = productService.searchProductById(product);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",product,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
