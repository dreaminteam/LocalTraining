package by.training.java.grodno.az.data.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.training.java.grodno.az.data.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//			int id = rs.getInt("id");
//			int userId=rs.getInt("user_id");
////			Character role=rs.getCharacterStream("role");
			Employee employee = new Employee();
//			employee.setId(id);
			

			return employee;
		}
	}
