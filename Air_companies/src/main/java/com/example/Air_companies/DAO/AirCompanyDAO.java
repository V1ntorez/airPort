package com.example.Air_companies.DAO;

import com.example.Air_companies.models.AirCompany;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirCompanyDAO {

    private final JdbcTemplate jdbcTemplate;

    public AirCompanyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createNewAirCompany(AirCompany airCompany){
        jdbcTemplate.update("INSERT into airCompany (name,companyType,foundedAt)" +
                " values (?,?,?)",airCompany.getName(),
                airCompany.getCompanyType(),airCompany.getFoundedAt());
    }

    public List<AirCompany> getAllAirCompanies(){
        return jdbcTemplate.query("SELECT * from aircompany ",new AirCompanyMapper());
    }

    public AirCompany getAirCompany(int id){
        return jdbcTemplate.query("SELECT * from aircompany where id=?",new AirCompanyMapper(),id)
                .stream().findAny().orElse(null);
    }

    public void updateAirCompany(AirCompany airCompany,int id){
        jdbcTemplate.update("UPDATE aircompany SET name=?,companytype=?,foundedat=? where id=?",
                airCompany.getName(),airCompany.getCompanyType(),airCompany.getFoundedAt(),id);
    }

    public void deleteAirCompany(int id){
        jdbcTemplate.update("DELETE FROM aircompany where id=?", id);
    }

}
