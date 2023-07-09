# order-management
To build the application:

Make sure you have Java and Maven installed on your computer.
Open your terminal or command prompt.
Go to the project's main folder using the cd command.
Type mvn clean install and press Enter. This will build the application by compiling the code and running tests.
To create and run the Docker image:

Install Dockerapp on your computer
Open your terminal or command prompt.
Go to the project's main folder.
Create a file called "Dockerfile"
Open the Dockerfile in a text editor.
Write these lines in the Dockerfile:
FROM openjdk:17
COPY target/my-application.jar my-application.jar (this copies the built application to the Docker image)
CMD ["java", "-jar", "my-application.jar"] (this tells Docker how to run the application)
Save the Dockerfile.
In the terminal, type docker build -t my-application . and press Enter. This builds the Docker image.
Once the image is built, type docker run -p 8080:8080 my-application and press Enter. This runs the Docker container.
Now you can access your application by opening a web browser and going to http://localhost:8080.
