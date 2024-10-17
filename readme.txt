
Secure and Efficient Cloud Storage Using Fog Computing and Regenerating Codes

Project Description
This project focuses on developing a secure and efficient cloud storage system that integrates fog computing and regenerating codes to address the challenges of data privacy, latency, and availability in traditional cloud storage systems. The system leverages fog nodes for preprocessing data near the data origin, reducing latency, and enhancing availability. Additionally, regenerating codes are used to improve fault tolerance and minimize repair bandwidth, providing a robust and scalable storage solution.

Link of Video Presentation
https://studentncirl.sharepoint.com/:v:/s/prag/EbK6Ty738pJFlZ4y17O_KE8BmQpvqj6L53O8y1cOymjFlw?e=ZRHBxe

Key Features
- Fog Computing Integration: Reduces latency by processing data closer to the source.
- Regenerating Codes: Enhances fault tolerance and minimizes repair bandwidth.
- Data Privacy and Security: Ensures data privacy through cryptographic techniques and secure storage mechanisms.
- High Availability: Achieves up to 50% fault tolerance using 100% extra storage.

Installation Guide

System Requirements
- Hardware: Intel Core i5 or later, 16 GB RAM, 512 GB SSD.
- Operating System: Windows.
- Software Dependencies:
  - Java Development Kit (JDK) 1.7
  - Eclipse Galileo IDE
  - Apache Tomcat 6.0
  - MySQL 5.0
  - SQLyog
  - JDBC Driver for MySQL (e.g., mysql-connector-java-5.1.48.jar)

Step-by-Step Installation

1. Install Java (JDK 1.7)
   - Download from the Oracle Java SE 7 archive.
   - Install and configure the environment variable JAVA_HOME.
   - Ensure %JAVA_HOME%\bin is included in the system Path.

2. Install Eclipse Galileo IDE
   - Download and unzip the Eclipse Galileo IDE.
   - Run eclipse.exe to start the IDE.

3. Install Apache Tomcat 6.0
   - Download from the Apache Tomcat Archive.
   - Unzip and configure it in Eclipse under the Servers view.

4. Install MySQL 5.0
   - Download from MySQL Archives.
   - Install MySQL and set a root password during setup.

5. Install SQLyog
   - Download and install SQLyog.
   - Connect to your MySQL database using the root password.

6. Set Up JDBC Driver
   - Download the JDBC driver and add it to your project in Eclipse via the Build Path configuration.

Running the Code

Setting Up Your Development Environment

1. Create a Web Project in Eclipse
   - Go to File > New > Project, select Web > Dynamic Web Project.
   - Name your project and set Tomcat as the target runtime.

2. Configure the Tomcat Server
   - In the Servers view, add a new server instance for Tomcat v6.0.
   - Point it to the Tomcat installation directory.

3. Database Configuration
   - Use SQLyog to create a new MySQL database and required tables.
   - Establish a JDBC connection in your Java project.

Running the Application
- Deploy Project: Right-click your project in Eclipse, select Run As > Run on Server.
- Testing: Ensure that file uploads, downloads, and the secure storage mechanisms are functioning as expected.

Project Directory Structure

/project-root
|
├── /src
│   ├── Main.java                   # Main application logic
│   ├── FogComputing.java           # Fog computing implementation
│   ├── RegeneratingCodes.java      # Regenerating codes logic
│   └── SecurityModule.java         # Data privacy and security measures
|
├── /WebContent
│   ├── /WEB-INF
│   │   └── web.xml                 # Servlet configuration
│   ├── index.jsp                   # Main JSP file
│   └── /jsp
│       └── upload.jsp              # File upload interface
|
└── /lib
    └── mysql-connector-java-5.1.48.jar  # JDBC Driver

- /src: Contains the core application logic including fog computing, regenerating codes, and security modules.
- /WebContent: Web resources, including JSP files and the servlet configuration.
- /lib: Contains external libraries, such as the JDBC driver for MySQL.

Contributing to the Project

Coding Standards
- Follow Java naming conventions.
- Write clear and concise comments for every method.
- Ensure code modularity by separating concerns across different classes.

Guidelines
- Fork the repository and create a new branch for any new feature or bug fix.
- Ensure that your code passes all unit tests before submitting a pull request.
- Update documentation where necessary.

License
This project is licensed under the MIT License. You are free to use, modify, and distribute the software under the terms of this license.
