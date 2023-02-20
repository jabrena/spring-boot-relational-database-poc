package info.jab.ms.mybatis.generated.model;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class CityTable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer cityId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String city;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short countryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCityId() {
        return cityId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCity() {
        return city;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getCountryId() {
        return countryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CityTable other = (CityTable) that;
        return (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCountryId() == null ? other.getCountryId() == null : this.getCountryId().equals(other.getCountryId()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCountryId() == null) ? 0 : getCountryId().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", city=").append(city);
        sb.append(", countryId=").append(countryId);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append("]");
        return sb.toString();
    }
}