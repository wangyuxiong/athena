package com.metaboy.athena.dao;

import com.metaboy.athena.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by metaboy on 16/5/14.
 */
@Repository
public interface ProductMapper {

    Integer addProduct(Product product);

    Integer deleteProduct(Long userId);

    Integer deleteProductByName(@Param("productName") String productName);

    Integer removeProduct(Long productId);

    Integer modifyProduct(Product product);

    Product getProductById(Long productId);

//    List<Product> listProducts(@Param("product") Product productSearch);

    List<Product> productPage(@Param("product") Product productSearch,
                              @Param("offset") int offset,
                              @Param("pageSize") int pageSize);

    int countSearchProduct(@Param("product") Product productSearch);
}
