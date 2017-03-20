# Learning Cassandra
Here I will learn Cassandra, a great NoSQL database that will be used in the [DeepLIBRAS] research project :blue_heart:  

### This project uses
+ [Cassandra] 
+ [Java]
+ [Kundera]
+ [Maven]

### Configurations
+ Java 8
+ Cassandra 2.2.8: more stable and more recommended
+ CQL(Cassandra Query Language) 3.3.1
+ Kundera 3.7
+ Maven 3.0.5
---
In **cassandra.yaml:**  
```
start_rpc: true  
rpc_port: 9160
native_transport_port: 9042
```
### Run Project
To run it with Maven:
```
learning-cassandra$ mvn exec:java -Dexec.mainClass="local.cassie.app.Main"
```
To clean the project and load your changes:
```
learning-cassandra$ mvn clean compile
```

[Cassandra]: http://cassandra.apache.org/  
[DeepLIBRAS]: https://github.com/deeplibras  
[Java]: https://docs.oracle.com/javase/8/docs/ 
[Kundera]: https://github.com/impetus-opensource/Kundera  
[Maven]: https://maven.apache.org/
