//package com.calapp;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(OrderAnnotation.class)
//class ProductServiceTest {
//
//    static ProductService service;
//    static Long productId;
//
//    @BeforeAll
//    static void setupOnce() {
//        service = new ProductService();
//    }
//
//    @Test
//    @Order(1)
//    @DisplayName("ADD product")
//    void addProduct() {
//        Product p = new Product(null, "Laptop", 50000);
//
//        Product saved = service.add(p);
//
//        assertNotNull(saved.getId());
//        productId = saved.getId();
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("GET ALL products")
//    void getAllProducts() {
//        assertFalse(service.getAll().isEmpty());
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("FIND product by id")
//    void findProduct() {
//        Product p = service.findById(productId);
//        assertEquals("Laptop", p.getName());
//    }
//
//    @Test
//    @Order(4)
//    @DisplayName("UPDATE product")
//    void updateProduct() {
//        Product updated =
//                service.update(productId, new Product(null, "Gaming Laptop", 75000));
//
//        assertEquals("Gaming Laptop", updated.getName());
//    }
//
//    @Test
//    @Order(5)
//    @DisplayName("DELETE product")
//    void deleteProduct() {
//        service.delete(productId);
//        assertTrue(service.getAll().isEmpty());
//    }
//}
