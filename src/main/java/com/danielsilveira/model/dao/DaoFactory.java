package com.danielsilveira.model.dao;

import com.danielsilveira.db.DB;
import com.danielsilveira.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
