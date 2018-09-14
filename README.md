# crm
Use Hibernate to read a customer Record.
Each User can register his/her Account. Then login his/her account.
Then can see all the customers that he/she have, can't view other users' customer.
User can update/create/delete customer records.

Using Spring MVC,hibernate,Spring Security..etc.

The Rest API Support to create read update delete records.
 1. url: crm/api/customers;
    Method:GET
    get a list of records
    authoried to all the user.
 2. url: crm/api/customers/id;
    Method:GET
    get the specify customer.
    authoried to all the user.
 3. url:crm/api/customers;
    METHOD:POST
    need to pass a json object, and create a new record
    authoried to user with roll of Manager or Admin
 4. url:crm/api/customers;
    Method:PUT
    passing a jason object with id, if record exist,then will update the record.
    authoried to user with roll of Manager or Admin;
 5. url: crm/api/customers/id;
    Method:DELETE
    DELETE an existing record.
    authoried to the user with roll of ADMIN.
    
    
  testetst

