# springmvcjpa
sample spring mvc jpa project using hypersql embedded dbengine;

to make the database connection work, adjust the connection string in the file app.properties;
also you need to run schema-hsql.sql on the database, to create the needed schema

note that in embedded mode an exclusive lock is used on the db file, which means that in case
you are running this sample web app and in the same time you are trying to connect to the db file
using a tool or script, you will get a connection failure (i.e connection time-out)