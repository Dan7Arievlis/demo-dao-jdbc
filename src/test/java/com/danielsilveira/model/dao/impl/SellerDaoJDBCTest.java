package com.danielsilveira.model.dao.impl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danielsilveira.model.entities.Department;
import com.danielsilveira.model.entities.Seller;

@ExtendWith(MockitoExtension.class)
public class SellerDaoJDBCTest {
    @Mock
    SellerDaoJDBC sellerDao;
    @Mock
    Department department;

    @Test
    public void shouldReturnSeller() {
        Mockito.when(sellerDao.findById(3)).thenReturn(new Seller());
        Seller seller = sellerDao.findById(3);
        assertTrue(seller instanceof Seller);
    }

    @Test
    public void testFindByDepartment() {
        Mockito.when(sellerDao.findByDepartment(department)).thenReturn(Collections.singletonList(any(Seller.class)));
        List<Seller> sellers = sellerDao.findByDepartment(department);
        assertEquals(1, sellers.size());
    }
    
    @Test
    public void shouldReturnAllTheSellerTable() {
        Mockito.when(sellerDao.findAll()).thenReturn(Collections.nCopies(5, new Seller()));
        List<Seller> sellers = sellerDao.findAll();
        assertEquals(5, sellers.size());
    }
    @Test
    void testInsert() {
        Mockito.doNothing().when(sellerDao).insert(any(Seller.class));
        sellerDao.insert(new Seller());
        Mockito.verify(sellerDao).insert(any(Seller.class));
    }

    @Test
    void testUpdate() {
        Mockito.when(sellerDao.findById(1)).thenReturn(new Seller());
        Seller seller = sellerDao.findById(1);
        seller.setName("name teste");
        Mockito.doNothing().when(sellerDao).update(seller);
        sellerDao.update(seller);
        Mockito.verify(sellerDao).update(seller);
    }

    @Test
    void testDeleteById() {
        Mockito.doNothing().when(sellerDao).deleteById(1);
        sellerDao.deleteById(1);
        Mockito.verify(sellerDao).deleteById(1);
    }
}
