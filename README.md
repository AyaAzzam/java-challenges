
# Challenge A 
Please create an algorithm that takes a list of classes and sorts them in a way, that whenever
- class A is subclass of class B
- class A implements interface B the index of B is smaller than A.
a JUnit Test added.

# Challenge B
Create a base class Dispatcher, that picks all subclass methods - with a given name - assuming one parameter and sorts them internally with respect to the parameter type. A public method
Object dispatch(Object param)
will be offered, that accepts one parameter and will call the best matching method.
Best match means, that it will call the method with exactly the same parameter type, if available, or the next match with respect to a super class or interface.
