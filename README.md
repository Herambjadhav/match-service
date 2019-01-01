JDK: 1.8
spring-boot, in-memory H2 DB 

# match-service
A Spring-boot java application that exposes API's for a dating app

# to build
mvn clean package

# to run from maven
mvn spring-boot:run

# to run as jar
java -jar target/match-service.jar

# A Few REST API's:

- Get all likes for a user: bob@gmail.com
	GET : http://localhost:8080/likes/all/bob@gmail.com

- Save a Like: galadrel@gmail likes bilbo@gmail.com
	POST : http://localhost:8080/likes/save 
	RequestBody :
	{
		"userId" : "galadrel@gmail.com",
		"likedUserid" : "bilbo@gmail.com"
	}
	
- Get all matches for a user: bob@gmail.com
	GET: http://localhost:8080/match/all/bob@gmail.com
	
- Get potential matches for a user: bob@gmail.com
	Get: http://localhost:8080/match/candidates/bob@gmail.com
	RequestBody:
	[
		{
			"type" : "SEX",
			"values" : ["F"]
		},
		{
			"type" : "CITY",
			"values" : ["San Francisco"]
		}
	]
	
- Get all dislikes for a user: bob@gmail.com
	GET : http://localhost:8080/dislikes/all/bob@gmail.com

- Save a disike: alice@gmail dislikes eve@gmail.com
	POST : http://localhost:8080/dislikes/save 
	RequestBody :
	{
		"userId" : "alice@gmail.com",
		"likedUserid" : "eve@gmail.com"
	} 