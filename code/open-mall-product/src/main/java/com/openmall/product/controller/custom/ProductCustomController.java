package com.openmall.product.controller.custom;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.service.custom.ProductCustomService;
import com.openmall.product.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product/custom", produces = "application/json; charset=utf-8")
public class ProductCustomController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCustomController.class);

    @Autowired
    private ProductCustomService productCustomService;

    @RequestMapping(value = "/insert")
    public Response<Product> add(Product product) {
        Response<Product> response = new Response<>();
        try {
            BasicResult result = productCustomService.addProduct(product);
//            APIMsgCode apiMsgCode = CodeConverter.convert(result.getCode());
            response.setCode(result.getCode());
            response.setMessage(result.getMsg());
//            return response;
        } catch (Exception e) {
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setMessage(APIMsgCode.FAILURE.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        return response;
    }
}
