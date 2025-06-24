package com.danielsilveira.model.dao;

import com.danielsilveira.db.DB;
import com.danielsilveira.model.dao.impl.SellerDaoJDBC;
import com.danielsilveira.model.entities.Seller;

public class DaoFactory {
    public static Dao<Seller> createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
