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

import com.openmall.product.domain.auto.ProductBrand;
import com.openmall.product.domain.auto.ProductBrandQuery;
import com.openmall.product.service.auto.ProductBrandService;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-12
 **/
@RestController
@RequestMapping(value = "/productBrand", produces = "application/json; charset=utf-8")
public class ProductBrandController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductBrandController.class);

    @Autowired
    private ProductBrandService productBrandService;

    @RequestMapping(value = "/add")
    public Response<ProductBrand> add(@RequestBody ProductBrand productBrand) {
        Response<ProductBrand> response = new Response<>();
        try {
            BasicResult result = productBrandService.addProductBrand(productBrand);
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
    public Response<ProductBrand> deleteById(Long id) {
        Response<ProductBrand> response = new Response<>();
        try {
            BasicResult result = productBrandService.deleteById(id);
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
    public Response<ProductBrand> updateById(@RequestBody ProductBrand productBrand) {
        Response<ProductBrand> response = new Response<>();
        try {
            BasicResult result = productBrandService.updateProductBrandById(productBrand);
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
    public Response<PageListResult> list(@RequestBody PageQuery<ProductBrandQuery> query) {
        try {
            LOG.info("分页查询数据参数信息req: {}", JSON.toJSONString(query));
            PageListResult<ProductBrand> pageListResult = productBrandService.searchPageProductBrand(query);
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
    public Response<ProductBrand> getProductBrandById(@RequestBody ProductBrand productBrand) {
        LOG.info("查询参数 {}",productBrand) ;
        Response<ProductBrand> response = new Response<>();
        try {
            ProductBrand result = productBrandService.searchProductBrandById(productBrand);
            return ResponseTemplate.getResponse(APIMsgCode.SUCCESS, result);
        } catch (Exception e) {
            LOG.error("查询数据异常:{}",productBrand,e);
            response = ResponseTemplate.FAILURE.getResponse(null);
        }
        return response;
    }

}
