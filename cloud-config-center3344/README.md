# 引入 bus-amqp 后
#### 我们只需要通知配置中心微服务即可完成全部微服务的刷新
- http://localhost:3344/actuator/bus-refresh

#### 也可以差异化通知
- http://localhost:3344/actuator/bus-refresh/微服务名称:端口号