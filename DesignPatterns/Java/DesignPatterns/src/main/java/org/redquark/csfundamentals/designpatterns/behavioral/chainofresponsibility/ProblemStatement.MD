# Chain Of Responsibility design pattern

The Chain of Responsibility pattern is a behavior pattern in which a group of objects is chained together in a sequence and a
responsibility (a request) is provided in order to be handled by the group. If an object in the group can process the particular
request, it does so and returns the corresponding response. Otherwise, it forwards the request to the subsequent object in the
group.

For a real life scenario, in order to understand this pattern, suppose you got a problem to solve. If you are able to handle it on
your own, you will do so, otherwise you will tell your friend to solve it. If he’ll able to solve he will do that, or he will also
forward it to some other friend. The problem would be forwarded until it gets solved by one of your friends or all your friends
have seen the problem, but no one is able to solve it, in which case the problem stays unresolved.

Let’s address a real life scenario. Your company has got a contract to provide an analytical application to a health company. The
application would tell the user about the particular health problem, its history, its treatment, medicines, interview of the person
suffering from it etc, everything that is needed to know about it. For this, your company receives a huge amount of data. The
data could be in any format, it could text files, doc files, excels, audio, images, videos, anything that you can think of would be
there.

Now, your job is to save this data in the company’s database. Users will provide the data in any format and you should provide
them a single interface to upload the data into the database. The user is not interested, not even aware, to know that how you are
saving the different unstructured data?

The problem here is that you need to develop different handlers to save the various formats of data. For example, a text file save
handler does not know how to save an mp3 file.

To solve this problem you can use the Chain of Responsibility design pattern. You can create different objects which process
different formats of data and chain them together. When a request comes to a single object, it will check whether it can process
and handle the specfic file format. If it can, it will process it; otherwise, it will forward it to the next object chained to it. This
design pattern also decouples the user from the object that is serving the request; the user is not aware which object is actually
serving its request.


## What is the Chain of Responsibility Pattern

The intent of this pattern is to avoid coupling the sender of a request to its receiver by giving more than one object a chance to
handle the request. We chain the receiving objects and pass the request along the chain until an object handles it.

This pattern is all about connecting objects in a chain of notification; as a notification travels down the chain, it’s handled by the
first object that is set up to deal with the particular notification.

When there is more than one objects that can handle or fulfill a client request, the pattern recommends giving each of these
objects a chance to process the request in some sequential order. Applying the pattern in such a case, each of these 
potential handlers can be arranged in the form of a chain, with each object having a reference to the next object in the chain. 

The first object in the chain receives the request and decides either to handle the request or to pass it on to the 
next object in the chain. The request flows through all objects in the chain one after the other until the request is
 handled by one of the handlers in the chain or the request reaches the end of the chain without getting processed.
 
![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/behavioral/chainofresponsibility/.ProblemStatement.MD_images/UML%20Diagram%20-%20Chain%20of%20Responsibility.png)


### Handler
- Defines an interface for handling requests.
- (Optionally) Implements the successor link.

### ConcreteHandler
- Handles requests it is responsible for.
- Can access its successor.
- If the ConcreteHandler can handle the request, it does so; otherwise it forwards the request to its successor.

### Client
- Initiates the request to a ConcreteHandler object on the chain.
- When a client issues a request, the request propagates along the chain until a ConcreteHandler object takes 
responsibility for handling it.


## When to use the Chain of Responsibility Pattern
Use Chain of Responsibility when
- More than one objects may handle a request, and the handler isn’t known a priori. The handler should be ascertained
 automatically.
- You want to issue a request to one of several objects without specifying the receiver explicitly.
- The set of objects that can handle a request should be specified dynamically.

## Chain of Responsibility in JDK
The following are the usages of the Chain of Responsibility Pattern in Java.
- java.util.logging.Logger#log()
- javax.servlet.Filter#doFilter()
