package com.metaboy.athena.service;

import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Product;

/**
 * Created by metaboy on 16/5/15.
 */
public interface ProductService {

    Long addProduct(Product product);

    Product getProductById(Long productId);

    Page<Product> listProduct(Product search, int curPage, int pageSize);

    Integer addUser2Product(Long userId, Long productId, Integer role);

    Integer removeUserInProduct(Long userId, Long productId);

    Integer modifyUserRoleInProduct(Long userId, Long productId, Integer newRole);
}
