db.createUser(
   {
      user: "admin",
      pwd: "admSN0S",
      roles: [
      {
         role: "dbAdmin",
         db: "sns_online_store"
      }]
   }
);
