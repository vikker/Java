Embedded tomcat:

port: 8080

user.name=Concord
user.password=Concord

Executable jar file: target/demo-0.0.1-SNAPSHOT

Start page: http://localhost:8080 
Example with parameter: http://localhost:8080/?name=Viktor

Request 1 coded string: http://localhost:8080/encrypt
Example with parameter: http://localhost:8080/encrypt?encrypt=new%20string%20for%20coding

Request 2 original string from coded string:http://localhost:8080/decrypt
Example with parameter (parameter was taken as Request 1 result): 
http://localhost:8080/decrypt?decrypt=4a20389e668a4ce027d95948736af1dce4cb1d31e0d0e2307379bce8dd91442c2d17f717d330bf88d80eff68d81d9a79
