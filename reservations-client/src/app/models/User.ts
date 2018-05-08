export class User {
   firstName: String;
   lastName: String;
   email: String;
   username: String;
   password: String;


  constructor(firstName: String, lastName: String, email: String, username: String, password: String) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.username = username;
    this.password = password;
  }
}
