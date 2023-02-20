package info.jab.ms.mybatis.generated.model;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FilmTable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer filmId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Object releaseYear;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short languageId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short originalLanguageId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short rentalDuration;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal rentalRate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Short length;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private BigDecimal replacementCost;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String rating;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Object specialFeatures;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Object fulltext;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getFilmId() {
        return filmId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Object getReleaseYear() {
        return releaseYear;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getLanguageId() {
        return languageId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLanguageId(Short languageId) {
        this.languageId = languageId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getOriginalLanguageId() {
        return originalLanguageId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOriginalLanguageId(Short originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getRentalDuration() {
        return rentalDuration;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Short getLength() {
        return length;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLength(Short length) {
        this.length = length;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRating() {
        return rating;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRating(String rating) {
        this.rating = rating == null ? null : rating.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Object getSpecialFeatures() {
        return specialFeatures;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSpecialFeatures(Object specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Object getFulltext() {
        return fulltext;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFulltext(Object fulltext) {
        this.fulltext = fulltext;
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
        FilmTable other = (FilmTable) that;
        return (this.getFilmId() == null ? other.getFilmId() == null : this.getFilmId().equals(other.getFilmId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getReleaseYear() == null ? other.getReleaseYear() == null : this.getReleaseYear().equals(other.getReleaseYear()))
            && (this.getLanguageId() == null ? other.getLanguageId() == null : this.getLanguageId().equals(other.getLanguageId()))
            && (this.getOriginalLanguageId() == null ? other.getOriginalLanguageId() == null : this.getOriginalLanguageId().equals(other.getOriginalLanguageId()))
            && (this.getRentalDuration() == null ? other.getRentalDuration() == null : this.getRentalDuration().equals(other.getRentalDuration()))
            && (this.getRentalRate() == null ? other.getRentalRate() == null : this.getRentalRate().equals(other.getRentalRate()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getReplacementCost() == null ? other.getReplacementCost() == null : this.getReplacementCost().equals(other.getReplacementCost()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()))
            && (this.getSpecialFeatures() == null ? other.getSpecialFeatures() == null : this.getSpecialFeatures().equals(other.getSpecialFeatures()))
            && (this.getFulltext() == null ? other.getFulltext() == null : this.getFulltext().equals(other.getFulltext()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFilmId() == null) ? 0 : getFilmId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getReleaseYear() == null) ? 0 : getReleaseYear().hashCode());
        result = prime * result + ((getLanguageId() == null) ? 0 : getLanguageId().hashCode());
        result = prime * result + ((getOriginalLanguageId() == null) ? 0 : getOriginalLanguageId().hashCode());
        result = prime * result + ((getRentalDuration() == null) ? 0 : getRentalDuration().hashCode());
        result = prime * result + ((getRentalRate() == null) ? 0 : getRentalRate().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getReplacementCost() == null) ? 0 : getReplacementCost().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getLastUpdate() == null) ? 0 : getLastUpdate().hashCode());
        result = prime * result + ((getSpecialFeatures() == null) ? 0 : getSpecialFeatures().hashCode());
        result = prime * result + ((getFulltext() == null) ? 0 : getFulltext().hashCode());
        return result;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", filmId=").append(filmId);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", releaseYear=").append(releaseYear);
        sb.append(", languageId=").append(languageId);
        sb.append(", originalLanguageId=").append(originalLanguageId);
        sb.append(", rentalDuration=").append(rentalDuration);
        sb.append(", rentalRate=").append(rentalRate);
        sb.append(", length=").append(length);
        sb.append(", replacementCost=").append(replacementCost);
        sb.append(", rating=").append(rating);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", specialFeatures=").append(specialFeatures);
        sb.append(", fulltext=").append(fulltext);
        sb.append("]");
        return sb.toString();
    }
}