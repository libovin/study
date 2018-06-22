# [java.io 简介](./README.md)

[java.io](./README.md)的设计初衷，就是为了实现"文件、控制台、网络设备"这些io设置的通信。例如，对于一个文件，我们可以打开文件，然后进行读取和写入。
在[java.io](./README.md)的称呼中，我们经常会提到"**输入流**"、"**输出流**"等等概念。首先，什么是流呢？  
所谓"**流**"，就是一种**抽象的数据的总称**，它的本质是能够进行传输。

* a) 按照"流"的**数据流向**，可以将其化分为：**输入流**和**输出流**。
* b) 按照"流"中**处理数据的单位**，可以将其区分为：**字节流**和**字符流**。在java中，字节是占1个Byte，即8位；而字符是占2个Byte，即16位。而且，需要注意的是，java中字节是有符号类型，而字符是无符号类型！

## 1. 以字节为单位的输入流

![InputStream](../img/InputStream.jpg)
从中，我们可以看出。以字节为单位的输入流的公共父类是InputStream。

1. InputStream 是以字节为单位的输入流的超类。InputStream提供了read()接口从输入流中读取字节数据。
2. ByteArrayInputStream 是字节数组输入流。它包含一个内部缓冲区，该缓冲区包含从流中读取的字节；通俗点说，它的内部缓冲区就是一个字节数组，而ByteArrayInputStream本质就是通过字节数组来实现的。
3. PipedInputStream 是管道输入流，它和PipedOutputStream一起使用，能实现多线程间的管道通信。
4. FilterInputStream 是过滤输入流。它是DataInputStream和BufferedInputStream的超类。
5. DataInputStream 是数据输入流。它是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”。
6. BufferedInputStream 是缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
7. File 是“文件”和“目录路径名”的抽象表示形式。关于File，注意两点：
    * File不仅仅只是表示文件，它也可以表示目录！
    * File虽然在io保重定义，但是它的超类是Object，而不是InputStream。
8. FileDescriptor 是“文件描述符”。它可以被用来表示开放文件、开放套接字等。
9. FileInputStream 是文件输入流。它通常用于对文件进行读取操作。
10. ObjectInputStream 是对象输入流。它和ObjectOutputStream一起，用来提供对“基本数据或对象”的持久存储。

## 2. 以字节为单位的输出流

![OutputStream](../img/OutputStream.jpg)
从中，我们可以看出。以字节为单位的输出流的公共父类是OutputStream。

1. OutputStream 是以字节为单位的输出流的超类。OutputStream提供了write()接口从输出流中读取字节数据。
2. ByteArrayOutputStream 是字节数组输出流。写入ByteArrayOutputStream的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。
3. PipedOutputStream 是管道输出流，它和PipedInputStream一起使用，能实现多线程间的管道通信。
4. FilterOutputStream 是过滤输出流。它是DataOutputStream，BufferedOutputStream和PrintStream的超类。
5. DataOutputStream 是数据输出流。它是用来装饰其它输出流，它“允许应用程序以与机器无关方式向底层写入基本 Java 数据类型”。
6. BufferedOutputStream 是缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
7. PrintStream 是打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
8. FileOutputStream 是文件输出流。它通常用于向文件进行写入操作。
9. ObjectOutputStream 是对象输出流。它和ObjectInputStream一起，用来提供对“基本数据或对象”的持久存储。

## 3. 以字节为单位的输入流和输出流关联图

![OutputStream_InputStream](../img/OutputStream_InputStream.jpg)

## 4. 以字符为单位的输入流

![Reader](../img/Reader.jpg)
从中，我们可以看出。以字符为单位的输入流的公共父类是Reader。

1. Reader 是以字符为单位的输入流的超类。它提供了read()接口来取字符数据。
2. CharArrayReader 是字符数组输入流。它用于读取字符数组，它继承于Reader。操作的数据是以字符为单位！
3. PipedReader 是字符类型的管道输入流。它和PipedWriter一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedReader配套使用。
4. FilterReader 是字符类型的过滤输入流。
5. BufferedReader 是字符缓冲输入流。它的作用是为另一个输入流添加缓冲功能。
6. InputStreamReader 是字节转字符的输入流。它是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
7. FileReader 是字符类型的文件输入流。它通常用于对文件进行读取操作。

## 5. 以字符为单位的输出流

![Writer](../img/Writer.jpg)
从中，我们可以看出。以字符为单位的输出流的公共父类是Writer。

1. Writer 是以字符为单位的输出流的超类。它提供了write()接口往其中写入数据。
2. CharArrayWriter 是字符数组输出流。它用于读取字符数组，它继承于Writer。操作的数据是以字符为单位！
3. PipedWriter 是字符类型的管道输出流。它和PipedReader一起是可以通过管道进行线程间的通讯。在使用管道通信时，必须将PipedWriter和PipedWriter配套使用。
4. FilterWriter 是字符类型的过滤输出流。
5. BufferedWriter 是字符缓冲输出流。它的作用是为另一个输出流添加缓冲功能。
6. OutputStreamWriter 是字节转字符的输出流。它是字节流通向字符流的桥梁：它使用指定的 charset 将字节转换为字符并写入。
7. FileWriter 是字符类型的文件输出流。它通常用于对文件进行读取操作。
8. PrintWriter 是字符类型的打印输出流。它是用来装饰其它输出流，能为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。

## 6. 以字符为单位的输入流和输出流关联图

![Writer_Reader](../img/Writer_Reader.jpg)

## 7. 字节转换为字符流

![File](../img/File.jpg)
从中，我们可以看出。

1. FileReader继承于InputStreamReader，而InputStreamReader依赖于InputStream。具体表现在InputStreamReader的构造函数是以InputStream为参数。我们传入InputStream，在InputStreamReader内部通过转码，将字节转换成字符。
2. FileWriter继承于OutputStreamWriter，而OutputStreamWriter依赖于OutputStream。具体表现在OutputStreamWriter的构造函数是以OutputStream为参数。我们传入OutputStream，在OutputStreamWriter内部通过转码，将字节转换成字符。

## 8. 字节和字符的输入流对应关系

![InputStream_Reader](../img/InputStream_Reader.jpg)

## 9. 字节和字符的输出流对应关系

![OutputStream_Writer](../img/OutputStream_Writer.jpg)