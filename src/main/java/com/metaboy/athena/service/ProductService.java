package com.metaboy.athena.service;

import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Product;
import com.metaboy.athena.model.ProductRole;

import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
public interface ProductService {

    Long addProduct(Product product);

    int modifyProductInfo(Product product);

    int deleteProduct(Long productId);

    int deleteProductByName(String productName);

    int removeProduct(Long productId);

    Product getProductById(Long productId);

    Page<Product> listProduct(Product search, int curPage, int pageSize);

    Integer addUser2Product(Long userId, Long productId, Integer role);

    Integer removeUserInProduct(Long userId, Long productId);

    Integer modifyUserRoleInProduct(Long userId, Long productId, Integer newRole);

    int getUserRoleInProduct(Long userId, Long productId);

    List<ProductRole> listUserInProduct(Long productId);
}
