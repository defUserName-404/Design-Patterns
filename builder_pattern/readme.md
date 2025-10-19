# Builder

## 🦧 Intent

**Builder** is a creational design pattern that lets you construct complex objects step by step. The pattern allows you
to produce different types and representations of an object using the same construction code.

## 🙁 Problem

Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects. Such
initialization code is usually buried inside a monstrous constructor with a dozen parameters. Or even worse: scattered
all over the client code.

<img src="src/main/resources/problem1.png">
<center><i>You might make the program too complex by creating a subclass for every possible configuration of an object.</i></center>


For example, let’s think about how to create a `House` object. To build a simple house, you need to construct four walls
and a floor, install a door, fit a pair of windows, and build a roof. But what if you want a bigger, brighter house,
with a backyard and other goodies (like a heating system, plumbing, and electrical wiring)?

The simplest solution is to extend the base `House` class and create a set of subclasses to cover all combinations of
the parameters. But you’ll end up with a considerable number of subclasses. Any new parameter, such as the porch style,
will require growing this hierarchy even more.

There’s another approach. You can create a giant constructor with all possible parameters to control the `House` object.
While this approach eliminates the need for subclasses, it creates another problem. In most cases, most of the
parameters will be unused, making the constructor calls pretty ugly.

<img src="src/main/resources/problem2.png">
<center><i>The constructor with lots of parameters has its downside: not all the parameters are needed at all times.</i></center>

## 😀 Solution

The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate
objects called *builders*.

<img src="src/main/resources/solution1.png">
<center><i>The Builder pattern lets you construct complex objects step by step. The Builder doesn’t allow other objects to access the product while it’s being built.</i></center>

The pattern organizes object construction into a set of steps (for instance, `buildWalls`, `buildDoor`, etc.). To create
an object, you execute a series of these steps on a builder object. The important part is that you don’t need to call
all of the steps. You can call only those steps that are necessary for producing a particular configuration of an
object.

Some of the construction steps might require different implementation when you need to build different representations
of the product. For example, walls of a cabin may be built of wood, while the castle walls must be built with stone.

In this case, you can create several different builder classes that implement the same set of building steps, but in a
different manner. Then you can use these builders in the construction process (i.e., an ordered set of calls to the
building steps) to produce different kinds of objects.

For example, imagine a director that tells the builder what to do. The `Director` knows in which order to execute the
building steps. It works with a builder object through the common interface of all builders. This way the director
doesn’t know the type of product being built.

## Structure

<img src="src/main/resources/structure.png">

1. The **Builder** interface declares product construction steps that are common to all types of builders.
2. **Concrete Builders** provide different implementations of the construction steps. Concrete builders may produce
   products that don’t follow the common interface.
3. **Products** are resulting objects. Products constructed by different builders don’t have to belong to the same class
   hierarchy or interface.
4. The **Director** class defines the order in which to call construction steps, so you can create and reuse specific
   configurations of products.
5. The **Client** must associate one of the builder objects with the director. Usually, it’s done just once, via
   parameters of the director’s constructor. Then the director uses that builder object for all further construction.
   However, there’s an alternative approach for when the client passes the builder object to the production method of
   the director.

## Pseudocode

This example of the **Builder** pattern illustrates how you can reuse the same object construction code when building
different types of products, such as cars, and create the corresponding manuals for them.

<img src="src/main/resources/example-en.png">
<center><i>The example of step-by-step construction of cars and the user guides that that fit those car models.</i></center>

A car is a complex object that can be constructed in a hundred different ways. Instead of bloating the `Car` class with
a huge constructor, you can extract the assembly code into a separate `CarBuilder` class. This class has a set of
methods for configuring a car.

The client code can use the builder directly to create a custom car configuration.

But what if you need to create a car manual? The manual should describe every feature of the car, so the details of the
manual depend on the car’s configuration. You can create another builder class, `CarManualBuilder`, that builds the
manual instead of a car. Then you can pass this builder to the same director object to produce a manual for a specific
car configuration.

```
// Using the Builder pattern makes sense only when your products
// are quite complex and require extensive configuration. The
// following two products are related, although they don't have
// a common interface.
class Car is
    // A car can have a GPS, trip computer and some number of
    // seats. Different models of cars (sports car, SUV,
    // cabriolet) might have different features installed or
    // enabled.

class Manual is
    // Each car should have a user manual that corresponds to
    // the car's configuration and describes all its features.


// The builder interface specifies methods for creating the
// different parts of the product objects.
interface Builder is
    method reset()
    method setSeats(...)
    method setEngine(...)
    method setTripComputer(...)
    method setGPS(...)

// The concrete builder classes follow the builder interface and
// provide specific implementations of the building steps. Your
// program may have several variations of builders, each
// implemented differently.
class CarBuilder implements Builder is
    private field car:Car

    // A fresh builder instance should contain a blank product
    // object which it uses in further assembly.
    constructor CarBuilder() is
        this.reset()

    // The reset method clears the object being built.
    method reset() is
        this.car = new Car()

    // All production steps work with the same product instance.
    method setSeats(...) is
        // Set the number of seats in the car.

    method setEngine(...) is
        // Install a given engine.

    method setTripComputer(...) is
        // Install a trip computer.

    method setGPS(...) is
        // Install a global positioning system.

    // Concrete builders are supposed to provide their own
    // methods for retrieving results. That's because various
    // types of builders may create entirely different products
    // that don't all follow the same interface. Therefore such
    // methods can't be declared in the builder interface (at
    // least not in a statically-typed programming language).
    //
    // Usually, after returning the end result to the client, a
    // builder instance is expected to be ready to start
    // producing another product. That's why it's a usual
    // practice to call the reset method at the end of the
    // `getProduct` method body. However, this behavior isn't
    // mandatory, and you can make your builder wait for an
    // explicit reset call from the client code before disposing
    // of the previous result.
    method getProduct():Car is
        product = this.car
        this.reset()
        return product

// Unlike other creational patterns, builder lets you construct
// products that don't follow the common interface.
class CarManualBuilder implements Builder is
    private field manual:Manual

    constructor CarManualBuilder() is
        this.reset()

    method reset() is
        this.manual = new Manual()

    method setSeats(...) is
        // Document car seat features.

    method setEngine(...) is
        // Add engine instructions.

    method setTripComputer(...) is
        // Add trip computer instructions.

    method setGPS(...) is
        // Add GPS instructions.

    method getProduct():Manual is
        // Return the manual and reset the builder.


// The director is only responsible for executing the building
// steps in a particular sequence. It's helpful when producing
// products according to a specific order or configuration.
// Strictly speaking, the director class is optional, since the
// client can control builders directly.
class Director is
    // The director works with any builder instance that the
    // client code passes to it. This way, the client code may
    // alter the final type of the newly assembled product.
    // The director can construct several product variations
    // using the same building steps.
    method constructSportsCar(builder: Builder) is
        builder.reset()
        builder.setSeats(2)
        builder.setEngine(new SportEngine())
        builder.setTripComputer(true)
        builder.setGPS(true)

    method constructSUV(builder: Builder) is
        // ...


// The client code creates a builder object, passes it to the
// director and then initiates the construction process. The end
// result is retrieved from the builder object.
class Application is

    method makeCar() is
        director = new Director()

        CarBuilder builder = new CarBuilder()
        director.constructSportsCar(builder)
        Car car = builder.getProduct()

        CarManualBuilder builder = new CarManualBuilder()
        director.constructSportsCar(builder)

        // The final product is often retrieved from a builder
        // object since the director isn't aware of and not
        // dependent on concrete builders and products.
        Manual manual = builder.getProduct()
```

## ✨ Application

**⚠️ Use the Builder pattern to get rid of a “telescoping constructor”.**

**🗲** Say you have a constructor with ten optional parameters. Calling such a beast is very inconvenient; therefore, you
overload the constructor and create several shorter versions with fewer parameters. These constructors still refer to
the main one, passing some default values into any omitted parameters.

```
class Pizza {
    Pizza(int size) { ... }
    Pizza(int size, boolean cheese) { ... }
    Pizza(int size, boolean cheese, boolean pepperoni) { ... }
    // ...
```

The Builder pattern lets you build objects step by step, using only those steps that you really need. After implementing
the pattern, you don’t have to cram a dozen
parameters into your constructors anymore.

**⚠️ Use the Builder pattern when you want your code to be able to create different representations of some product (for
example, stone and wooden houses).**

**🗲** The Builder pattern can be applied when construction of various representations of the product involves similar
steps that differ only in the details. The base builder interface defines all possible construction steps, and concrete
builders implement these steps to construct particular representations of the product. Meanwhile, the director class
guides the order of construction.

**⚠️ Use the Builder to construct Composite trees or other complex objects.**

**🗲** The Builder pattern lets you construct products step-by-step. You could defer execution of some steps without
breaking the final product. You can even call steps recursively, which is useful when you need to build an object tree.
A builder doesn’t expose the unfinished product while running construction steps. This prevents the client code from
fetching an incomplete result.

## 📋 How to Implement

1. Make sure that you can define the construction steps for all product representations. Otherwise, you won’t be able to
   implement the pattern.
2. Declare the common builder interface with the building steps.
3. Create concrete builder classes for each of the product representations and implement their construction steps.
4. Think about creating a director class. It may encapsulate various ways to construct a product using the same builder
   object.
5. The client code creates both the director and a builder object. Before construction starts, the client passes a
   builder object to the director.
6. The client can get the result of the construction from the builder.

## ⚖️ Pros and Cons

| ✅ **Pros**                                                                                                             | ❌ **Cons**                                                                                             |
|------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| You can construct objects step-by-step, defer construction steps or run steps recursively.                             | The overall complexity of the code increases since the pattern requires creating multiple new classes. |
| You can reuse the same construction code when building various representations of products.                            |                                                                                                        |
| **Single Responsibility Principle**. You can isolate complex construction code from the business logic of the product. |                                                                                                        |

## ↔️ Relations with Other Patterns

- Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve
  toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
- **Abstract Factory** classes are often based on a set of **Factory Methods**, but you can also use **Prototype** to
  compose the methods on these classes.
- You can use **Builder** when creating complex **Composite** trees because you can program its construction steps to
  work recursively.
- You can combine **Builder** with **Bridge**: the director class plays the role of the abstraction, while different
  builders act as implementations.
- **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.
