[![CircleCI](https://circleci.com/gh/dtn1999/hackathon-2021/tree/circleci-project-setup.svg?style=svg)](https://circleci.com/gh/dtn1999/hackathon-2021/tree/circleci-project-setup)

# Hackathon 2021

This project contents the implementation of our project during the 2021 Hackathon. During this hackathon we try to create a simple amazone clone. The main focus for our team was the backend part. Below is the list of currently avalaible features. 


## TECHNOLOGY STACK

to implement our clone we used for the **Backend** *spring boot* and for the **Frontend** *react*

## DIFFERENT FEATURES

* Registration ✔
* Login ✔
* See List of all the available products ✔
* Add product to card ✔
* Remove product to card ✔
* Simulate a payment with stripe ✔
* Make an order x
* View list of all the orders x
* 

## INSTALLATION

  To install and run this project follow these steps:

   ```bash
   git clone https://github.com/dtn1999/hackathon-2021.git
   
   cd hackathon-2021
   
   cd backend/amazon-clone
   
   # make sure you have maven install and java ( in case you get any errors )
   
   ./mvnw spring-boot:run
  
   ```
   
   Once the backend has started you can have access to the swagger api by opening the browser at http://localhost:8080/swagger-ui
   
   to start the frontend:
   
   ```bash   
   cd hackathon-2021
   
   cd hackathon-2021/frontend
   
   # make sure you have node or yarn install ( in case you get any errors )
   
   npm install # if you use npm 
   
   yarn install # if you use yarn 
   
   yarn dev 
   # or
   npm run dev
  
   ```
   after those steps the application will be avalauble at : http://localhost:3000
