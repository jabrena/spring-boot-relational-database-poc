package info.jab.ms.service;

import info.jab.ms.model.CountryOld;
import info.jab.ms.mybatis.generated.mapper.CityTableMapper;
import info.jab.ms.mybatis.generated.mapper.CountryTableMapper;
import info.jab.ms.mybatis.generated.model.CityTable;
import info.jab.ms.repository.CountryMapperRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static info.jab.ms.mybatis.generated.mapper.CityTableDynamicSqlSupport.city;
import static info.jab.ms.mybatis.generated.mapper.CityTableDynamicSqlSupport.countryId;
import static info.jab.ms.mybatis.generated.mapper.CountryTableDynamicSqlSupport.lastUpdate;
import static org.mybatis.dynamic.sql.insert.InsertDSL.insert;

@Service
public class Feature3ServiceImpl implements Feature3Service {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CountryMapperRepository countryMapperRepository;

    @Autowired
    private CountryTableMapper countryMapper;

    @Autowired
    private CityTableMapper cityMapper;

    @Override
    public Long getCountryCounter() {
        return countryMapper.count(CountDSLCompleter.allRows());
    }

    @Override
    public Long getCityCounter() {
        return cityMapper.count(CountDSLCompleter.allRows());
    }

    @Transactional
    @Override
    public void addCountryAndCity(Boolean flag) {

        //TODO: How to Insert & Return an ID?
        /*
        var row = new CountryTable();
        row.setCountry("Tabarnia");
        row.setLastUpdate(LocalDateTime.now());

        InsertStatementProvider<CountryTable> insertStatement = insert(row)
                .into(SqlTable.of("country"))
                .map(country).toProperty("country")
                .map(lastUpdate).toProperty("lastUpdate")
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int rows = countryMapper.insert(insertStatement);
        */

        CountryOld countryToAdd = new CountryOld();
        countryToAdd.setCountry("Tabarnia");
        countryToAdd.setLast_update(LocalDateTime.now());
        countryMapperRepository.save(countryToAdd);

        System.out.println(countryToAdd);

        var id = countryToAdd.getCountry_id();

        try {
            var countryIdValue = (flag == Boolean.FALSE) ? id : 999L;

            var record = new CityTable();
            record.setCity("TabarniaCity");
            record.setCountryId((short) countryIdValue);
            record.setLastUpdate(LocalDateTime.now());

            InsertStatementProvider<CityTable> insertCity = insert(record)
                    .into(SqlTable.of("city"))
                    .map(city).toProperty("city")
                    .map(countryId).toProperty("countryId")
                    .map(lastUpdate).toProperty("lastUpdate")
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            int rows = cityMapper.insert(insertCity);

        } catch (DataAccessException ex) {
            System.out.println("Katakroker");
            throw new RuntimeException("Katakroker");
        }
    }
}
