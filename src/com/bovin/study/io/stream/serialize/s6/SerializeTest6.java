package com.bovin.study.io.stream.serialize.s6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * SerializeTest6
 *
 * @author Bovin
 * Create on 2018/6/21
 */
public class SerializeTest6 {
    private static final String TMP_FILE = "SerializeTest6.txt";

    public static void main(String[] args) {
        // 将“对象”通过序列化保存
        testWrite();
        // 将序列化的“对象”读出来
        testRead();
    }


    /**
     * 将Box对象通过序列化，保存到文件中
     */
    private static void testWrite() {
        try {
            // 获取文件TMP_FILE对应的对象输出流。
            // ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(TMP_FILE));
            // 创建Box对象，Box实现了Serializable序列化接口
            Box box = new Box("desk", 80, 48);
            // 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
            out.writeObject(box);
            // 打印“Box对象”
            System.out.println("testWrite box: " + box);
            // 修改box的值
            box = new Box("room", 100, 50);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 从文件中读取出“序列化的Box对象”
     */
    private static void testRead() {
        try {
            // 获取文件TMP_FILE对应的对象输入流。
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(TMP_FILE));
            // 从对象输入流中，读取先前保存的box对象。
            Box box = (Box) in.readObject();
            // 打印“Box对象”
            System.out.println("testRead  box: " + box);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * Box类“支持序列化”。因为Box实现了Serializable接口。
 *
 * 实际上，一个类只需要实现Serializable即可实现序列化，而不需要实现任何函数。
 */
class Box implements Serializable {
    private static int width;
    private transient int height;
    private String name;
    private Thread thread = new Thread() {
        @Override
        public void run() {
            System.out.println("Serializable thread");
        }
    };

    public Box(String name, int width, int height) {
        this.name = name;
        Box.width = width;
        this.height = height;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();//使定制的writeObject()方法可以利用自动序列化中内置的逻辑。
        out.writeInt(height);
        out.writeInt(width);
        //System.out.println("Box--writeObject width="+width+", height="+height);
    }

    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();//defaultReadObject()补充自动序列化
        height = in.readInt();
        width = in.readInt();
        //System.out.println("Box---readObject width="+width+", height="+height);
    }

    @Override
    public String toString() {
        return "["+name+": ("+width+", "+height+") ]";
    }
}
