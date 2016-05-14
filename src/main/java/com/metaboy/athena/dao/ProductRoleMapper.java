package com.metaboy.athena.dao;

import com.metaboy.athena.model.ProductRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by metaboy on 16/5/14.
 */
@Repository
public interface ProductRoleMapper {
    Integer addProductRole(ProductRole productRole);

    Integer deleteProductRole(ProductRole productRole);

    Integer modifyProductRole(ProductRole productRole);

    List<ProductRole> getProductRolesByProId(Long productId);
}
