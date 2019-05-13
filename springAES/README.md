Embedded tomcat:

port: 8080

user.name=Concord
user.password=Concord

Executable jar file: target/demo-0.0.1-SNAPSHOT

Start page: http://localhost:8080 
Example with parameter: http://localhost:8080/?name=Viktor

Request 1 coded string: http://localhost:8080/encrypt
Default value for encrypt: "Example for Concord"
Example with parameter: http://localhost:8080/encrypt?encrypt=new%20string%20for%20coding

Request 2 original string from coded string:http://localhost:8080/decrypt
Default value for decrypt: "ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a"
Example with parameter (parameter was taken as Request 1 result): 
http://localhost:8080/decrypt?decrypt=ea4b6fcaae17d255a7f30276bb4cfe418c7d6f23e7782c8344c0e79f6e3b887bc3cc723707c6e4a1962173db33764f4a

Salt: "aad22b57f8917b69"

