# Ticket-Search-Recommendations
Personalized recommendation system

The purpose of this project is to implement a web service which can support: search nearby events, buy tickets, and recommend events to customers. 

Data feched from TicketMaster: https://www.ticketmaster.com/ 

Established Java Servlets to handle http requests and responses (More details are shown below)

* Programming Languages: Java, SQL, JavaScript, HTML, CSS
* DataBases: MySQL/MongoDB(for better scaling)
* HTTP web server environment: Apache Tomcat v9.0

##  Deployment Option:AWS - Amazon EC2
- Some introductions and part of steps that may help you to learn about deploying to Amazon EC2 as a reference.
  - Elastic Compute Cloud (EC2) : Allows scalable deployment of applications, users can boot an Amazon Machine Image to create a virtual machine instance.
  - For this program, installation of Java, MySQL, and Tomcat in instance terminal are needed.<br> e.g., install MySQL and connect to MySQL with MySQL shell after installation
  ```
  sudo apt-get install mysql-server
  ```
  
  ```
  mysql -u root -p
  ```
  - Convert Java program into a WAR file (or Web application ARchive) from IDE, then upload to EC2. <br>
  e.g., In Eclipse: Click File -> Export -> Select WAR file. <br>
  e.g., In intelliJ: reference source from IntelliJ IDEA Help - ( https://www.jetbrains.com/help/idea/configure-web-app-deployment.html )

## Java Servlet - using RESTful API
- REST is abbreviation of Resource representational state transfer, an architectural design approach for web service.<br>
The benefits of using REST includes: 
  - The server does not need to parse extra things but directly call the operations which are based on HTTP methods. <br>
  - Stateless request model. Requests are independent.<br> 
  - URL can clearly indicates the resources, is very friendly to users / clients. <br>
  - etc.

- So there are few common requirements for RESTful API. <br>
  - The uniform interface for RESTful API includes using standard HTTP operations: e.g. Most common HTTP methods are GET, POST, PUT, DELETE, etc. <br>
  - A specific exchange format is required for clients and servers to interact and exchange resources. (In this ticket recommendation program, JSON format was used
  to represent the resources that need to be exchanged, and JSON format is one of the most common formats that many web API choose to use. Other common exchange formats: e.g., XML, ProtocolBuffer) 
  


## Recommendation Algorithm in this program
- Content-based recommendation algorithm was used. 
  - The principle is to recommend items to clients with similar attributes of item, it based on the item's specific characteristic itself. (Such as price, category, size, etc.)
  - For this program, there is not enough information or users' performance / records to be ready to analyze, a cold-start need to be considered. So content-based algorithm is a reasonable option.
