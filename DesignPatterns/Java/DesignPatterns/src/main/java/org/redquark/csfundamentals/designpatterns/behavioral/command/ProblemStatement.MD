# Command design pattern

The Command Design Pattern is a behavioral design pattern and helps to decouples the invoker from the receiver of a request.

To understand the Command Design Pattern let’s create an example to execute different types of jobs. A job can be anything in
a system, for example, sending emails, SMS, logging, and performing some IO functions.

The Command pattern would help to decouple the invoker from a receiver and helps to execute any type of job without knowing its
implementation. Let us make this example more interesting by creating threads which will help to execute these jobs concurrently.

As these jobs are independent of each other, so the sequence of execution of these jobs is not really important. We will create a
thread pool to limit the number of threads to execute jobs. A command object will encapsulates jobs and will hand it over to a
thread from the pool that will execute the job.


## What is the Command Design Pattern

The intent of the Command Design Pattern is to encapsulate a request as an object, thereby letting the developer to parameterize
clients with different requests, queue or log requests, and support undoable operations.

In general, an object-oriented application consists of a set of interacting objects each offering limited, focused functionality. In
response to user interaction, the application carries out some kind of processing. For this purpose, the application makes use of
the services of different objects for the processing requirement.

In terms of implementation, the application may depend on a designated object that invokes methods on these objects by passing
the required data as arguments. This designated object can be referred to as an invoker as it invokes operations on different
objects. The invoker may be treated as part of the client application. The set of objects that actually contain the implementation
to offer the services required for the request processing can be referred to as Receiver objects.

Using the Command pattern, the invoker that issues a request on behalf of the client and the set of service-rendering Receiver
objects can be decoupled. The Command pattern suggests creating an abstraction for the processing to be carried out or the action
to be taken in response to client requests. This abstraction can be designed to declare a common interface to be implemented
by different concrete implementers referred to as Command objects. Each Command object represents a different type of client
request and the corresponding processing.

A given Command object is responsible for offering the functionality required to process the request it represents, but it does
not contain the actual implementation of the functionality. Command objects make use of Receiver objects in offering this
functionality.

![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/behavioral/command/.ProblemStatement.MD_images/UML%20Diagram%20-%20Command.png)


### Command
- Declares an interface for executing an operation.

### ConcreteCommand
- Defines a binding between a Receiver object and an action.
- Implements Execute by invoking the corresponding operation(s) on Receiver.

### Client
- Creates a ConcreteCommand object and sets its receiver.

### Invoker
- Asks the command to carry out the request.

### Receiver
- Knows how to perform the operations associated with carrying out a request. Any class may serve as a Receiver.


## When to use the Command Design Pattern

Use the Command pattern when you want to:
- Parameterize objects by an action to perform.
- Specify, queue, and execute requests at different times. A Command object can have a lifetime independent of the 
original request. If the receiver of a request can be represented in an address space-independent way, then you can 
transfer a command object for the request to a different process and fulfill the request there.
- Support undo. The Command’s Execute operation can store state for reversing its effects in the command itself. The
Command interface must have an added Un-execute operation that reverses the effects of a previous call to Execute.
Executed commands are stored in a history list. Unlimited-level undo and redo is achieved by traversing this list backwards
and forwards calling Un-execute and Execute, respectively.
- Support logging changes so that they can be reapplied in case of a system crash. By augmenting the Command interface
with load and store operations, you can keep a persistent log of changes. Recovering from a crash involves reloading logged
commands from disk and re-executing them with the Execute operation.
- Structure a system around high-level operations built on primitives operations. Such a structure is common in 
information systems that support transactions. A transaction encapsulates a set of changes to data. The Command 
pattern offers a way to model transactions. Commands have a common interface, letting you invoke all transactions the
 same way. The pattern also makes it easy to extend the system with new transactions.


## Command Design Pattern in JDK

- java.lang.Runnable
- javax.swing.Action
