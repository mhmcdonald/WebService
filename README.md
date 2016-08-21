##Notes to Grader: 

This is my proWebservice application. I used Prof Gerber's video, and examples for inspiration. To my knowledge, every requirement has been met, and the code is commented thoroughly.

##Regarding Authentication: 
I have applied Thymeleaf Security, which does not secure objects however it conceals what different user roles are able to see.
As such, you should login with username: user , password: user to view the webservice as a user_role.
Alternatively, to be able to create, read, update and delete the content of the site, you should login as username: admin, password: admin.

Admittedly, there is not much purpose to logging in under the user role. It doesn't have any real added functionality, over an unathenticated user does.

##API Notes: 

The RESTful API allows for all CRUD operations. 

READ ALL (READ): http://localhost:8080/api/get/all

READ SINGLE EPISODE (READ): http://localhost:8080/api/get/episode/2 (example: returns second episode in JSON)

DELETE EPISODE (DELETE): http://localhost:8080/api/2/delete (example: deletes the second episode)

UPDATE EPISODE (UPDATE): use POSTMAN to test API episode update

ADD NEW EPPISODE (CREATE): use POSTMAN to test API episode creation

##Attribution:
Class Videos: http://java-class.cs.uchicago.edu/adv/content/videos/  
SpringBootGuru: https://www.youtube.com/watch?v=NN_hSBEYBVE  
REST controller Overview: http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/  

