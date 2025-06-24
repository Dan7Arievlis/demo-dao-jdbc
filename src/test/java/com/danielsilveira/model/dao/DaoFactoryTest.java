package com.danielsilveira.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class DaoFactoryTest {
    SellerDao sellerDao;

    @Test
    void testCreateSellerDao() {
        sellerDao = DaoFactory.createSellerDao();
        assertNotNull(sellerDao);
    }
}
