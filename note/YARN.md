### YARN基础

* ResourceManager
 
	整个集群同一时间提供服务的RM只有一个，负责集群资源的统一管理和调度
	处理客户端的请求： 提交一个作业、杀死一个作业
	监控我们的NM，一旦某个NM挂了，那么该NM上运行的任务需要告诉我们的AM来如何进行处理

* NodeManager 
 
	整个集群中有多个，负责自己本身节点资源管理和使用
	定时向RM汇报本节点的资源使用情况
	接收并处理来自RM的各种命令：启动Container
	处理来自AM的命令
	单个节点的资源管理

* ApplicationMaster
 
	每个应用程序对应一个：MR、Spark，负责应用程序的管理
	为应用程序向RM申请资源（core、memory），分配给内部task
	需要与NM通信：启动/停止task，task是运行在container里面，AM也是运行在container里面

* Container

	封装了CPU、Memory等资源的一个容器
	是一个任务运行环境的抽象