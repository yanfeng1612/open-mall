package com.openmall.product.service.impl.custom;

import com.openmall.product.domain.auto.Product;
import com.openmall.product.manager.auto.ProductManager;
import com.openmall.product.manager.custom.ProductCustomManager;
import com.openmall.product.service.custom.ProductCustomService;
import com.openmall.product.utils.BasicResult;
import com.openmall.product.utils.CodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service("ProductCustomService")
public class ProductCustomServiceImpl implements ProductCustomService {

    private final static Logger LOG = LoggerFactory.getLogger(ProductCustomServiceImpl.class);

    @Autowired
    private ProductCustomManager productCustomManager;

    /**
     * add
     */
    @Override
    public BasicResult addProduct(Product product) {
        BasicResult result = new BasicResult();
        try {
            if (product != null) {
                productCustomManager.addProduct(product);
                result.setCode(CodeEnum.SUCCESS.getCode());
                result.setMsg("保存成功");
            } else {
                result.setCode(CodeEnum.FAILED.getCode());
                result.setMsg("product is null");
                LOG.error("------ProductServiceImpl.addProduct - product is null!");
            }
        } catch (DuplicateKeyException e) {
            result.setCode(CodeEnum.DUPLICATE.getCode());
            result.setMsg(CodeEnum.DUPLICATE.getMessage());
            LOG.error("------ProductServiceImpl.addProduct 异常",e);
        } catch (Exception e) {
            result.setCode(CodeEnum.FAILED.getCode());
            result.setMsg("未知异常" + e.getMessage());
            LOG.error("------ProductServiceImpl.addProduct 异常",e);
        }
        return result;
    }


}
