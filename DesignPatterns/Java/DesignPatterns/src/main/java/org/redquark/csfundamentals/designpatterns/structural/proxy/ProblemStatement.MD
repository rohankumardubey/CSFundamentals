# Proxy design pattern

The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.

The Proxy Pattern comes up with many different variations. Some of the important variations are, Remote Proxy, 
Virtual Proxy, and Protection Proxy. In this lesson, we will know more about these variations and we will 
implement each of them in Java.


## What is proxy pattern

The Proxy Pattern is used to create a representative object that controls access to another object, which may be remote, expensive
to create or in need of being secured.

One reason for controlling access to an object is to defer the full cost of its creation and initialization until we actually need to
use it. Another reason could be to act as a local representative for an object that lives in a different JVM. The Proxy can be very
useful in controlling the access to the original object, especially when objects should have different access rights.

In the Proxy Pattern, a client does not directly talk to the original object, it delegates it calls to the proxy object which calls the
methods of the original object. The important point is that the client does not know about the proxy, the proxy acts as an original
object for the client. But there are many variations to this approach which we will see soon.

Let us see the structure of the Proxy Pattern and its important participants.

![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/structural/proxy/.ProblemStatement.MD_images/UML%20Diagram%20-%20Proxy.png)

- Proxy: 1a. Maintains a reference that lets the proxy access the real subject. Proxy may refer to a Subject if the 
RealSubject
and Subject interfaces are the same. 1b. Provides an interface identical to Subject’s so that a proxy can be substituted for the
real subject. 1c. Controls access to the real subject and may be responsible for creating and deleting it.

- Subject: 2a. Defines the common interface for RealSubject and Proxy so that a Proxy can be used anywhere a 
RealSubject is
expected.

- RealSubject: 3a. Defines the real object that the proxy represents.

There are three main variations to the Proxy Pattern:
- A remote proxy provides a local representative for an object in a different address space.
- A virtual proxy creates expensive objects on demand.
- A protection proxy controls access to the original object. Protection proxies are useful when objects should have 
different access rights.


## When to use the Proxy Pattern

Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a simple pointer.

Here are several common situations in which the Proxy pattern is applicable:
- A remote proxy provides a local representative for an object in a different address space.
- A virtual proxy creates expensive objects on demand.
- A protection proxy controls access to the original object. Protection proxies are useful when objects should have 
different access rights.
   
   
## Other Proxies

Besides the above discussed three main proxies, there are some other kinds of proxies.
- Cache Proxy/Server Proxy: To provide the functionality required to store the results of most frequently used target
 operations.
- The proxy object stores these results in some kind of a repository. When a client object requests the same 
operation, the proxy returns the operation results from the storage area without actually accessing the target object.
- Firewall Proxy: The primary use of a firewall proxy is to protect target objects from bad clients. A firewall proxy 
can also be used to provide the functionality required to prevent clients from accessing harmful targets.
- Synchronization Proxy: To provide the required functionality to allow safe concurrent accesses to a target object 
by different client objects.
- Smart Reference Proxy: To provide the functionality to prevent the accidental disposal/deletion of the target 
object when there are clients currently with references to it. To accomplish this, the proxy keeps a count of the 
number of references to the target object. The proxy deletes the target object if and when there are no references to
 it.
- Counting Proxy: To provide some kind of audit mechanism before executing a method on the target object.


## Proxy Pattern in JDK

The following cases are examples of usage of the Proxy Pattern in the JDK.
- java.lang.reflect.Proxy
- java.rmi.* (whole package)
