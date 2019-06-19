# Iterator design pattern

An aggregate object, such as a list, should give you a way to access its elements without exposing its internal structure. Moreover,
you might want to traverse the list in different ways, depending on what you want to accomplish. But you probably don’t want to
bloat the List interface with operations for different traversals, even if you could anticipate the ones you will need. You might
also need to have more than one traversal pending on the same list.

The Iterator pattern lets you do all this. The key idea in this pattern is to take the responsibility for access and traversal out
of the list object and put it into an iterator object. The Iterator class defines an interface for accessing the list’s elements.
An iterator object is responsible for keeping track of the current element; that is, it knows which elements have been traversed
already.


## What is Iterator design pattern

The intent of the Iterator Design Pattern is to provide a way to access the elements of an aggregate object sequentially without
exposing its underlying representation.

The Iterator pattern allows a client object to access the contents of a container in a sequential manner, without having any
knowledge about the internal representation of its contents. The term container, used above, can simply be defined as a collection
of data or objects. The objects within the container could in turn be collections, making it a collection of collections.

The Iterator pattern enables a client object to traverse through this collection of objects (or the container) without having the
container to reveal how the data is stored internally. To accomplish this, the Iterator pattern suggests that a Container object
should be designed to provide a public interface in the form of an Iterator object for different client objects to access its contents.

An Iterator object contains public methods to allow a client object to navigate through the list of objects within the container.

![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/behavioral/iterator/.ProblemStatement.MD_images/UML%20Diagram%20-%20Iterator.png)

### Iterator
- Defines an interface for accessing and traversing elements.

### ConcreteIterator
- Implements the Iterator interface.
- Keeps track of the current position in the traversal of the aggregate.

### Aggregate
- Defines an interface for creating an Iterator object.

### Concrete Aggregate
- Implements the Iterator creation interface to return an instance of the proper ConcreteIterator.


## Internal and External Iterators
   
An iterator can be designed either as an internal iterator or as an external iterator.

### Internal Iterators
- The collection itself offers methods to allow a client to visit different objects within the collection. For  
example, the java.util.ResultSet class contains the data and also offers methods such as next to navigate through the item list.
- There can be only one iterator on a collection at any given time.
- The collection has to maintain or save the state of iteration.

### External Iterators
- The iteration functionality is separated from the collection and kept inside a different object referred to as an 
iterator. Usually, the collection itself returns an appropriate iterator object to the client depending on the client
input. For example, the java.util.Vector class has its iterator defined in the form of a separate object of type 
Enumeration. This object is returned to a client object in response to the elements() method call.
- There can be multiple iterators on a given collection at any given time.
- The overhead involved in storing the state of iteration is not associated with the collection. It lies with the  
exclusive Iterator object.


## When to use the Iterator Design Pattern
   
Use the Iterator pattern:
- To access an aggregate object’s contents without exposing its internal representation.
- To support multiple traversals of aggregate objects.
- To provide a uniform interface for traversing different aggregate structures (that is, to support polymorphic 
iteration).


## Iterator Pattern in JDK
- java.util.Iterator
- java.util.Enumeration
