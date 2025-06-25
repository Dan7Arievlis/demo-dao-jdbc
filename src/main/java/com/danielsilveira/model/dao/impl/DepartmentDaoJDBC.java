package com.danielsilveira.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.danielsilveira.db.DB;
import com.danielsilveira.db.DbException;
import com.danielsilveira.model.dao.DepartmentDao;
import com.danielsilveira.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
    private final Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                """
                    INSERT INTO department
                    (Name)
                    VALUES
                    (?)
                """, Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                """
                    UPDATE department
                    SET Name = ?
                    WHERE Id = ?
                """);
            
            st.setString(1, obj.getName());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                """
                    DELETE FROM department
                    WHERE Id = ?
                """);
            
                st.setInt(1, id);
                st.executeUpdate();
        } catch(SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                """
                    SELECT department.*
                    WHERE Id = ?
                """);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department department = instantiateDepartment(rs);

                return department;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                """
                    SELECT department.*
                    ORDER BY Name
                """);
            rs = st.executeQuery();

            List<Department> departments = new ArrayList<>();

            while (rs.next()) {
                Department department = instantiateDepartment(rs);
                departments.add(department);
            }
            return departments;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));

        return department;
    }

}
