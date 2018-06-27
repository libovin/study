# File、RandomAccessFile 和 FileDescriptor

File 是“文件”和“目录路径名”的抽象表示形式。
File 直接继承于Object，实现了Serializable接口和Comparable接口。实现Serializable接口，意味着File对象支持序列化操作。而实现Comparable接口，意味着File对象之间可以比较大小；File能直接被存储在有序集合(如TreeSet、TreeMap中)。

**File** **函数列表**  
