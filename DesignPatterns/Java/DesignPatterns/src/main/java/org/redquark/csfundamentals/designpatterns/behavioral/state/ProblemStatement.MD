# State design pattern

To illustrate the use of the State Design Pattern, let us help a company which is looking to build a robot for cooking. The company
wants a simple robot that can simply walk and cook. A user can operate a robot using a set of commands via remote control.

Currently, a robot can do three things, it can walk, cook, or can be switched off.

The company has set protocols to define the functionality of the robot. If a robot is in "on" state you can command it to walk. If
asked to cook, the state would change to "cook" or if set to "off", it will be switched off.

Similarly, when in "cook" state it can walk or cook, but cannot be switched off. And finally, when in "off" state it will automatically
get on and walk when the user commands it to walk but cannot cook in off state.

This might look like an easy implementation: a robot class with a set of methods like walk, cook, off, and states like on, cook,
and off. We can use if-else branches or switch to implement the protocols set by the company. But too much if-else or switch
statements will create a maintenance nightmare as complexity might increase in the future.

You might think that we can implement this without issues using if-else statements, but as a change comes the code would
become more complex. The requirement clearly shows that the behavior of an object is truly based on the state of that object. We
can use the State Design Pattern which encapsulates the states of the object into another individual class and keeps the context
class independent of any state change.


## What is the State Design Pattern

The State Design Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change
its class.

The state of an object can be defined as its exact condition at any given point of time, depending on the values of its properties
or attributes. The set of methods implemented by a class constitutes the behavior of its instances. Whenever there is a change in
the values of its attributes, we say that the state of an object has changed.

The State pattern is useful in designing an efficient structure for a class, a typical instance of which can exist in many different
states and exhibit different behavior depending on the state it is in. In other words, in the case of an object of such a class, some
or all of its behavior is completely influenced by its current state. In the State design pattern terminology, such a class is referred
to as a Context class. A Context object can alter its behavior when there is a change in its internal state and is also referred
as a Stateful object.

The State pattern suggests moving the state-specific behavior out of the Context class into a set of separate classes referred to
as State classes. Each of the many different states that a Context object can exist in can be mapped into a separate State
class. The implementation of a State class contains the context behavior that is specific to a given state, not the 
overall behavior of the context itself. The context acts as a client to the set of State objects in the sense that it
 makes use of different State objects to offer the necessary state-specific behavior to an application object that 
 uses the context in a seamless manner. 

By encapsulating the state-specific behavior in separate classes, the context implementation becomes simpler to read:
 free of too many conditional statements such as if-else or switch-case  constructs. When a Context object is first  
  created, it initializes itself with its initial State object. This State object becomes the current State object 
  for the context. By replacing the current State object with a new State object, the context transitions to a new 
  state.

The client application using the context is not responsible for specifying the current State object for the context, but instead, each
of the State classes representing specific states are expected to provide the necessary implementation to transition 
the context into other states. When an application object makes a call to a Context method (behavior),it forwards the
 method call to its current State object.

![UML Diagram](.ProblemStatement.MD_images/UML Diagram - State.png)


### Context
- Defines the interface of interest to clients.
- Maintains an instance of a ConcreteState subclass that defines the current state.

### State
- Defines an interface for encapsulating the behavior associated with a particular state of the Context.

### ConcreteState subclasses
- Each subclass implements a behavior associated with a state of the Context.


## When to use the State Design Pattern

Use the State pattern in either of the following cases:
- An object’s behavior depends on its state, and it must change its behavior at run-time depending on that state.
- Operations have large, multipart conditional statements that depend on the object’s state. This state is usually 
represented by one or more enumerated constants. Often, several operations will contain this same conditional 
structure. The State pattern puts each branch of the conditional in a separate class. This lets you treat the 
object’s state as an object in its own right that can vary independently from other objects.


## State Design Pattern in Java

- javax.faces.lifecycle.LifeCycle#execute()