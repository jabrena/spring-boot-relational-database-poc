# MyBatis review

## Dependencies

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.1</version>
</dependency>

<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.2</version>
</plugin>

<dependency>
    <groupId>org.mybatis.dynamic-sql</groupId>
    <artifactId>mybatis-dynamic-sql</artifactId>
    <version>1.4.1</version>
</dependency>
```

## Features

- CRUD
- INSERT & RETURN key

## Lessons learnt

**Approaches:**

- Free: Develop queries from Mappers
- Model generated: Generate Model & Mappers from database
- SQL Client: It is possible to add a new client from model generated

## Doubts

- How to log the SQL?
- How to insert and return an ID using InsertStatementProvider?
- How to avoid Short?
- How to store in targetProject="spring-boot-mybatis/target/generated-sources" ?

## References

- https://mybatis.org/spring/
- http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
- https://mybatis.org/generator/running/runningWithMaven.html
- https://mybatis.org/generator/configreference/context.html
- https://mybatis.org/generator/reference/plugins.html
- https://mybatis.org/mybatis-dynamic-sql/docs/insert.html
- https://github.com/mybatis/mybatis-dynamic-sql/blob/master/src/test/java/examples/spring/PersonTemplateTest.java
- https://mybatis.org/mybatis-dynamic-sql/docs/conditions.html
