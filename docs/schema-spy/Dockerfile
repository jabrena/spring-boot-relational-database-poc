FROM openjdk:11

RUN apt-get update && apt-get install -y graphviz \
&& apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN wget http://sourceforge.net/projects/schemaspy/files/schemaspy/SchemaSpy%205.0.0/schemaSpy_5.0.0.jar/download -O schemaSpy.jar
RUN wget https://jdbc.postgresql.org/download/postgresql-42.5.4.jar -O postgresql-jdbc4.jar

VOLUME /output

ENTRYPOINT [ "java", "-jar", "schemaSpy.jar", "-t", "pgsql", "-o", "./output", "-host", "sakiladb", "-port", "5432", "-dp", "postgresql-jdbc4.jar", "-db", "postgres", "-u", "postgres", "-p", "sakila",  "-s", "public" ]

#java -jar schemaSpy.jar -t "pgsql" -o "./spy_data" \
#    -host "localhost" -port "5432" -dp "postgresql-42.5.4.jar" \
#    -db "postgres" -u "postgres" -p "sakila" -s "public"
