# Builder Design Pattern

In general, the details of object construction, such as instantiating and initializing the components that make up the object, are
kept within the object, often as part of its constructor. This type of design closely ties the object construction process with the
components that make up the object. This approach is suitable as long as the object under construction is simple and the object
construction process is definite and always produces the same representation of the object.

However, this design may not be effective when the object being created is complex and the series of steps constituting the
object creation process can be implemented in different ways, thus producing different representations of the object. Because the
different implementations of the construction process are all kept within the object, the object can become bulky (construction
bloat) and less modular. Subsequently, adding a new implementation or making changes to an existing implementation requires
changes to the existing code.

Using the Builder pattern, the process of constructing such an object can be designed more effectively. The Builder pattern
suggests moving the construction logic out of the object class to a separate class referred to as a builder class. There can be more
than one such builder classes, each with different implementations for the series of steps to construct the object. Each builder
implementation results in a different representation of the object.

To illustrate the use of the Builder Pattern, let’s help a Car company which shows its different cars using a graphical model to
its customers. The company has a graphical tool which displays the car on the screen. The requirement of the tool is to provide
a car object to it. The car object should contain the car’s specifications. The graphical tool uses these specifications to display
the car. The company has classified its cars into different classifications like Sedan or Sports Car. There is only one car object,
and our job is to create the car object according to the classification. For example, for a Sedan car, a car object according to the
sedan specification should be built or, if a sports car is required, then a car object according to the sports car specification should
be built. Currently, the Company wants only these two types of cars, but it may require other types of cars also in the future.
We will create two different builders, one of each classification, i.e., for sedan and sports cars. These two builders will help us in
building the car object according to its specification. But before that, let’s have discuss some details of the Builder Pattern.


## What is the Builder Pattern

The intent of the Builder Pattern is to separate the construction of a complex object from its representation, so that the same
construction process can create different representations. This type of separation reduces the object size. The design turns out to
be more modular with each implementation contained in a different builder object. Adding a new implementation (i.e., adding a
new builder) becomes easier. The object construction process becomes independent of the components that make up the object.
This provides more control over the object construction process.

In terms of implementation, each of the different steps in the construction process can be declared as methods of a common
interface to be implemented by different concrete builders.

A client object can create an instance of a concrete builder and invoke the set of methods required to construct different parts of
the final object. This approach requires every client object to be aware of the construction logic. Whenever the construction logic
undergoes a change, all client objects need to be modified accordingly.

The Builder pattern introduces another level of separation that addresses this problem. Instead of having client objects invoke
different builder methods directly, the Builder pattern suggests using a dedicated object referred to as a Director, which is
responsible for invoking different builder methods required for the construction of the final object. Different client objects can
make use of the Director object to create the required object. Once the object is constructed, the client object can directly request
from the builder the fully constructed object. To facilitate this process, a new method getObject can be declared in the
common Builder interface to be implemented by different concrete builders.

The new design eliminates the need for a client object to deal with the methods constituting the object construction process and
encapsulates the details of how the object is constructed from the client.

![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/creational/builder/.ProblemStatement.MD_images/UML%20Diagram%20%3D%20Builder.png)


### Builder

- Specifies an abstract interface for creating parts of a Product object

### Concrete Builder

- Constructs and assembles parts of the product by implementing the Builder interface.
- Defines and keeps track of the representation it creates.
- Provides an interface for retrieving the product.

### Director

- Constructs an object using the Builder interface.

### Product

- Represents the complex object under construction. ConcreteBuilder builds the product’s internal representation and 
defines the process by which it’s assembled.
- Includes classes that define the constituent parts, including interfaces for assembling the parts into the final result.


## When to use the Builder Pattern

Use the Builder pattern when
- The algorithm for creating a complex object should be independent of the parts that make up the object and how they’re
assembled.
- The construction process must allow different representations for the object that’s constructed.


## Builder pattern in JDK

- java.lang.StringBuilder#append() (unsynchronized)
- java.lang.StringBuffer#append() (synchronized)
- java.nio.ByteBuffer#put() (also on CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)
- javax.swing.GroupLayout.Group#addComponent()
- All implementations of java.lang.Appendable
