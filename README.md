# Dagger2
Dagger 2 is dependency injection framework. It is based on the Java Specification Request (JSR) 330. It uses code generation and is based on annotations. The generated code is very relatively easy to read and debug.

Dagger 2 analyzes dependencies for you and generates code to help wire them
together.

# ANNOTATIONS USED BY DAGGER 2
• @Module and @Provides: define classes and methods which provide dependencies

• @Inject: request dependencies. Can be used on a constructor, a field, or a method

• @Component: enable selected modules and used for performing dependency injection

# Defining dependency provider (object providers)
The term dependency injection context is typically used to describe the set of objects which can be injected.

In Dagger 2, classes annotated with @Module are responsible for providing objects which can be injected. Such classes can define methods annotated with @Provides. The returned objects from these methods are available for dependency injection.

Methods annotated with @Provides can also express dependencies via method parameters. These dependencies are fulfilled by Dagger 2, if possible.

# Defining dependencies (object consumers)
You use the @Inject annotation to define a dependency. If you annotate a constructor with @Inject, Dagger 2 can also use an instance of this object to fulfill dependencies. This was done to avoid the definition of lots of @Provides methods for these objects

# Connecting consumers and providers
The @Component is used on an interface. Such an interface is used by Dagger 2 to generate code. The base pattern for the generated class is that Dagger is used as prefix followed by the interface name. This generate class has a create method which allows configuring the objects based on the given configuration. The methods defined on the interface are available to access the generated objects.


