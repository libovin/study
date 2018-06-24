# ByteArrayInputStream 和 ByteArrayOutputStream

ByteArrayInputStream 是字节数组输入流。它继承于InputStream。  
ByteArrayOutputStream 是字节数组输出流。它继承于OutputStream。

## ByteArrayInputStream.java 源码分析

**ByteArrayInputStream** **函数列表**  

```java
ByteArrayInputStream(byte[] buf)
ByteArrayInputStream(byte[] buf, int offset, int length)

synchronized int         available()
             void        close()
synchronized void        mark(int readlimit)
             boolean     markSupported()
synchronized int         read()
synchronized int         read(byte[] buffer, int offset, int length)
synchronized void        reset()
synchronized long        skip(long byteCount)
```

它包含一个内部缓冲区，该缓冲区包含从流中读取的字节；通俗点说，它的内部缓冲区就是一个字节数组，而ByteArrayInputStream本质就是通过字节数组来实现的。  
我们都知道，InputStream通过read()向外提供接口，供它们来读取字节数据；而ByteArrayInputStream 的内部额外的定义了一个计数器，它被用来跟踪 read() 方法要读取的下一个字节。

```java
package java.io;

public class ByteArrayInputStream extends InputStream {

    // 保存字节输入流数据的字节数组
    protected byte buf[];

    // 下一个会被读取的字节的索引
    protected int pos;

    // 标记的索引
    protected int mark = 0;

    // 字节流的长度
    protected int count;

    // 构造函数：创建一个内容为buf的字节流
    public ByteArrayInputStream(byte buf[]) {
        // 初始化“字节流对应的字节数组为buf”
        this.buf = buf;
        // 初始化“下一个要被读取的字节索引号为0”
        this.pos = 0;
        // 初始化“字节流的长度为buf的长度”
        this.count = buf.length;
    }

    // 构造函数：创建一个内容为buf的字节流，并且是从offset开始读取数据，读取的长度为length
    public ByteArrayInputStream(byte buf[], int offset, int length) {
        // 初始化“字节流对应的字节数组为buf”
        this.buf = buf;
        // 初始化“下一个要被读取的字节索引号为offset”
        this.pos = offset;
        // 初始化“字节流的长度”
        this.count = Math.min(offset + length, buf.length);
        // 初始化“标记的字节流读取位置”
        this.mark = offset;
    }

    // 读取下一个字节
    public synchronized int read() {
        return (pos < count) ? (buf[pos++] & 0xff) : -1;
    }

    // 将“字节流的数据写入到字节数组b中”
    // off是“字节数组b的偏移地址”，表示从数组b的off开始写入数据
    // len是“写入的字节长度”
    public synchronized int read(byte b[], int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (pos >= count) {
            return -1;
        }
        int avail = count - pos;
        if (len > avail) {
            len = avail;
        }
        if (len <= 0) {
            return 0;
        }
        System.arraycopy(buf, pos, b, off, len);
        pos += len;
        return len;
    }

    // 跳过“字节流”中的n个字节。
    public synchronized long skip(long n) {
        long k = count - pos;
        if (n < k) {
            k = n < 0 ? 0 : n;
        }
        pos += k;
        return k;
    }

    // “能否读取字节流的下一个字节”
    public synchronized int available() {
        return count - pos;
    }

    // 是否支持“标签”
    public boolean markSupported() {
        return true;
    }

    // 保存当前位置。readAheadLimit在此处没有任何实际意义
    public void mark(int readAheadLimit) {
        mark = pos;
    }

    // 重置“字节流的读取索引”为“mark所标记的位置”
    public synchronized void reset() {
        pos = mark;
    }

    public void close() throws IOException {
    }
}
```

说明：  
ByteArrayInputStream实际上是通过“字节数组”去保存数据。

1. 通过ByteArrayInputStream(byte buf[]) 或 ByteArrayInputStream(byte buf[], int offset, int length) ，我们可以根据buf数组来创建字节流对象。
2. read()的作用是从字节流中“读取下一个字节”。
3. read(byte[] buffer, int offset, int length)的作用是从字节流读取字节数据，并写入到字节数组buffer中。offset是将字节写入到buffer的起始位置，length是写入的字节的长度。
4. markSupported()是判断字节流是否支持“标记功能”。它一直返回true。
5. mark(int readlimit)的作用是记录标记位置。记录标记位置之后，某一时刻调用reset()则将“字节流下一个被读取的位置”重置到“mark(int readlimit)所标记的位置”；也就是说，reset()之后再读取字节流时，是从mark(int readlimit)所标记的位置开始读取。

## ByteArrayOutputStream 源码分析

**ByteArrayOutputStream** **函数列表**  

```java
ByteArrayOutputStream()
ByteArrayOutputStream(int size)

             void    close()
synchronized void    reset()
             int     size()
synchronized byte[]  toByteArray()
             String  toString(int hibyte)
             String  toString(String charsetName)
             String  toString()
synchronized void    write(byte[] buffer, int offset, int len)
synchronized void    write(int oneByte)
synchronized void    writeTo(OutputStream out)
```

ByteArrayOutputStream 中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。

```java
package java.io;

import java.util.Arrays;

public class ByteArrayOutputStream extends OutputStream {

    // 保存“字节数组输出流”数据的数组
    protected byte buf[];

    // “字节数组输出流”的计数
    protected int count;

    // 构造函数：默认创建的字节数组大小是32。
    public ByteArrayOutputStream() {
        this(32);
    }

    // 构造函数：创建指定数组大小的“字节数组输出流”
    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        buf = new byte[size];
    }

    // 确认“容量”。
    // 若“实际容量 < minCapacity”，则增加“字节数组输出流”的容量
    private void ensureCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - buf.length > 0)
            grow(minCapacity);
    }

    // 增加“容量”。
    private void grow(int minCapacity) {
        int oldCapacity = buf.length;
        // “新容量”的初始化 = “旧容量”x2
        int newCapacity = oldCapacity << 1;
        // 比较“新容量”和“minCapacity”的大小，并选取其中较大的数为“新的容量”。
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity < 0) {
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        buf = Arrays.copyOf(buf, newCapacity);
    }

    // 写入一个字节b到“字节数组输出流”中，并将计数+1
    public synchronized void write(int b) {
        ensureCapacity(count + 1);
        buf[count] = (byte) b;
        count += 1;
    }

    // 写入字节数组b到“字节数组输出流”中。off是“写入字节数组b的起始位置”，len是写入的长度
    public synchronized void write(byte b[], int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) ||
            ((off + len) - b.length > 0)) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(count + len);
        System.arraycopy(b, off, buf, count, len);
        count += len;
    }

    // 写入输出流outb到“字节数组输出流”中。
    public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(buf, 0, count);
    }

    // 重置“字节数组输出流”的计数。
    public synchronized void reset() {
        count = 0;
    }

    // 将“字节数组输出流”转换成字节数组。
    public synchronized byte toByteArray()[] {
        return Arrays.copyOf(buf, count);
    }

    // 返回“字节数组输出流”当前计数值
    public synchronized int size() {
        return count;
    }

    public synchronized String toString() {
        return new String(buf, 0, count);
    }

    public synchronized String toString(String charsetName)
        throws UnsupportedEncodingException
    {
        return new String(buf, 0, count, charsetName);
    }

    @Deprecated
    public synchronized String toString(int hibyte) {
        return new String(buf, hibyte, 0, count);
    }

    public void close() throws IOException {
    }
}
```

说明：  
ByteArrayOutputStream实际上是将字节数据写入到“字节数组”中去。

1. 通过ByteArrayOutputStream()创建的“字节数组输出流”对应的字节数组大小是32。
2. 通过ByteArrayOutputStream(int size) 创建“字节数组输出流”，它对应的字节数组大小是size。
3. write(int oneByte)的作用将int类型的oneByte换成byte类型，然后写入到输出流中。
4. write(byte[] buffer, int offset, int len) 是将字节数组buffer写入到输出流中，offset是从buffer中读取数据的起始偏移位置，len是读取的长度。
5. writeTo(OutputStream out) 将该“字节数组输出流”的数据全部写入到“输出流out”中。
