package com.danielsilveira.model.entities;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SellerTest {
    private Seller seller;

    @Mock
    private Department department;

    @Test
    public void shouldCreateNewSeller() {
        seller = new Seller(1, "Daniel", "daniel@dev.com", new Date(), 3000.0, department);
        assertNotNull(seller);
    }
}
