package com.danielsilveira.model.dao;

import com.danielsilveira.model.dao.impl.DaoJDBC;
import com.danielsilveira.model.entities.Department;
import com.danielsilveira.model.entities.Seller;

public class DaoFactory {
    public static Dao<Seller> createSellerDao() {
        return new DaoJDBC<Seller>();
    }

    public static Dao<Department> createDepartmentDao() {
        return new DaoJDBC<Department>();
    }
}
