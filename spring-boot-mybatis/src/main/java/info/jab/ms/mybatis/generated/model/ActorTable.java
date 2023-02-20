package info.jab.ms.mybatis.generated.model;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class ActorTable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer actorId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String firstName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getActorId() {
        return actorId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFirstName() {
        return firstName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLastName() {
        return lastName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
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
        ActorTable other = (ActorTable) that;
        return (this.getActorId() == null ? other.getActorId() == null : this.getActorId().equals(other.getActorId()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getLastName() == null ? other.getLastName() == null : this.getLastName().equals(other.getLastName()))
            && (this.getLastUpdate() == null ? other.getLastUpdate() == null : this.getLastUpdate().equals(other.getLastUpdate()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActorId() == null) ? 0 : getActorId().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getLastName() == null) ? 0 : getLastName().hashCode());
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
        sb.append(", actorId=").append(actorId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append("]");
        return sb.toString();
    }
}