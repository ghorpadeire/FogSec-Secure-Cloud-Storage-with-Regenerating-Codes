
# Secure and Efficient Cloud Storage using Fog Computing and Regenerating Codes

This project is the result of my exploration into cloud storage systems, where I focused on making them more secure and efficient by using fog computing and regenerating codes. I designed this system to tackle key challenges like data privacy, low-latency access, and availability, ensuring that data is stored securely and accessed quickly. 

## Project Breakdown

### Main Components:
1. **Cloud_NC_ Folder**:
   - This folder contains the core of my project, including all Java files that handle the backend logic such as user login, admin functionalities, and cloud operations.

2. **WEB-INF Folder**:
   - This contains the web files for the project, including JSP pages and server-side classes to manage the user interface and server logic.

3. **Compiled Files**:
   - The `work` directory holds the compiled Java classes from the JSP pages, ready to run.

4. **Reports and Documentation**:
   - You’ll find two important documents here:
     - `MSc Research Project Config.pdf`: This explains how to set up the project and configure everything.
     - `Pranav Ghorpade MSc Research Project Report.pdf`: This is my full thesis report, covering my research, approach, and the system’s implementation.

## Key Features

1. **Fog Computing for Better Performance**:
   - I integrated fog computing to distribute data storage and processing closer to users, reducing delays in accessing cloud data.

2. **Regenerating Codes for Data Reliability**:
   - I used regenerating codes to improve fault tolerance. This method makes it easier to restore lost data without using too much bandwidth or storage.

3. **Security First**:
   - Data security was a priority, so I used advanced cryptographic techniques to protect the data stored in the cloud. This ensures that sensitive information remains confidential and tamper-proof.

4. **User Access Control**:
   - The system includes secure login processes for both users and administrators, ensuring role-based access and management of resources.

## How to Set Up

### Requirements:
- **Java**: You’ll need the Java Development Kit (JDK) installed to run the system.
- **Apache Tomcat**: The system runs on Tomcat as the servlet container.
- **MySQL**: The project uses a MySQL database to manage users and storage data.

### Step-by-Step Setup:
1. **Database Configuration**:
   - Import the provided SQL files to set up the MySQL database.
   - Update the connection settings in the `ConnectionManager.java` file located in the `WEB-INF/src/com/user/` directory.

2. **Deploy on Apache Tomcat**:
   - Copy the `Cloud_NC_` folder into the `webapps` directory of your Tomcat installation.
   - Start Tomcat, and the system will be accessible at `http://localhost:8080/Cloud_NC_/`.

3. **Using the System**:
   - Users can register or log in, upload and download files, and securely manage their cloud-stored data.
   - Admins can manage user accounts, monitor system performance, and configure fog nodes.

## Future Improvements

There are a few areas where I see potential for further development:
- **Multi-cloud Support**: Expanding the system to work with multiple cloud providers for enhanced redundancy and flexibility.
- **AI-Driven Optimization**: Leveraging AI to optimize storage allocation based on user behavior and demand.
- **Stronger Security Measures**: Adding features like advanced encryption methods and monitoring for suspicious activities.

---

This project represents my passion for secure systems and my technical expertise in both cloud storage and Java development. Feel free to check out the reports for more detailed information on how it all works.

"# FogSec-Secure-Cloud-Storage-with-Regenerating-Codes" 
