# Getting Started

## Introduction

This repository checks the price of Bitcoin every 30 seconds and store it into the database.
The currency used for storing Bitcoin value is INR.

## Setup & Running

* ### First clone the repository using
    ```
    git clone https://github.com/bhaskor-sarmah/CryptoPriceTracker.git
    ```
* ### Next make sure Docker and Docker Compose is installed if not one can use the following link for installation instructions

    [Installing Docker](https://docs.docker.com/get-docker/)
    [Installing Docker-Compose](https://docs.docker.com/compose/install/)

* ### Running the docker-compose

    Navigate ino the repo directory

    ```
    cd CryptoPriceTracker
    ```

    Execute docker-compose command

    ```
    docker-compose up
    ```

    Now, the application should be running, we can verify that using

    ```
    docker ps
    ```

    If there are two container named ```springboot-app``` and ```mysqldb``` running the application is live now

* ### Testing the application

    To test the application we can the hit the following endpoint using PostMan or any rest client

    ```
    http://localhost:8080/api/v1/prices/btc?date=22-05-2022&offset=10&limit=20
    ```

    Don't forget to update the date accordingly to get the correct data.
    The application respose will be something like this

    ```
    {
        "count": 4,
        "data": [
            {
                "id": 1,
                "timestamp": "2022-05-22",
                "price": 2291393,
                "coinType": "bitcoin",
                "currencyType": "inr"
            },
            {
                "id": 2,
                "timestamp": "2022-05-22",
                "price": 2291393,
                "coinType": "bitcoin",
                "currencyType": "inr"
            },
            {
                "id": 3,
                "timestamp": "2022-05-22",
                "price": 2291393,
                "coinType": "bitcoin",
                "currencyType": "inr"
            },
            {
                "id": 4,
                "timestamp": "2022-05-22",
                "price": 2291393,
                "coinType": "bitcoin",
                "currencyType": "inr"
            }
        ],
        "url": "/api/v1/prices/btc?date=22-05-2022&offset=0&limit=10",
        "next": "/api/v1/prices/btc?date=22-05-2022&offset=10&limit=10"
    }
    ```

* ### Changing the Min or Max price values, which will result in email trigger

    The properties can be found in the docker-compose.yml file. The property names are :

    ```MAX_PRICE``` and ```MIN_PRICE```

    We can change the property values and re-run docker compose to see the effect.

    ```
    docker-compose down
    docker-compose up
    ```

    If the price received after every 30 seconds is greater than the ```MAX_PRICE``` or less than the ```MIN_PRICE``` value,
    then the system will trigger a email. (Note: The email triggering is not implemented)
    
    We can verify the email triggering feature by checking the logs for the following to get printed
    
    ```
    Fire Email Logic Triggered for emailId: test@gmail.com ......
    ```

    To check the logs, we can run the following command
    
    ```
    docker logs springboot-app -f 
    ```

## Thank You

Author: Bhaskor Jyoti Sarmah

Phone: +91-7002402636

Email: bhaskor88@gmail.com
