# cp-spring_cloud_streams-example

Very simple example to demonstrate Spring Cloud Streams exchanging data with Kafka topics

The easiest way to get started is to use the [Spring Initializr](https://start.spring.io/). 
Set a ```Group``` and ```Artifact``` name and add ```Kafka``` and ```Cloud Stream``` as dependencies.


This generates a zip file (in my case scs_demo.zip). Unzip this and then use maven to turn it into an Eclipse project

```
mvn eclipse:eclipse
```

## Set up a Listener
Now lets add the simplest possible Kafka topic listener to the code.
Create an interface and bind it to an ```@Input``` channel. See [ListenerInterface.java](src/main/java/io/confluent/examples/scs_demo/ListenerInterface.java) which uses the property value ```demo.inputTopic``` to set the topic name to listen to.

And of course we need 

Start ZooKeeper and Kafka

```
docker-compose up -d
```

Then run the demo application

```
mvn spring-boot:run
```	

Then send it some data using either KafkaCat

```
echo "{test:\"hi\"}" | kafkacat -b localhost:9092 -t my_in_topic
```
Or the ```kafka-console-producer``` which is found packaged inside the ```kafka``` docker image.

```
docker-compose exec kafka kafka-console-producer --broker-list kafka:29092 --topic my_in_topic
```

