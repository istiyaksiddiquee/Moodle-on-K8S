db.createUser(
    {
      user: "magnumopus",
      pwd: "123456",
      roles: [ "readWrite" ]
    }
 );
 db.createCollection("students");
 db.students.insertOne({ name: "Jon", age: "20" });