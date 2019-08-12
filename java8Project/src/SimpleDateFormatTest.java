import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleDateFormatTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static String formatDate(Date date) {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

    public static String synformatDate(Date date) {
        synchronized (sdf) {
            return sdf.format(date);
        }
    }

    public static Date synparse(String strDate) throws ParseException {
        synchronized (sdf) {
            return sdf.parse(strDate);
        }
    }

    //你看这不崩了？部分线程获取的时间不对，部分线程直接报 java.lang.NumberFormatException:multiple points错，线程直接挂死了。
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 20; j++) {
                    try {
                        System.out.println(parse("20180102"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}
