# device-management

Sample project to introduce an event driven architecture based on an IOT device management use case. Services are built using [Spring Cloud ecossystem](https://spring.io/projects/spring-cloud), together with [RabbitMQ](https://www.rabbitmq.com/) for event distribution.

The key point of this approach is not having services calling each other directly to query/write data, but relying on the event messages instead. That is my favorite approach for microservices in general, because it helps to keep clear domains and decouple services. 

## Architecture
1. [device-service](https://github.com/ricardobaumann/device-management/tree/master/device-service): CRUD service for the IOT devices. Publish events based on device CRUD events. Has a scheduler to generate dummy events, to show the service capabilities. 
2. [activity-service](https://github.com/ricardobaumann/device-management/tree/master/activity-service): CRUD service for device activities. Listen for device CRUD events, and publish events based on activities CRUD events. 
3. [report-service](https://github.com/ricardobaumann/device-management/tree/master/report-service): Listen for both device and activities CRUD events, and build an [Elastic Search](https://www.elastic.co/) index for querying. 
4. [eureka-service](https://github.com/ricardobaumann/device-management/tree/master/device-service): [Eureka](https://spring.io/guides/gs/service-registration-and-discovery/)-based service discovery service
5. [reverse-proxy-service](https://github.com/ricardobaumann/device-management/tree/master/device-service): [Zuul](https://spring.io/guides/gs/routing-and-filtering/)-based reverse proxy service

## Usage
1. run `docker-compose up` on docker-elk folder to run elastic search stack
2. Run `docker-compose up` on device-service folder to run RabbitMQ
3. Run the services with `./gradlew bootRun` or from your IDE
4. Check device-service and activity-service controllers to check how to input data, if you like. 
5. Check logs for the message publishing and consuming
5. Hit report-service endpoints to check for reports

## Next steps
1. Introduce more usage examples
2. Introduce more use cases. 
3. Introduce an event store, like [Kafka](https://kafka.apache.org/documentation/streams/) or [DynamoDB](https://aws.amazon.com/dynamodb). 
