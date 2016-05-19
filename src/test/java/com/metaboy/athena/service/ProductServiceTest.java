package com.metaboy.athena.service;

import com.metaboy.athena.model.Constant.RoleType;
import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Product;
import com.metaboy.athena.model.ProductRole;
import com.metaboy.athena.model.User;
import com.metaboy.athena.service.ProductService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by metaboy on 16/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/spring.xml")
public class ProductServiceTest {

    private static String productName = "test_product";
    @Autowired
    ProductService productService;
    @Autowired
    private UserService userService;
    private Long userId;

    @Before
    public void setUp() throws Exception {
        productService.deleteProductByName(productName);

        User user = new User();
        String userName = "metaboy_test";
        String passwd = "test";
        String email = "yxiong.wang@gmail.com";

        user.setUserName(userName);
        user.setPasswd(passwd);
        user.setEmail(email);

        userId = userService.addUser(user);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userId);
    }

    @Test
    public void testProductService() {
        System.out.println("start to test .......");
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDesc("test_product_desc");
        product.setProductType(1);

        Long productId = productService.addProduct(product);
        System.out.println(product.toString());
        Assert.assertTrue(productId > 0);

        Product productGetMethod = productService.getProductById(productId);
        Assert.assertEquals(productGetMethod.getProductName(), product.getProductName());
        Assert.assertEquals(productGetMethod.getProductDesc(), product.getProductDesc());
        Assert.assertEquals(productGetMethod.getProductType(), product.getProductType());

        productGetMethod.setProductDesc("");
        int ret = productService.modifyProductInfo(productGetMethod);
        Assert.assertEquals(1, ret);

        Product search = new Product();
        search.setStatus(0);
        Page<Product> productPage = productService.listProduct(search, 1, 5);
        Assert.assertEquals(1, productPage.getTotalCount());

        System.out.println("start to add user role");
        ret = productService.addUser2Product(userId, productId, RoleType.OWNER.getValue());
        Assert.assertEquals(ret, 1);
        int roleValue = productService.getUserRoleInProduct(userId, productId);
        Assert.assertEquals(roleValue, RoleType.OWNER.getValue());

        System.out.println("start to check modify user role");
        ret = productService.modifyUserRoleInProduct(userId, productId, RoleType.PM.getValue());
        Assert.assertEquals(ret, 1);

        System.out.println("start to check get user role");
        roleValue = productService.getUserRoleInProduct(userId, productId);
        Assert.assertEquals(roleValue, RoleType.PM.getValue());


        System.out.println("start to check list user role");
        List<ProductRole> pos = productService.listUserInProduct(productId);
        Assert.assertEquals(pos.size(), 1);

        System.out.println("start to check remove user role");
        ret = productService.removeUserInProduct(userId, productId);
        Assert.assertEquals(ret, 1);

        ret = productService.removeProduct(productId);
        Assert.assertEquals(ret, 1);

        Product productNotUsed = productService.getProductById(productId);
        Assert.assertEquals(productNotUsed.getStatus().intValue(), -1);

        ret = productService.deleteProduct(productId);
        Assert.assertEquals(ret, 1);
        Product productDelete = productService.getProductById(productId);
        Assert.assertNull(productDelete);
    }


}
