file://<WORKSPACE>/src/main/java/com/example/database/DatabaseUtils.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/src/main/java/com/example/database/DatabaseUtils.java
text:
```scala
package com.example.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class DatabaseUtils {

    private ConnectionHelper mysqlDatabaseConnectionHelper;

    public DatabaseUtils(String databaseURL, String username, String password) {
        // create an instance of the ConnectionHelper class
        this.mysqlDatabaseConnectionHelper = new ConnectionHelper();
        // connect to the MySQL database using the provided databaseURL, username, and password
        this.mysqlDatabaseConnectionHelper.connect(databaseURL, username, password);
    }

    public List<Customer> getAllCustomers() {

        // create a list to store customer objects that will be fetched from the database
        List<Customer> customers = new ArrayList<Customer>();

        try (
            // TODO 6: fetch the connection instance created in the constructor by calling the getConnection() method and call the getConnection() method on it
            Connection mysqlDatabaseConnection = mysqlDatabaseConnectionHelper.getDataSource().getConnection();
            // TODO 7: create a statement instance to execute queries on the MySQL database
            Statement sqlStatement = mysqlDatabaseConnection.createStatement();
            // TODO 8: execute a query to fetch customer data from the coffee_orders table
            ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM coffee_orders;");
        ) {

           // while the result set has more rows
           while (fetchAllCustomersQueryResultSet.next()) {

            // TODO 9: fetch the value of each column from the coffee_orders table one by one
            long orderID = fetchAllCustomersQueryResultSet.getLong("order_id");
            String customerName = fetchAllCustomersQueryResultSet.getString("customer_name");

            int quantity = fetchAllCustomersQueryResultSet.getInt("quantity");

            double totalPrice = fetchAllCustomersQueryResultSet.getDouble("total_price");   
            // TODO 10: put all the fetched values into a Java object of the Customer class
            customers.add(customer);
            // TODO 11: put this customer object in the list
            customers.add(customer);
        }

        } catch (SQLException exception) {
            // print an error message on the console
            System.err.println("Error fetching customers from the database");
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }
        
        // return the list of customers fetched from the database
        return customers;
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator