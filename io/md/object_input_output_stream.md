# ObjectInputStream 和 ObjectOutputStream

ObjectInputStream 和 ObjectOutputStream 的作用是，对基本数据和对象进行序列化操作支持。  
创建“文件输出流”对应的ObjectOutputStream对象，该ObjectOutputStream对象能提供对“基本数据或对象”的持久存储；当我们需要读取这些存储的“基本数据或对象”时，可以创建“文件输入流”对应的ObjectInputStream，进而读取出这些“基本数据或对象”。  
注意： 只有支持 java.io.Serializable 或 java.io.Externalizable 接口的对象才能被ObjectInputStream/ObjectOutputStream所操作！

**ObjectOutputStream** **函数列表**  

```java
                        void     close()
                        void     defaultWriteObject()
                        void     flush()
 ObjectOutputStream.PutField     putFields()
                        void     reset()
                        void     useProtocolVersion(int version)
                        void     write(int value)
                        void     write(byte[] buffer, int offset, int length)
                        void     writeBoolean(boolean value)
                        void     writeByte(int value)
                        void     writeBytes(String value)
                        void     writeChar(int value)
                        void     writeChars(String value)
                        void     writeDouble(double value)
                        void     writeFields()
                        void     writeFloat(float value)
                        void     writeInt(int value)
                        void     writeLong(long value)
                final   void     writeObject(Object object)
                        void     writeShort(int value)
                        void     writeUTF(String value)
                        void     writeUnshared(Object object)
```

**ObjectInputStream** **函数列表**  

```java
int     available()
void     close()
void     defaultReadObject()
int     read(byte[] buffer, int offset, int length)
int     read()
boolean     readBoolean()
byte     readByte()
char     readChar()
double     readDouble()
ObjectInputStream.GetField     readFields()
float     readFloat()
void     readFully(byte[] dst)
void     readFully(byte[] dst, int offset, int byteCount)
int     readInt()
String     readLine()
long     readLong()
final Object     readObject()
short     readShort()
String     readUTF()
Object     readUnshared()
int     readUnsignedByte()
int     readUnsignedShort()
synchronized void     registerValidation(ObjectInputValidation object, int priority)
int     skipBytes(int length)
```
