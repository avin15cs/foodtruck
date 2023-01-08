# Food Truck Finder
Food Truck Finder is a web application that allows users to search for food trucks in San Francisco by applicant name, expiration date, and street name. The application also allows users to add new food truck entries to the dataset and to find the closest food truck to a given delivery location.

### Prerequisites
Before you begin, you will need the following:

- A Java development environment (JDK 8 or later)
* A build tool (such as Maven or Gradle)
+ A database (such as MySQL or PostgreSQL)
- An AWS account (if you want to host the application on AWS)

### Getting Started
1. Clone the repository:

```
git clone https://github.com/avin15cs/foodtruck.git
```

2. Build the project:

```
cd foodtruck
mvn package
```
3. Set up the database:

* Create a database and a user with permissions to access the database.
- Run the schema.sql script to create the necessary tables.
+ Run the data.sql script to populate the tables with sample data.

4. Configure the application:
* Edit the application.properties file to set the connection details for the database.
+ If you want to use a different database engine, you will need to update the dependencies in the `pom.xml` file.
