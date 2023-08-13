# TestNG-Automation-Pipeline
A comprehensive CI/CD testing framework utilizing Java TestNg, Selenium for web UI tests, and REST Assured for API validations.

## Features

- **Web Testing with Selenium**: Validate UI across multiple browsers using Docker and AWS EC2 for compatibility.
- **API Validation with REST Assured**: Ensure backend services' integrity and responsiveness.
- **Continuous Integration**: Integration with Jenkins facilitates continuous testing and deployment.
- **Code Quality Checks**: Implemented SonarQube for static code analysis and quality metrics.

### Prerequisites

- Java 1.8 or later
- Docker
- docker-compose
- AWS EC2 instance (optional for cloud deployment)
- Jenkins
- SonarQube Server


## Getting Started

Follow these steps to set up and use the automation framework:

1. Clone this repository to your local machine.
2. Install required dependencies, including Java, TestNg, Selenium, and Docker.
3. Configure Jenkins to integrate the project for continuous testing.
4. Customize the project to suit your specific testing needs.

## Usage

- Run web and API tests: `mvn clean test`
