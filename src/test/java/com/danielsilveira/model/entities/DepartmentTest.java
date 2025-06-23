package com.danielsilveira.model.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danielsilveira.model.entitites.Department;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {
    @InjectMocks
    private Department department;

    @Test
    public void shouldCreateDepartment() {
        department = new Department();
        assertNotNull(department);
    }
}
