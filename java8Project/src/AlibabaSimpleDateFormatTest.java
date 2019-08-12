import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AlibabaSimpleDateFormatTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate2(LocalDateTime date) {
        return formatter.format(date);
    }

    public static LocalDateTime parse2(String dateNow) {
        //LocalDate 日期
        //LocalDateTime 日期+时间
        //LocalTime  时间
        return LocalDateTime.parse(dateNow, formatter);

    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i=0;i<20 ;i++){
            executorService.execute(()->{
                for (int j=0;j<10 ;j++){
                    System.out.println(  parse2(formatDate2(LocalDateTime.now()))  );
                }
            });
        }
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
