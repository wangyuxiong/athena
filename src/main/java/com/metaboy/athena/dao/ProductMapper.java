package com.metaboy.athena.dao;

import com.metaboy.athena.model.Product;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by metaboy on 16/5/14.
 */
@Repository
public interface ProductMapper {

    Integer addProduct(Product product);

    Integer removeProduct(Long productId);

    Integer deleteProduct(Long userId);

    Integer modifyProduct(Product product);

    Product getProductById(Long productId);

    List<Product> listProducts(@Param("product") Product product);
}
