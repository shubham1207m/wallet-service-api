Wallet Service API

This project is a backend wallet system built using Spring Boot and PostgreSQL.
It provides APIs to perform deposit, withdrawal, and balance retrieval operations.

Developed as part of a backend assignment to demonstrate API design, database handling, and concurrency control.

Features
1. Deposit and withdraw money from a wallet
2. Retrieve wallet balance
3. Input validation and error handling
4. Concurrency handling using optimistic locking
5. Dockerized setup using Docker Compose

Tech Stack

1. Java 17
2. Spring Boot
3. PostgreSQL
4. JPA / Hibernate
5. Docker

API Endpoints
Deposit / Withdraw
POST /api/v1/wallet

Request Body:
{
"walletId": "11111111-1111-1111-1111-111111111111",
"operationType": "DEPOSIT",
"amount": 1000
}

Get Balance
GET /api/v1/wallets/{id}

Example:
/api/v1/wallets/11111111-1111-1111-1111-111111111111

Running Locally

1. Install PostgreSQL
2. Create database: walletdb
3. Update credentials in application.properties
4. Run: mvn clean install

Running with Docker
docker compose up --build

Design Decisions

1. Used layered architecture (controller, service, repository)
2. Implemented optimistic locking using @Version
3. Added global exception handling
4. Ensured validation for insufficient balance
