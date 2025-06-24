package com.danielsilveira.model.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.danielsilveira.model.entities.Seller;

public class DaoFactoryTest {
    Dao<Seller> sellerDao;

    @Test
    void testCreateSellerDao() {
        sellerDao = DaoFactory.createSellerDao();
        assertNotNull(sellerDao);
    }
}
