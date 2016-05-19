package com.metaboy.athena.service.impl;

import com.metaboy.athena.dao.ProductMapper;
import com.metaboy.athena.dao.ProductRoleMapper;
import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Product;
import com.metaboy.athena.model.ProductRole;
import com.metaboy.athena.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebFault;
import java.util.Collections;
import java.util.List;

/**
 * Created by metaboy on 16/5/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRoleMapper productRoleMapper;

    @Override
    public Long addProduct(Product product) {
        int ret = productMapper.addProduct(product);
        if (ret == 1) {
            return product.getId();
        } else {
            return -1L;
        }
    }

    @Override
    public int modifyProductInfo(Product product) {
        return productMapper.modifyProduct(product);
    }

    public int deleteProduct(Long productId) {
        return productMapper.deleteProduct(productId);
    }

    @Override
    public int deleteProductByName(String productName) {
        return productMapper.deleteProductByName(productName);
    }

    @Override
    public int removeProduct(Long productId) {
        return productMapper.removeProduct(productId);
    }

    @Override
    public Product getProductById(Long productId) {
        return productMapper.getProductById(productId);
    }

    @Override
    public Page<Product> listProduct(Product search, int curPage, int pageSize) {
        Page<Product> page = new Page<Product>();
        page.setCurPage(curPage);
        page.setPageSize(pageSize);
        Integer count = productMapper.countSearchProduct(search);
        if (count > 0) {
            List<Product> list = productMapper.productPage(search, curPage * pageSize, pageSize);
            page.setResult(list);
            page.setTotalCount(count);
        } else {
            page.setResult(Collections.<Product>emptyList());
        }
        return page;
    }

    @Override
    public Integer addUser2Product(Long userId, Long productId, Integer role) {
        ProductRole productRole = new ProductRole();
        productRole.setProductId(productId);
        productRole.setUserId(userId);
        productRole.setRole(role);

        return productRoleMapper.addProductRole(productRole);
    }

    @Override
    public Integer removeUserInProduct(Long userId, Long productId) {
        ProductRole productRole = new ProductRole();
        productRole.setProductId(productId);
        productRole.setUserId(userId);

        return productRoleMapper.deleteProductRole(productRole);
    }

    @Override
    public Integer modifyUserRoleInProduct(Long userId, Long productId, Integer newRole) {
        ProductRole productRole = new ProductRole();
        productRole.setProductId(productId);
        productRole.setUserId(userId);
        productRole.setRole(newRole);

        return productRoleMapper.modifyProductRole(productRole);
    }

    @Override
    public int getUserRoleInProduct(Long userId, Long productId) {
        return productRoleMapper.getUserRoleInProduct(userId, productId);
    }

    @Override
    public List<ProductRole> listUserInProduct(Long productId) {
        return productRoleMapper.getProductRolesByProId(productId);
    }
}
