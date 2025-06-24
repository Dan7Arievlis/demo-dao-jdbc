package com.danielsilveira.model.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {
    private Department department;

    @Test
    public void shouldCreateDepartment() {
        department = new Department(1, "Tecnologia");
        assertNotNull(department);
    }
}
