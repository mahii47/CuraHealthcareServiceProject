# CURA Healthcare Automation Project

This repository contains an end-to-end automation framework for the [CURA Healthcare demo website](https://katalon-demo-cura.herokuapp.com/). The project is built using a **Hybrid Framework** that integrates **Selenium WebDriver, TestNG, MySQL, and Jenkins CI/CD**.

---

## 🚀 Features

* **Login Automation** – Valid and invalid login test cases using database-driven test data
* **Appointment Booking** – Automated form filling with dropdowns, radio buttons, checkboxes, and date picker
* **Database Integration (MySQL)** – Fetching test data directly from database tables
* **Config-Driven** – All hardcoded values (URLs, DB credentials, etc.) are externalized in a properties file
* **Hybrid Framework** – Combination of Page Object Model (POM) + Data-driven + Config-driven approach
* **CI/CD Ready** – Jenkins pipeline integration for automated test execution
* **Cross-Browser Support** – Chrome, Edge, and Incognito mode

---

## 🛠️ Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Database:** MySQL
* **Build Tool:** Maven
* **CI/CD:** Jenkins
* **Design Pattern:** Hybrid Framework (POM + Data-driven)

---

## 📂 Project Structure

```
CURA-Healthcare-Automation/
│── src/main/java/
│   ├── commonLibs/        # Base classes, WebDriver utils, DB utils
│   ├── pages/             # Page Object classes
│   ├── drivers/             # Config reader, reusable methods
│
│── src/test/java/
│   ├── Test/             # TestNG test classes
│   ├── listeners/
│   ├── Utility/ 
│── src/test/resources
│   ├── config.properties  # Application & DB configs
│   ├──Testing.xml
│── test-data/
│   ├── curahealth.sql     # MySQL script for test data
│
│── pom.xml                # Maven dependencies
│── README.md              # Project documentation
```

---

## ⚙️ Setup & Execution

### 1️⃣ Prerequisites

* JDK 8+
* Maven
* MySQL & MySQL Workbench
* IDE (Eclipse/IntelliJ)
* Chrome/Edge browsers & drivers

### 2️⃣ Database Setup

* Create schema in MySQL:

  ```sql
  CREATE DATABASE curahealthproject;
  USE curahealthproject;

  CREATE TABLE login_data (
      id INT PRIMARY KEY AUTO_INCREMENT,
      username VARCHAR(50),
      password VARCHAR(50)
  );

  INSERT INTO login_data (username, password) VALUES 
  ('invalidUser1', 'wrongPass1'),
  ('invalidUser2', 'wrongPass2'),
  ('JohnDoe', 'ThisIsNotAPassword');
  ```
* Update `config/config.properties` with your DB credentials.

### 3️⃣ Run Tests

* Run via Maven:

  ```bash
  mvn clean test
  ```
* Run via TestNG XML from IDE
* Run via Jenkins pipeline (CI/CD)

---

## 📊 Test Cases Covered

* Invalid Login (2 scenarios – wrong username/password)
* Valid Login (data fetched from MySQL)
* Appointment Booking Form submission

---

## 📹 Demo

(Attach video link or upload execution video in LinkedIn post)

---


## 🔖 Author

**Mahesh Mankar** – QA Engineer | Automation | Selenium | API & Database Testing

\#Selenium #Java #MySQL #HybridFramework #TestAutomation #Jenkins #CICD #SDET
