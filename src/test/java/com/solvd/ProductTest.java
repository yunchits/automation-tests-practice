package com.solvd;

import com.solvd.api.DeleteProduct;
import com.solvd.api.GetProductSearch;
import com.solvd.api.GetProductById;
import com.solvd.api.PostProduct;
import com.solvd.model.Product;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class ProductTest implements IAbstractTest {

    @Test
    public void testGetProductById() {
        Product product = new Product()
                .setId(1)
                .setTitle("iPhone 9")
                .setBrand("Apple")
                .setCategory("smartphones");

        GetProductById api = new GetProductById(product.getId());
        api.addProperty("product", product);
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testSearchProduct() {
        GetProductSearch api = new GetProductSearch("Laptop");
        api.setResponseTemplate("api/products/_get/laptops_rs.json");
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testSearchNonexistentProduct() {
        GetProductSearch api = new GetProductSearch("dummy");
        api.setResponseTemplate("api/products/_get/not_exist_category_rs.json");
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testCreateProduct() {
        PostProduct api = new PostProduct();
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testDeleteProduct() {
        DeleteProduct api = new DeleteProduct();
        api.callAPIExpectSuccess();
    }
}
