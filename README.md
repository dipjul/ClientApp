# Client

### MySql database is used
### Spring Oauth 2.0 is used for security

## REST APIs

#### POST `/auth/signin` - json {"username":"yourUsername", "password":"yourPassword"}
#### GET `/clients`
#### GET `/clients/{id}`
#### POST `/clients`
#### PUT `/clients/{id}`
#### DELETE `/clients/{id}`
#### GET `/me` - details related to your account

## For changing database:
- Change the dependencies on pom.xml file
- Change the details on src/main/resources/application.properties

## Running for the first time:
- Uncomment the below code on DataInitializer.java<br>
Below code with create two users:<br>
1. username:user, password:password, role:user
2. username:admin, password:password, role:admin
```java
        this.users.save(User.builder()
            .username("user")
            .password(this.passwordEncoder.encode("password"))
            .roles(Arrays.asList( "ROLE_USER"))
            .build()
        );

        this.users.save(User.builder()
            .username("admin")
            .password(this.passwordEncoder.encode("password"))
            .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
            .build()
        );
```
