
# Report 

## Completed tasks

**Using a Dockerized application: PostresSQL**

I pulled the postgres image and to run the image, I set "-p" with 5432:5432 and "-e" with POSTGRES_PASSWORD = mysecretpassword , as instructed in the image documentation. I edited build.gradle.kts and persistence.xml as instructed.

Further on, I created the jpa_client and set password as instructed. I used SQL client in DBeaver to generate the tables. I then gave permission to the jpa_client with the script "GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO jpa_client;"

Finally, the result from running CreditCardsMainTest.java:

![test_succesful](https://github.com/user-attachments/assets/a70a76d8-5bbf-418f-ba2f-dc7b73941a4f)

**Building your own dockerized application**

For my base image I used the latest tag, with gradle 8.10 and java 21.

dockerfile:

![dockerfile](https://github.com/user-attachments/assets/6c49f602-e706-4c08-8390-b7ff19b27ea6)


dockerfile built succesful:

![docker_build_succesful](https://github.com/user-attachments/assets/93f0d8c2-4fb3-4eac-898c-af7836d74389)

container succesfully running and succesfully posted GET request for users:

![container_running_succesfully](https://github.com/user-attachments/assets/5ec27fd9-d433-4fd5-b643-a599b6140182)

## Technical problems
Had troubles connecting the jpa_client to the tables due to restricted access. Fixed this by running
the script for granting the jpa_client acccess to all tables with SQL client in DBeaver.

[Link to code](https://github.com/Thorbjorn2021/poll-app/tree/main)

## Pending issues
Did not add the last "improvements", such as creating a new user, and using multi-stage build.
## Link to code written in this assignment
[Link](

