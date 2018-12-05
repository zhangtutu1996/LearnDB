### 数据库查找进程（用于杀掉堵塞进程）
```
select CONCAT('KILL ',id,';') from 
information_schema.`PROCESSLIST` where DB = '???';
```

### request.getParameter() 中URL参数乱码
 * Http请求传输时将url以ISO-8859-1编码，服务器收到字节流后默认会以ISO-8859-1编码来解码成字符流（造成中文乱码）
 * 解决：
 
 ``` 
 new String (request.getParameter("supplierType").getBytes("iso-8859-1"), "utf-8")
 ```
 
 ### 用于js Array的remove()方法
 * 类似java remove方法dx要移除的下标（移除后Array length-1）
 
 ``` JavaScript
 Array.prototype.remove = function (dx) {
    if (isNaN(dx) || dx > this.length) { return false; }
    for (var i = 0, n = 0; i < this.length; i++) {
        if (this[i] != this[dx]) {
            this[n++] = this[i]
        }
    }
    this.length -= 1
}
 ```
