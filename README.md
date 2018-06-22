# 目录

1. [java.io 简介](#a)
2. [InputStream 和 OutputStream](#a)
3. [ByteArrayInputStream 和 ByteArrayOutputStream](#a)
4. [PipedOutputStream 和 PipedInputStream](#a)
5. [ObjectInputStream 和 ObjectOutputStream](#a)
6. [Serializable 和 Externalizable](#a)
7. [FileInputStream 和 FileOutputStream](#a)
8. [File、RandomAccessFile 和 FileDescriptor](#a)
9. [FilterInputStream 和 FilterOutputStream](#a)
10. [BufferedInputStream 和 BufferedOutputStream](#a)
11. [DataInputStream 和 DataOutputStream](#a)
12. [CharArrayReader 和 CharArrayWriter](#a)
13. [PipedReader和 PipedWriter](#a)
14. [InputStreamReader 和 OutputStreamWriter](#a)
15. [FileReader 和 FileWriter](#a)
16. [BufferedReader 和 BufferedWriter](#a)
17. [PrintStream、PrintWriter 与 System.out](#a)

## [java.io](./README.md)

[java.io](./README.md)的设计初衷，就是为了实现"文件、控制台、网络设备"这些io设置的通信。例如，对于一个文件，我们可以打开文件，然后进行读取和写入。在java 1.0中，java提供的类都是以字节(byte)为单位，例如，FileInputStream和FileOutputStream。而到了java 1.1，为了与国际化进行接轨，在[java.io](./README.md)中添加了许多以字符(Unicode)为单位进行操作的类。

在[java.io](./README.md)的称呼中，我们经常会提到"输入流"、"输出流"等等概念。首先，什么是流呢？  
所谓"**流**"，**就是一种抽象的数据的总称，它的本质是能够进行传输**。

* a) 按照"流"的数据流向，可以将其化分为：输入流和输出流。
* b) 按照"流"中处理数据的单位，可以将其区分为：**字节流**和**字符流**。在java中，字节是占1个Byte，即8位；而字符是占2个Byte，即16位。而且，需要注意的是，java的字节是有符号类型，而字符是无符号类型！

```java
public void main(String[] s){
    System.out.print("Hello World");
}
```