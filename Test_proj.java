// Project Structure (Maven):
// src/main/java/com/example/web/HelloServlet.java
// src/main/webapp/index.jsp
// src/main/webapp/WEB-INF/web.xml
// pom.xml

/* =========================
   pom.xml
   ========================= */
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>basic-webapp</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <dependencies>
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>5.0.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.servlet.jsp</groupId>
            <artifactId>jakarta.servlet.jsp-api</artifactId>
            <version>3.0.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>basic-webapp</finalName>
    </build>
</project>

/* =========================
   HelloServlet.java
   ========================= */
package com.example.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = "World";
        }

        request.setAttribute("name", name);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

/* =========================
   index.jsp
   ========================= */
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Java Web App</title>
</head>
<body>
    <h1>Hello, ${name}!</h1>

    <form action="hello" method="get">
        <input type="text" name="name" placeholder="Enter your name" />
        <button type="submit">Greet Me</button>
    </form>
</body>
</html>

/* =========================
   web.xml (optional if using annotations)
   ========================= */
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">
</web-app>
