# FileInputStream 和 FileOutputStream

FileInputStream 是文件输入流，它继承于InputStream。
通常，我们使用FileInputStream从某个文件中获得输入字节。
FileOutputStream 是文件输出流，它继承于OutputStream。
通常，我们使用FileOutputStream 将数据写入 File 或 FileDescriptor 的输出流。

**FileInputStream** **函数列表** 

```java
FileInputStream(File file)         // 构造函数1：创建“File对象”对应的“文件输入流”
FileInputStream(FileDescriptor fd) // 构造函数2：创建“文件描述符”对应的“文件输入流”
FileInputStream(String path)       // 构造函数3：创建“文件(路径为path)”对应的“文件输入流”

                int      available()             // 返回“剩余的可读取的字节数”或者“skip的字节数”
                void     close()                 // 关闭“文件输入流”
         FileChannel     getChannel()    // 返回“FileChannel”
final FileDescriptor     getFD() // 返回“文件描述符”
                int      read()                  // 返回“文件输入流”的下一个字节
                int      read(byte[] buffer, int byteOffset, int byteCount) // 读取“文件输入流”的数据并存在到buffer，从byteOffset开始存储，存储长度是byteCount。
                long     skip(long byteCount)    // 跳过byteCount个字节
```

**FileOutputStream** **函数列表**  

```java
FileOutputStream(File file)                   // 构造函数1：创建“File对象”对应的“文件输入流”；默认“追加模式”是false，即“写到输出的流内容”不是以追加的方式添加到文件中。
FileOutputStream(File file, boolean append)   // 构造函数2：创建“File对象”对应的“文件输入流”；指定“追加模式”。
FileOutputStream(FileDescriptor fd)           // 构造函数3：创建“文件描述符”对应的“文件输入流”；默认“追加模式”是false，即“写到输出的流内容”不是以追加的方式添加到文件中。
FileOutputStream(String path)                 // 构造函数4：创建“文件(路径为path)”对应的“文件输入流”；默认“追加模式”是false，即“写到输出的流内容”不是以追加的方式添加到文件中。
FileOutputStream(String path, boolean append) // 构造函数5：创建“文件(路径为path)”对应的“文件输入流”；指定“追加模式”。

                void    close()      // 关闭“输出流”
         FileChannel    getChannel() // 返回“FileChannel”
final FileDescriptor    getFD()      // 返回“文件描述符”
                void    write(byte[] buffer, int byteOffset, int byteCount) // 将buffer写入到“文件输出流”中，从buffer的byteOffset开始写，写入长度是byteCount。
                void    write(int oneByte)  // 写入字节oneByte到“文件输出流”中
```