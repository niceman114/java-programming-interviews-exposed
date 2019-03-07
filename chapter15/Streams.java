package com.wiley.javainterviewsexposed.chapter15;

import org.junit.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;

public class Streams {

    public static class Pair implements Serializable {
        private final int number;
        private final String name;

        public Pair(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void writeData() throws IOException {
        final FileOutputStream fos = new FileOutputStream("/tmp/file");
        final ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeInt(101);
        oos.writeBoolean(false);
        oos.writeUTF("Writing a string");

        final Pair pair = new Pair(42, "Forty two");
        oos.writeObject(pair);

        oos.flush();
        oos.close();
        fos.close();
    }

    @Test
    public void readData() throws IOException, ClassNotFoundException {
        final FileInputStream fis = new FileInputStream("/tmp/file");
        final ObjectInputStream ois = new ObjectInputStream(fis);

        final int number = ois.readInt();
        final boolean bool = ois.readBoolean();
        final String string = ois.readUTF();
        final Pair pair = (Pair) ois.readObject();

        assertEquals(101, number);
        assertFalse(bool);
        assertEquals("Writing a string", string);
        assertEquals(42, pair.getNumber());
        assertEquals("Forty two", pair.getName());
    }

    public static class User implements Serializable {
        private String username;
        private transient String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    @Test
    public void transientField()
            throws IOException, ClassNotFoundException {
        final User user = new User("Noel", "secret321");

        final FileOutputStream fos = new FileOutputStream("/tmp/user");
        final ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);

        oos.flush();
        oos.close();
        fos.close();

        final FileInputStream fis = new FileInputStream("/tmp/user");
        final ObjectInputStream ois = new ObjectInputStream(fis);

        final User deserialized = (User) ois.readObject();

        assertEquals("Noel", deserialized.getUsername());
        assertNull(deserialized.getPassword());
    }
}
