# Singleton Design Pattern

Sometimes it’s important for some classes to have exactly one instance. There are many objects we only need one instance
of them and if we, instantiate more than one, we’ll run into all sorts of problems like incorrect program behavior, overuse of
resources, or inconsistent results.

You may require only one object of a class, for example, when you are a creating the context of an application, or a thread
manageable pool, registry settings, a driver to connect to the input or output console etc. More than one object of that type
clearly will cause inconsistency to your program.

The Singleton Pattern ensures that a class has only one instance, and provides a global point of access to it. However, although
the Singleton is the simplest in terms of its class diagram because there is only one single class, its implementation is a bit trickier.

![UML Diagram](https://github.com/ani03sha/CSFundamentals/blob/master/DesignPatterns/Java/DesignPatterns/src/main/java/org/redquark/csfundamentals/designpatterns/creational/singleton/.ProblemStatement.MD_images/UML%20Diagram%20-%20Singleton.png)

## Ways to create Singleton pattern

### Eager initialization
```java
public class SingletonEager {

	// Eager initialization of the class
	private static SingletonEager instance = new SingletonEager();

	private SingletonEager() {

	}

	public static SingletonEager getInstance() {
		return instance;
	}
}
```

### Lazy initialization

```java
public class SingletonLazy {

	private static SingletonLazy instance = null;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}
```

### Multithreaded 

```java
public class SingletonMultithreaded {

	private static SingletonMultithreaded instance;

	private SingletonMultithreaded() {

	}

	public static synchronized SingletonMultithreaded getInstance() {
		if (instance == null) {
			instance = new SingletonMultithreaded();
		}
		return instance;
	}
}
```

### Double Checked Locking

```java
public class SingletonDoubleCheckedLocking {

	private volatile static SingletonDoubleCheckedLocking instance = null;

	private SingletonDoubleCheckedLocking() {

	}

	public static SingletonDoubleCheckedLocking getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleCheckedLocking.class) {
				if (instance == null) {
					instance = new SingletonDoubleCheckedLocking();
				}
			}
		}
		return instance;
	}
}
```

### Serializable

```java
public class Singleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton instance = new Singleton();

	private Singleton() {
		if (instance != null) {
			throw new IllegalStateException("Already created");
		}
	}

	public static Singleton getInstance() {
		return instance;
	}

	private static Class getClass(String className) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = Singleton.class.getClassLoader();
		}
		return classLoader.loadClass(className);
	}

	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

	private Object writeReplace() throws ObjectStreamException {
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton class - cannot be cloned");
	}
}
```

### Enum

```java
public class SingletonEnum {

	public enum Instance {
		SINGLETON_ENUM;
	}
}
```


## When to use Singleton

- There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point.
- When the sole instance should be extensible by sub-classing, and clients should be able to use an extended instance 
without modifying their code.
