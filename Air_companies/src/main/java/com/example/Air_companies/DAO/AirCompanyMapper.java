package com.example.Air_companies.DAO;

import com.example.Air_companies.models.AirCompany;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class AirCompanyMapper implements RowMapper<AirCompany> {
    @Override
    public AirCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
        AirCompany airCompany = new AirCompany();

        airCompany.setCompanyType(rs.getString("companyType"));
        airCompany.setID(rs.getInt("id"));
        airCompany.setFoundedAt(rs.getDate("foundedAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        airCompany.setName(rs.getString("name"));

        return airCompany;
    }
}
