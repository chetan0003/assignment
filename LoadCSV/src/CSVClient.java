import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CSVClient {

    private static final int THREAD_POOL_SIZE = 5;


    private static void process() {

        String csvFilePath = "C://Users/Asus/Downloads/country.csv";
        int totalRecords = 0;
        try {
            totalRecords = countRecords(csvFilePath);
            System.out.println("Total Records in CSV file: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection dbConnection = DBUtil.getDBConnection();
        List<Record> records = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                List<Future<Record>> futures = new ArrayList<>();
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

                final int[] processedRecords = {0};
                String line;
                JProgressBar progressBar = ProgressBar.getProgressBar();

                while ((line = reader.readLine()) != null) {
                    String finalLine = line;
                    int finalTotalRecords = totalRecords;
                    Future<Record> future = (Future<Record>) executorService.submit(() -> {
                        Record record = getRecord(finalLine);
                        insertRecord(record, dbConnection);
                        processedRecords[0] = processedRecords[0] + 1;
                        int progress = getProgress(processedRecords[0], finalTotalRecords);
                        progressBar.setValue(progress);
                        return record;
                    });
                    futures.add(future);
                }

                for (Future<Record> future : futures) {
                    try {
                        Record record = future.get();
                        if (record != null) {
                            records.add(record);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                executorService.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private static synchronized int getProgress(int processedRecords, int totalRecords) {
        processedRecords++;
        int progress = (int) (((double) processedRecords / totalRecords) * 100);
        return progress;
    }

    private static Record getRecord(String line) {
        System.out.println("Inserting record....");
        String[] split = line.split(",");
        return new Record(split[0], split[1]);
    }

    private static void insertRecord(Record record, Connection con) throws SQLException {
        if (!"name".equals(record.getName())) {
            String sql = "INSERT INTO country (name,code) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, record.getName());
            st.setString(2, record.getCode());
            st.executeUpdate();
        }
    }

    private static int countRecords(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        process();
    }
}