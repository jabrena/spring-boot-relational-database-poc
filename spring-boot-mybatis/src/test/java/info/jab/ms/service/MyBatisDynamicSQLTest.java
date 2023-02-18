package info.jab.ms.service;

import info.jab.ms.commons.AbstractIntegrationTest;
import info.jab.ms.mybatis.generated.mapper.CountryMapper;
import info.jab.ms.mybatis.generated.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static info.jab.ms.mybatis.generated.mapper.CountryDynamicSqlSupport.country;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

@SpringBootTest
public class MyBatisDynamicSQLTest extends AbstractIntegrationTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void demo() {
        try (SqlSession session = sqlSessionFactory.openSession()) {

            SelectStatementProvider selectStatement = select(country.allColumns())
                    .from(country)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            CountryMapper mapper = session.getMapper(CountryMapper.class);
            List<Country> rows = mapper.selectMany(selectStatement);
            rows.stream().forEach(System.out::println);
        }
    }

}
