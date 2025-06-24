package com.danielsilveira.model.dao.impl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danielsilveira.model.dao.Dao;
import com.danielsilveira.model.entities.Department;
import com.danielsilveira.model.entities.Seller;

@ExtendWith(MockitoExtension.class)
public class SellerDaoJDBCTest {
    Seller seller;

    @Mock
    Department department;
    @Mock
    Dao<Seller> sellerDao;

    @Test
    public void shouldReturnSeller() {
        Mockito.when(sellerDao.findById(3)).thenReturn(new Seller(3, "Daniel", "daniel@dev.com", new Date(), 3000.0, department));
        seller = sellerDao.findById(3);

        assertEquals(3, seller.getId());
    }
}
