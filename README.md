# EntroPay Rates Retrieval Assessment

*EntroPay deals with money on a daily basis and, like any other financial institution, deals with foreign exchange rates between currencies*.

*You are asked to write an implementation which reads, parses and stores foreign exchange rates off a standard text file into a relational database. These rates would eventually be retrieved via a REST API*.


You are expected to use the following:
- Any REST implementation, preferably using *JAX-RS*.
- *Spring Framework* or, preferably, *Java EE 7.x*,
- *JSR-352 - Batch Processing* (more information below),
- JPA with Hibernate as persistence layer,
- any relational database of choice (H2, MySQL PostgreSQL, etc),
- any web container of choice (*Tomcat*, *TomEE*), preferably *Wildfly 9+*, and
- *Java JDK 1.8+*.

Although optional, you are encouraged to use a Build Management tool like *Apache Maven* or *Gradle*.

You are free to use any other library in conjunction with the above.

## Delivery
You can provide your deliverable in whichever fashion you like, however we would very much appreciate a GitHub public repository we could access and pull the source code from.
  
E-mail us at *jobs@entropay.com* once you are ready for us to evaluate.

## Implementation

This section describes the technical detail that is expected from the deliverable. The deliverable should be forked from our skeleton Java project which we have provided on GitHub at http://github.com/EntroPay/RatesRetrievalService.

**IMPORTANT**! *If you have any questions or feel something is not clear enough, feel free to e-mail us at jobs@entropay.com and we will do our best to reply in the shortest time possible*.

### Batch Processor
Using JSR-307 - Batch Processing (implemented by both Java EE 7 and Spring), you must implement a batch process which will be able to read, parse and save rates off the provided files, which can be found in the project’s *src/main/resources*.

### File Anatomy
The file to parse is a simple text file which contains all of the rates of the day, where each line represents a rate.

*2016010100087398USDEUR*

The above line is an example of one of the rates, which can be parsed as follows:
- **20160101** - a 8-character long value consisting of the date in yyyyMMdd format.
- **00087398** - a 6-character long value consisting of the rate. The rate must be divided by 100,000. In this example the real rate value is 0.87398.
- **USD** - the 3-character long *buy* currency in ISO-4217 format.
- **EUR** - the 3-character long *sell* currency in ISO-4217 format.

### Persistence Layer
You are expected to create an Persistence Entity Bean, *Rate.java*, which stores a single foreign exchange rate between two currencies. It should store:

- *file* - which stores the filename from which this rate has been extracted,
- *buyCurrency* - expressing the currency from which the rate will convert
- *sellCurrency* - expressing the currency to which the rate will convert
- *validDate* - containing the date when this rate could be used

Create the necessary logic which will be able to save, fetch, update and delete *Rate.java* entries off the database. *Hint: This might be a Stateless Session Bean or a Spring Bean*.

### REST API Layer
The REST API layer design and implementation is entirely up to you, however it should entirely provide the following functionality:
- the ability to despatch the aforementioned job which will fetch, parse, and save rates from the file
- the ability to fetch a list of rates, with the option to filter by date.

Naturally, these APIs must be hooked to the implementations mentioned above.
