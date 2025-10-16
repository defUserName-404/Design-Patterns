# Abstract Factory

##### Also Known as: Kit

## 🦧 Intent

**Abstract Factory** is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

## 🙁 Problem

Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:
1.  A family of related products, say: `Chair` + `Sofa` + `DiningTable`.
2.  Several variants of this family. For example, products `Chair`, `Sofa` and `DiningTable` are available in these variants: `Modern`, `Victorian`, `ArtDeco`.

<img src="../../../../../../../abstract_factory_pattern/src/main/resources/problem1.png" alt="Problem">
<center><i>You need a way to create individual furniture objects so that they match other objects of the same family.</i></center>

You need a way to create individual furniture objects so that they match other objects of the same family. Customers get quite mad when they receive non-matching furniture.

Also, you don’t want to change existing code when adding new products or families of products to the program. Furniture vendors update their catalogs very often, and you wouldn’t want to change the core code with every update.

## 😀 Solution

The first thing the Abstract Factory pattern suggests is to declare interfaces for each distinct product of the product family (for example, `Chair`, `Sofa` or `DiningTable`). Then you can make all variants of products follow those interfaces. For example, all chair variants can implement the `Chair` interface; all sofa variants can implement the `Sofa` interface, and so on.

<img src="../../../../../../../abstract_factory_pattern/src/main/resources/solution1.png" alt="Solution">
<center><i>All variants of the same object must implement a common interface.</i></center>

The next step is to declare the *Abstract Factory*—an interface with a list of creation methods for all products that are part of the product family (for example, `createChair`, `createSofa` and `createDiningTable`). These methods must return *abstract* product types represented by the interfaces we extracted previously: `Chair`, `Sofa`, `DiningTable` and so on.

<img src="../../../../../../../abstract_factory_pattern/src/main/resources/solution2.png" alt="Solution">
<center><i>Each concrete factory corresponds to a specific product variant.</i></center>

Now, how about the product variants? For each variant of a product family, we create a separate factory class that implements the `AbstractFactory` interface. For example, a `ModernFurnitureFactory` can only create `ModernChair`, `ModernSofa` and `ModernDiningTable` objects.

The client code has to work with factories and products via their respective abstract interfaces. This lets you change the type of a factory that you pass to the client code, as well as the product variant that the client code receives, without breaking the client code.

<img src="../../../../../../../abstract_factory_pattern/src/main/resources/solution3.png" alt="Solution">
<center><i>The client’s code shouldn’t have to worry about the concrete variant of the product it gets from a factory.</i></center>

Let’s say the client wants a factory to produce a chair. The client doesn’t have to be aware of the factory’s class, nor does it matter what kind of chair it gets. Whether it’s a Modern model or a Victorian-style chair, the client must treat it as an abstract `Chair`. This way the client only needs to know that the chair implements the `sitOn` method. Also, whichever variant of the chair is returned, it’ll always match the type of sofa or dining table produced by the same factory object.

There’s one more thing left to clarify: if the client is only exposed to the abstract interfaces, what creates the actual factories? Usually, the application creates a concrete factory object at the initialization stage. Just before that, the app must select the factory type depending on the configuration or the environment settings.

## Structure

<img src="../../../../../../../abstract_factory_pattern/src/main/resources/structure.png" alt="Structure">
<center><i>Structure of the Abstract Factory pattern.</i></center>

1.  **Abstract Products** declare interfaces for a set of distinct but related products which make up a product family.
2.  **Concrete Products** are various implementations of abstract products, grouped by variants. Each abstract product (e.g., `Chair` or `Sofa`) must be implemented in all given variants (e.g., `Modern`, `Victorian`, `ArtDeco`).
3.  The **Abstract Factory** interface declares a set of methods for creating each of the abstract products.
4.  **Concrete Factories** implement creation methods of the abstract factory. Each concrete factory corresponds to a specific variant of products and creates only those product variants.
5.  Although concrete factories instantiate concrete products, signatures of their creation methods must return corresponding abstract products. This way the client code that uses a factory doesn’t get coupled to the specific variant of the product it gets from a factory. The **Client** can work with any concrete factory/product variant, as long as it communicates with their objects via abstract interfaces.

## ✨ Application

**⚠️ Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.**

**🗲** The Abstract Factory provides you with an interface for creating objects from each class of the product family. As long as your code creates objects via this interface, you don’t have to worry about creating the wrong variant of a product which doesn’t match the products already created by your app.

**⚠️ Consider using the Abstract Factory when you have a class with a set of Factory Methods that slumber in slumber. **

**🗲** In a well-designed program, *each class is responsible for only one thing*. When a class deals with multiple product types, it may be worth extracting its factory methods into a stand-alone factory class or a full-blown Abstract Factory.

## 📋 How to Implement

1.  Map out a matrix of distinct product types versus variants of these products.
2.  Declare abstract product interfaces for all product types. Then make all concrete product classes implement these interfaces.
3.  Declare the abstract factory interface with a set of creation methods for all abstract products.
4.  Implement a set of concrete factory classes, one for each product variant.
5.  Create factory initialization code somewhere in the app. It should instantiate one of the concrete factory classes, depending on the application configuration or environment settings. Pass this factory object to all classes that construct products.
6.  Scan through the code and find all direct calls to product constructors. Replace them with calls to the appropriate creation method on the factory object.

## ⚖️ Pros and Cons

| ✅ **Pros**                                                                                                                                     | ❌ **Cons**                                                                                                         |
|------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| You can be sure that the products you get from a factory are compatible with each other.                                                       | The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern. |
| You avoid tight coupling between concrete products and client code.                                                                            |                                                                                                                    |
| **Single Responsibility Principle**. You can extract the product creation code into one place, making the code easier to support.              |                                                                                                                    |
| **Open/Closed Principle**. You can introduce new variants of products without breaking existing client code.                                   |                                                                                                                    |

## ↔️ Relations with Other Patterns

- Many designs start by using **Factory Method** (less complicated and more customizable via subclasses) and evolve toward **Abstract Factory**, **Prototype**, or **Builder** (more flexible, but more complicated).
- **Builder** focuses on constructing complex objects step by step. **Abstract Factory** specializes in creating families of related objects. *Abstract Factory* returns the product immediately, whereas *Builder* lets you run some construction steps before fetching the product.
- **Abstract Factory** classes are often based on a set of **Factory Methods**, but you can also use **Prototype** to compose the methods on these classes.
- **Abstract Factory** can be used as an alternative to **Facade** to hide the platform-specific classes.
- You can use **Abstract Factory** along with **Bridge**. This pairing is useful when some abstractions defined by *Bridge* can only work with specific implementations. In this case, *Abstract Factory* can encapsulate these relations and hide the complexity from the client code.
- **Abstract Factories**, **Builders** and **Prototypes** can all be implemented as **Singletons**.
