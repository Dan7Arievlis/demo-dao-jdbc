package com.danielsilveira.model.dao.impl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danielsilveira.model.dao.DaoFactory;
import com.danielsilveira.model.dao.SellerDao;
import com.danielsilveira.model.entities.Department;
import com.danielsilveira.model.entities.Seller;

@ExtendWith(MockitoExtension.class)
public class SellerDaoJDBCTest {
    Seller seller;
    SellerDao sellerDao;

    @Test
    public void shouldReturnSeller() {
        // Mockito.when(sellerDao.findById(3)).thenReturn(new Seller(3, "Daniel", "daniel@dev.com", new Date(), 3000.0, department));
        sellerDao = DaoFactory.createSellerDao();
        seller = sellerDao.findById(3);

        assertTrue(seller instanceof Seller);
    }

    @Test
    public void testFindByDepartment() {
        sellerDao = DaoFactory.createSellerDao();
        Department dep = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        assertEquals(2, sellers.size());
    }

    @Test
    public void shouldReturnAllTheSellerTable() {
        sellerDao = DaoFactory.createSellerDao();
        List<Seller> sellers = sellerDao.findAll();
        assertTrue(!sellers.isEmpty());
    }
}
