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
  + If you want to use a different database engine, you will need to update the dependencies in     the `pom.xml` file.

5. Run the application:
```
java -jar target/foodTruck-0.0.1-SNAPSHOT.jar
```
  The application will start on port 8080.

### APIs
The following APIs are available:

  * `/food-trucks`: Returns a list of all food truck entries.
  + `/food-trucks/search`: Searches for food trucks by applicant name, street, and expiration       date. The applicant, street, and expirationDate parameters are optional. 
    + If applicant is provided, the API returns food trucks that match the applicant.
    + If street is provided, the API returns food trucks that match the street.
    + If expirationDate is provided, the API returns food trucks that match the expirationDate.
    + If no parameters are provided, the API returns an empty list.
  - `/food-truck`: Adds a new food truck entry to the dataset (POST request).
  * `/food-trucks/closest`: Finds the closest food truck to a given delivery location(latitude,     longitude) (POST request).

### Deployment
To deploy the application on AWS, you can follow these steps:

  * Sign up for an AWS account.
  + Choose a hosting option (such as EC2 or Elastic Beanstalk).
  - Set up your hosting environment.
  * Deploy your application.
  + Test and troubleshoot as needed.

### Contributing
If you want to contribute to the project, please follow these guidelines:

  * Make sure you have a clear understanding of the problem you are trying to solve.
  + Create a new branch for your changes.
  - Write tests to cover your changes.
  * Make sure all tests pass before submitting your pull request.
  - Document your changes in the README file.

### License
This project is licensed under the MIT License. See the LICENSE file for details.

### Credits
This project uses data from the **San Francisco Food Truck Finder** dataset.

### Contact
If you have any questions or feedback about this project, please don't hesitate to contact me at **kravinash006@gmail.com**.

### Disclaimer
This project is for educational purposes only and is not affiliated with the City of San Francisco or any other organization.
