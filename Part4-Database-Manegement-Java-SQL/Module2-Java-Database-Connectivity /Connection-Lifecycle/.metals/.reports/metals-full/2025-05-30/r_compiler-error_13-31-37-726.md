file://<WORKSPACE>/src/main/java/com/example/database/ConnectionHelper.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/src/main/java/com/example/database/ConnectionHelper.java
text:
```scala
package com.example.database;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionHelper {

    // an instance to the MysqlDataSource is already created, you only need to initialize its properties to connect to the MySQL database
    private MysqlDataSource mysqlDatabase;

    public MysqlDataSource getDataSource() {
        return this.mysqlDatabase;
    }

    // complete the connect() method to connect to the MySQL database
    public void connect(String databaseURL, String username, String password) {
        // TODO 2: initialize the mysqlDatbase field using the MySQLDataSource class's no-args constructor
        mysqlDatabase = new MysqlDataSource();
        
        // TODO 3: set the URL for the MySQL database by calling the setURL() method on the mysqlDatabase field
        
        // TODO 4: set the username for database authentication by calling the setUser() method on the mysqlDatabase field

        // TODO 5: set the password for database authentication by calling the setPassword() method on the mysqlDatabase field
        // The password should be 'password'

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