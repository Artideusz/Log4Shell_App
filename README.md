# A Log4Shell Vulnerable Java App

This is a simple Java application where users can research and test the `CVE-2021-44228` vulnerability.

## Requirements
- Maven
- **Java version `8u121` or older**

## How to run '**system**'
1. Run `mvn clean compile assembly:single`.
2. Run `java -cp target/vulnerable_app-0.0.1-jar-with-dependencies.jar com.vuln.App <port>`