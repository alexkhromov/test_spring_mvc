DROP USER team1test CASCADE;
CREATE USER team1test IDENTIFIED BY team1test;
GRANT CONNECT, RESOURCE, DBA TO team1test;
CONNECT team1test/team1test;
EXIT;