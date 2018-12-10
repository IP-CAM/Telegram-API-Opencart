# Telegram OpenCart

This project aims to build an open-source platform for building own Telegram-based
bot-driven shop with rich support of microtransactions. Being a platform that provides
an opinionated way of building an e-commerce platform, it is yet flexible and 
customizable.

Future plans and main directions of development include developing a predefined 
generalized DB schema, integrate Privat24 bot and transactions, 
interactive communication and easy-to-use Admin/Seller functionality via app bot.

## Prerequisites:
- Java 10

## Start up guide:
1. ./gradlew build
2. docker build -t telegram-opencart .
3. docker start telegram-opencart
