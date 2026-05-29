package com.example.backend.repository;

import com.example.backend.model.Calculation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Objects;

@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository {
    private static final String NUM1 = "NUM1";
    private static final String NUM2 = "NUM2";
    private static final String OPERATION = "OPERATION";
    private static final String RESULT = "RESULT";
    //Insert new row for calculations table containing values
    private static final String SQL_INSERT_CALCULATION = "INSERT INTO calculation (num1, num2, operation, result) " + "VALUES (:NUM1, :NUM2, :OPERATION, :RESULT)";
    
    private final JdbcTemplate jdbcTemplate;

    public CalculatorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Calculation calculation) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue(NUM1, calculation.getNum1())
            .addValue(NUM2, calculation.getNum2())
            .addValue(OPERATION, calculation.getOperation())
            .addValue(RESULT, calculation.getResult());
        
        return new NamedParameterJdbcTemplate(Objects.requireNonNull(jdbcTemplate.getDataSource())).update(SQL_INSERT_CALCULATION, parameterSource);
    }

}





