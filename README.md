checkout
========

This exercise has two version, NikeSM and NikeSM-DI.

NikeSM implements functionality using core java features only whereas NikeSM-DI demonstrate use of dependency injection.

Database persistence has been simulated with a singleton object of the class - ProductRuleDB.java.

PriceRuleDao.java and PriceRuleDaoImpl.java is a data access layer between business service and database.

ProductPrice.java represents pricing rule entity - for getting the pricing detail out of database and to persist pricing details, in case of new pricing rules are being introduced.

ProductUndedfinedException.java is a custom exception created to report issue with items list containing an item not existing in database.

SuperMarket.java and SuperMarketImpl.java are the interface and implementation class respectively implementing the checkout method and addPriceRule methods.

There are two jUnit test classes - 
    PriceRuleDaoTest.java tests DAO methods directly. There are two test cases.
    SuperMarketImplTest.java tests SuperMarket service methods. There are 6 test different test cases.
    
Dependencies:
  NikeSM:
    jUnit 4
    
  NikeSM-DI
    jUnit 4
    Weld 2.5 (for CDI) - only weld-se.jar
    
lib: contains dependency jars used
