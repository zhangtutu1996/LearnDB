### HDFS架构

1个Master(NameNode/NN)  带 N个Slaves(DataNode/DN)

### 存储

1个文件会被拆分成多个Block

blocksize：128M
130M ==> 2个Block： 128M 和 2M

##### NameNode：

* 负责客户端请求的响应
* 负责元数据（文件的名称、副本系数、Block存放的DN）的管理

##### DataNode：
* 存储用户的文件对应的数据块(Block)
* 要定期向NN发送心跳信息，汇报本身及其所有的block信息，健康状况


###### NameNode + N个DataNode

* A typical deployment has a dedicated machine that runs only the NameNode software. 
Each of the other machines in the cluster runs one instance of the DataNode software.
The architecture does not preclude running multiple DataNodes on the same machine 
but in a real deployment that is rarely the case.

tips：NN和DN是部署在不同的节点上  
 
