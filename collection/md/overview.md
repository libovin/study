# Collections Framework 简介

Java平台包含一个集合框架。集合是表示一组对象的对象（如经典的Vector类）。集合框架是用于表示和操作集合的统一体系结构，使集合可以独立于实现细节而被操纵。

Collections Framework主要优点有：

* **降低编程难度(Reduces programming effort)**
* **提高程序性能(Increases performance)**
* **提高API间的互操作性(Provides interoperability between unrelated APIs)**
* **降低学习难度(Reduces the effort required to learn APIs)**
* **降低设计和实现相关API的难度(Reduces the effort required to design and implement APIs)**
* **增加程序的重用性(Fosters software reuse)**

Collections Framework 包含：

* **集合接口(Collection interfaces)**：表示不同类型的集合，例如Set，List和Map。这些接口构成了框架的基础。
* **通用实现(General-purpose implementations)**：集合接口的主要实现。
* **传统的实现(Legacy implementations)**：早期版本Vector和Hashtable中的集合类进行了改进，以实现集合接口。
* **特殊用途的实现(Special-purpose implementations)**：设计用于特殊情况的实现。这些实现显示非标准的性能特征，使用限制或行为。
* **并发实现(Concurrent implementations)**：为高并发使用而设计的实现。
* **包装实现(Wrapper implementations)**：将功能（如同步）添加到其他实现。
* **方便实现(Convenience implementations)**：高性能的集合接口“简易实现”。
* **抽象的实现(Abstract implementations)**：集合接口的部分实现，以方便自定义实现。
* **算法(Algorithms)**：对集合执行有用功能的静态方法，例如排序列表。
* **基础设施(Infrastructure)**：为收集界面提供重要支持的接口。
* **阵列实用程序(Array Utilities)**：基本类型和引用对象数组的实用函数。严格来说，并不是集合框架的一部分，这个特性与集合框架同时添加到Java平台，并依赖于相同的基础结构。

![java.util](../img/collection.jpg)

java集合框架主要分两大类型,一种是集合(Collection),另一种是图(Map)。Collection我们可以理解为一个大小可变,提供各种操作数据方法的数组,而Map是一种key-value数据结构的集合。

Collection是存储一组对象的集合容器,它主要有以下三个接口子类