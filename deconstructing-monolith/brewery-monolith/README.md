[![CircleCI](https://circleci.com/gh/sfg-beer-works/brewery-monolith.svg?style=svg)](https://circleci.com/gh/sfg-beer-works/brewery-monolith)
# Brewery UI Monolith

This repository contains source code examples used to support my on-line courses about the Spring Framework.

You can learn more about the courses here:
* [Spring Boot Microservices with Spring Cloud](https://www.udemy.com/spring-boot-microservices-with-spring-cloud-beginner-to-guru/?couponCode=GIT_HUB2)
* [Spring Framework 5: Beginner to Guru](https://www.udemy.com/course/spring-framework-5-beginner-to-guru/?couponCode=GITHUB_SFGPETCLINIC)
* [Testing Spring Boot: Beginner to Guru](https://www.udemy.com/testing-spring-boot-beginner-to-guru/?couponCode=GITHUB_REPO_SF5B2G)


### How it works: 
Beer Service
• Will manage ‘Beers’ - aka products
• Will manage brewing - aka manufacturing
• Will list beers, and validate order lines for valid beers


Beer Order service:
• Manages Beer Orders
• Will manage the lifecycle of an order - from order placement, to order shipment
• Manages customers
• Listens to order events
• Implements call backs (aka Webhooks) to customers


Beer Inventory service
• Manages Beer Inventory
• Takes in inventory from brewing operations
• Provides inventory for orders
• Implementation will be simple
• Real use would be more complex 