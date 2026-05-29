package com.example.backend.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;

import com.example.backend.model.CalculationHistoryRequest;
import com.example.backend.model.Calculation;

@Repository
public class CalculationHistoryRepository {

    private static final String SQL_SELECT_PAGINATION = "SELECT * FROM calculation ORDER BY id LIMIT :SIZE OFFSET :OFFSET";
    private final JdbcTemplate jdbcTemplate;

    public CalculationHistoryRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Calculation> getListOfCalculations(CalculationHistoryRequest request) {
        int page = request.getPage();
        int size = request.getSize();
        int offset = page * size;

        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("SIZE", size)
            .addValue("OFFSET", offset);

        return new NamedParameterJdbcTemplate(Objects.requireNonNull(jdbcTemplate.getDataSource())).query(SQL_SELECT_PAGINATION, parameterSource, (result, rowNum) -> {
            Calculation c  = new Calculation();

            c.setId(result.getInt("id"));
            c.setNum1(result.getDouble("num1"));
            c.setNum2(result.getDouble("num2"));
            c.setOperation(result.getString("operation"));
            c.setResult(result.getDouble("result"));

            return c;

        });

    }
    
}
