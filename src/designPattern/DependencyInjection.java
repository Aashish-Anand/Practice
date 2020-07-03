package designPattern;

import javax.xml.crypto.Data;

public class DependencyInjection {
    /*
     Way 1 - more depedency
     */
//    public static void main(String[] args) {
//        DependencyInjection object = new DependencyInjection();
//        User user = object.new User();
//        user.add("Today is Monday");
//    }
//
//    public class User {
//        MySqlDatabase sqlDatabase;
//        User() {
//            sqlDatabase = new MySqlDatabase();
//        }
//
//        public void add(String data) {
//            sqlDatabase.persist(data);
//        }
//    }
//    public class MySqlDatabase {
//        public void persist(String data) {
//            System.out.println("My Sql DB has successfully add : "+data);
//        }
//    }
//
//    public class OracleDatabase {
//        public void persist(String data) {
//            System.out.println("My Oracle DB has successfully add : "+data);
//        }
//    }


//    /**
//     * Way 2 - Initilization by Constructor
//     */
//    public static void main(String[] args) {
//        DependencyInjection object = new DependencyInjection();
//        User user = object.new User(object.new MySqlDatabase());
//        user.add("Today is Monday");
//
//        // but here is one problem that is if user want to have sql database what will happen
//        // it will give error of type mismatch
//        User user1 = object.new User(object.new OracleDatabase());
//        user1.add("Today is Monday");
//    }
//
//    public class User {
//        MySqlDatabase sqlDatabase;
//        User(MySqlDatabase sqlDatabase) {
//            this.sqlDatabase = sqlDatabase;
//        }
//
//        public void add(String data) {
//            sqlDatabase.persist(data);
//        }
//    }
//    public class MySqlDatabase {
//        public void persist(String data) {
//            System.out.println("My Sql DB has successfully add : "+data);
//        }
//    }
//
//    public class OracleDatabase {
//        public void persist(String data) {
//            System.out.println("My Oracle DB has successfully add : "+data);
//        }
//    }


    /**
     * Way 3 - Initilization by Interfaces Independent of Type
     */
    public static void main(String[] args) {
        DependencyInjection object = new DependencyInjection();
        User user1 = object.new User(object.new MySqlDatabase());
        user1.add("User1: Today is Monday");

        // but here is one problem that is if user want to have sql database what will happen
        // it will give error of type mismatch
        User user2 = object.new User(object.new OracleDatabase());
        user2.add("User2: Today is Monday");
    }

    public class User {
        Database database;
        User(Database database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    public interface Database {
        public void persist(String data);
    }
    public class MySqlDatabase implements Database{
        @Override
        public void persist(String data) {
            System.out.println("My Sql DB has successfully add : "+data);
        }
    }

    public class OracleDatabase implements Database {
        public void persist(String data) {
            System.out.println("My Oracle DB has successfully add : "+data);
        }
    }
}
