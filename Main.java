public class Main {

    interface Database {
        void connect();
        void disconnect();
    }

    static class MySQLDatabase implements Database {

        @Override
        public void connect() {
            System.out.println("MySQL дерекқорына қосылу...");
        }

        @Override
        public void disconnect() {
            System.out.println("MySQL дерекқорынан ажырату...");
        }
    }

    static class DataProcessor {

        private Database database;

        public DataProcessor(Database database) {
            this.database = database;
        }

        public void process() {
            database.connect();
            System.out.println("Деректер өңделіп жатыр...");
            database.disconnect();
        }
    }

    public static void main(String[] args) {

        Database database = new MySQLDatabase();

        DataProcessor processor = new DataProcessor(database);

        processor.process();
    }
}
