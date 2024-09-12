## Microservices Project with Spring Boot and Docker

This project utilizes a microservices architecture with Spring Boot, Docker, and MongoDB. It enables users to send messages through a load balancer, which distributes requests among multiple instances of the logging service. These services store the data in a MongoDB database, and the last 10 logs are displayed on a web interface.
### Prerequisites

1. **Java** (versions 7)
    ```sh
    java -version
    ```

2. **Maven**
    ```sh
    mvn -version
    ```

3. **Docker**
    ```sh
    docker --version
    ```

### Installing

1. Clone the repository and navigate into the project directory:
    ```sh
    git clone xhttps://github.com/Hajaku12/Microservices_SpringBoot_Docker.git

2. Build the project:
    ```sh
    mvn package
    ```

3. Run the application:
    ```sh
    java -jar target/Microservices_SpringBoot_Docker-1.0-SNAPSHOT.jar
    ```

4. Run the Docker Compose file:
    ```sh
    docker-compose up
    ```
<video width="600" controls>
  <source src="images/Video1.mov" type="video/mp4">
  Your browser does not support the video tag.
</video>

### Usage

- **Logging Service**: Enter a message in the text field and press "Send". The message will be stored in MongoDB, and you will see the last 10 messages.
- **Load Balancer Service**: Distributes requests among the instances of `LogService` using a round-robin algorithm.

### Architecture

- **Client (Browser)**: Sends HTTP requests to the backend services.
- **Load Balancer**: Distributes incoming requests among multiple instances of `LogService`.
- **LogService**: Receives and processes log messages, storing them in MongoDB.
- **MongoDB**: Stores log messages.
- **Dockerized Infrastructure**: Each service runs in its own Docker container.
- **Diagram**:
 ![img_1.png](images%2Fimg_1.png)

### Deployment

- **URL**: https://ec2-34-201-114-248.compute-1.amazonaws.com/34004/index.html

![img.png](images%2Fimg.png)


### Built With

- [Maven](https://maven.apache.org/) - Dependency Management
- [Git](http://git-scm.com/) - Version Control System
- [Docker](https://www.docker.com) - Containerization and deployment
- [MongoDB](https://www.mongodb.com) - NoSQL database

## Generating Project Documentation

1. **Generate the Site**
    - Run the following command to generate the site documentation:
      ```sh
      mvn site
      ```

2. **Add Javadoc Plugin for Documentation**
    - Add the Javadoc plugin to the `reporting` section of the `pom.xml`:
      ```xml
      <project>
        ...
        <reporting>
          <plugins>
            <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-javadoc-plugin</artifactId>
              <version>2.10.1</version>
              <configuration>
                ...
              </configuration>
            </plugin>
          </plugins>
        </reporting>
        ...
      </project>
      ```

    - To generate Javadoc as an independent element, add the plugin in the `build` section of the `pom.xml`:
      ```xml
      <project>
        ...
        <build>
          <plugins>
            <plugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-javadoc-plugin</artifactId>
              <version>2.10.1</version>
              <configuration>
                ...
              </configuration>
            </plugin>
          </plugins>
        </build>
        ...
      </project>
      ```

3. **Generate Javadoc Commands**
    - Use the following commands to generate Javadocs:
      ```sh
      mvn javadoc:javadoc
      mvn javadoc:jar
      mvn javadoc:aggregate
      mvn javadoc:aggregate-jar
      mvn javadoc:test-javadoc
      mvn javadoc:test-jar
      mvn javadoc:test-aggregate
      mvn javadoc:test-aggregate-jar

### License

This project is licensed under the GNU License - see the `LICENSE.txt` file for details.

### Authors

Hann Jang

