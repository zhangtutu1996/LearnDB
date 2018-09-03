*  数据库查找进程（用于杀掉堵塞进程）
```
select CONCAT('KILL ',id,';') from 
information_schema.`PROCESSLIST` where DB = '???';
```