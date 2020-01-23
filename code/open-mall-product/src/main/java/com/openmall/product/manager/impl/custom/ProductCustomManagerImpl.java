package com.openmall.product.manager.impl.custom;

import com.openmall.product.dao.custom.ProductCustomMapper;
import com.openmall.product.domain.auto.Product;
import com.openmall.product.manager.custom.ProductCustomManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ProductCustomManager")
public class ProductCustomManagerImpl implements ProductCustomManager {

    private final static Logger logger = LoggerFactory.getLogger(ProductCustomManagerImpl.class);

    @Autowired
    private ProductCustomMapper productMapper;

    /**
     * add
     */
    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }
}
