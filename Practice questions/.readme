1. Strategy + Open–Closed Principle 
Design a fare calculation system for public transport. 
Requirements: 
● Fare depends on distance, time of day, and passenger type. 
● New fare rules must be added without modifying existing code. 
Tasks: 
● Define appropriate interfaces and classes. 
● Implement at least three fare strategies. 
● Demonstrate switching strategies at runtime. 



2. Abstract Factory with Dependency Injection 
Build a cross-platform notification system. 
Requirements: 
● Supports Email, SMS, and Push notifications. 
● Should work for Web and Mobile platforms. 
● Platform-specific factories must be injected at runtime. 
Tasks: 
● Implement Abstract Factory pattern. 
● Show client code that is independent of concrete classes. 



3. Thread-Safe Observer Pattern (Concurrency) 
Implement a real-time sensor monitoring system. 
Requirements: 
● Multiple sensors update data concurrently. 
● Observers must receive consistent updates. 
● System must be thread-safe. 
Tasks: 
● Use Java concurrency utilities. 
● Prevent race conditions. 
● Demonstrate observer registration and notification. 



4. Hexagonal Architecture (Ports & Adapters) 
Design a payment processing module. 
Requirements: 
● Core business logic must be independent of: 
○ database 
○ external payment gateways 
● Switching gateways must require zero changes to business logic. 
Tasks: 
● Define ports (interfaces). 
● Implement at least two adapters. 
● Write a main program showing dependency inversion. 


5. Domain Model with Aggregates (DDD Style) 
Create a library borrowing system. 
Requirements: 
● Library is the aggregate root. 
● Book and Member must not be modified directly. 
● Business rules: 
○ Max 3 books per member 
○ No duplicate borrowing 
Tasks: 
● Enforce invariants in code. 
● Prevent illegal state changes. 


6. Command Pattern + Undo/Redo 
Implement a smart home controller. 
Requirements: 
● Commands: turn lights on/off, open/close door. 
● Support undo and redo operations. 
● Commands must be stored dynamically. 
Tasks: 
● Implement Command interface. 
● Use stacks for undo/redo. 
● Demonstrate functionality. 


7. Protected Variations for External APIs 
Design a weather data service. 
Requirements: 
● Data comes from third-party APIs. 
● APIs may change frequently. 
● Core logic must remain unaffected. 
Tasks: 
● Apply Protected Variations. 
● Simulate API change without breaking system. 


 
8. Compositions 
Car ♦────── Engine 
(1)        
(1) 
● Car owns Engine. 
● Engine must not exist without Car. 
Task: 
Implement the above UML using Java. 
Prevent direct access to Engine from outside the Car class. 