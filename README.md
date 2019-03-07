# Reservations
The main idea in this application is helping users to make reservation in their favorite bar, club or restaurant.
Users can browse through our database and find a perfect local in their area, make reseravtions and of course have some fun 
with their friends.
## API ##
Using Spring Boot we have built a RESTful API to provide our client with needed content. 
All data in our database is stored using Spiring JPA with PostgreSQL. 
All tables are generated automatically using ``spring.jpa.generate-ddl=true``.
This app has two type of users: 
- Owner
- User
### Owners ###
Owners can add all their places and monitor them for number of reservations, total number of guests and searching by date.
The data we keep for owners are pretty same as regular users except the foreign keys for their companies.
When new owner is register he has to provide following info:
- First Name
- Surname
- Email
- Password

After succesfull registration owners can now register their place.
### Users ###
All users can search through the database and take a look at places of their interest, but only authenticated users are able to make reseravtions.

### Authenticated Users ###

Anyone who would like to make reservations has to be authenticated. To become authenticated user you must register using register form.
For registration, the new user has to provide the same infomration as Owners.

All password are stored crypted, using ``org.springframework.security.crypto.password`` - ``PasswordEncoder``.


