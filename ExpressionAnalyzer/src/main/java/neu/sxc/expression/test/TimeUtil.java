//package neu.sxc.expression.test;
//
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//import java.util.TimeZone;
//
///**
// * @Author:chaoqiang.zhou
// * @Date:Create in 上午10:15 2018/8/29
// */
//public class TimeUtil {
//
//
//    private TimeUtil() {
//    }
//
//    /**
//     * The UTC time zone (often referred to as GMT).
//     */
//    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
//    /**
//     * Number of milliseconds in a standard second.
//     *
//     * @since 2.1
//     */
//    public static final long MILLIS_PER_SECOND = 1000;
//    /**
//     * Number of milliseconds in a standard minute.
//     *
//     * @since 2.1
//     */
//    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
//    /**
//     * Number of milliseconds in a standard hour.
//     *
//     * @since 2.1
//     */
//    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
//    /**
//     * Number of milliseconds in a standard day.
//     *
//     * @since 2.1
//     */
//    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;
//
//    public static final int SECONDS_PER_DAY = 24 * 60 * 60;
//
//    public static final int SECONDS_PER_HOUR = 60 * 60;
//
//    public static final int SECONDS_PER_MINUTE = 60;
//
//
//    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
//    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
//    public static final String yyyy_MM_dd_CH = "yyyy年MM月dd日";
//    public static final String yyyy_MM_dd_HH_mm_CH = "yyyy年MM月dd日 HH:mm";
//    public static final String MM_dd_CH = "MM月dd日";
//    public static final String MM_dd = "MM-dd";
//    public static final String HH_mm = "HH:mm";
//    public static final String HH_mm_ss = "HH:mm:ss";
//    public static final String MM_dd_CH_HH_mm = "MM月dd日 HH:mm";
//    public static final String MM_dd_HH_mm = "MM-dd HH:mm";
//    public static final String yyyy_MM_dd = "yyyy-MM-dd";
//    public static final String yyyy_MM = "yyyy-MM";
//    public static final String yyyyMMdd = "yyyyMMdd";
//    public static final String yyyyMMddHH = "yyyyMMddHH";
//    public static final String yyyy_MM_dd_00_00_00 = "yyyy-MM-dd 00:00:00";
//
//
//    public static Date parse_yyyy_MM_dd(String timeStr) {
//        return parse(yyyy_MM_dd, timeStr);
//    }
//
//    public static Date parse_yyyy_MM(String timeStr) {
//        return parse(yyyy_MM, timeStr);
//    }
//
//    public static Date parse_yyyy_MM_dd_HH_mm_ss(String timeStr) {
//        return parse(yyyy_MM_dd_HH_mm_ss, timeStr);
//    }
//
//    public static String format_yyyy_MM_dd_HH_mm_ss(Date date) {
//        return formate(yyyy_MM_dd_HH_mm_ss, date);
//    }
//
//    public static String format_MM_dd(Date date) {
//        return formate(MM_dd, date);
//    }
//
//    public static String format_MM_dd_HH_mm(Date date) {
//        return formate(MM_dd_HH_mm, date);
//    }
//
//    public static String format_yyyy_MM_dd_HH_mm(Date date) {
//        return formate(yyyy_MM_dd_HH_mm, date);
//    }
//
//    public static String format_HH_mm(Date date) {
//        return formate(HH_mm, date);
//    }
//
//    public static String format_yyyy_mm_dd_ch(Date date) {
//        return formate(yyyy_MM_dd_CH, date);
//    }
//
//    public static String format_yyyyMMddHH(Date date) {
//        return formate(yyyyMMddHH, date);
//    }
//
//    public static String format_yyyy_mm_dd_HH_mm_ch(Date date) {
//        return formate(yyyy_MM_dd_HH_mm_CH, date);
//    }
//
//    public static String format_MM_dd_CH(Date date) {
//        return formate(MM_dd_CH, date);
//    }
//
//    public static String format_MM_dd_CH_HH_mm(Date date) {
//        return formate(MM_dd_CH_HH_mm, date);
//    }
//
//    public static String format_yyyy_MM_dd_00_00_00(Date date) {
//        return formate(yyyy_MM_dd_00_00_00, date);
//    }
//
//    public static String format_yyyy_MM_dd(Date date) {
//        return formate(yyyy_MM_dd, date);
//    }
//
//    public static String format_yyyy_MM(Date date) {
//        return formate(yyyy_MM, date);
//    }
//
//    public static String yyyyMMdd(Date date) {
//        return formate(yyyyMMdd, date);
//    }
//
//    public static Date parse_yyyy_MM_dd_HH_mm(String timeStr) {
//        return parse(yyyy_MM_dd_HH_mm, timeStr);
//    }
//
//
//    public static Date parse(String format, String timeStr) {
//        SimpleDateFormat formatSim = new SimpleDateFormat(format);
//        Date d = null;
//        try {
//            d = formatSim.parse(timeStr);
//        } catch (ParseException e) {
//        }
//        return d;
//    }
//
//    public static String formate(String format, Date date) {
//        SimpleDateFormat formatSim = new SimpleDateFormat(format);
//        return formatSim.format(date);
//    }
//
//    /**
//     * 获得指定日期的前一天
//     *
//     * @param dayStr
//     * @return
//     * @throws Exception
//     */
//    public static String getDayBefore(String timeFormat, String dayStr) {
//        Calendar c = Calendar.getInstance();
//        Date date = TimeUtil.parse(timeFormat, dayStr);
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day - 1);
//        String dayBefore = TimeUtil.formate(timeFormat, c.getTime());
//        return dayBefore;
//    }
//
//
//    public static Date getDayBefore(Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day - 1);
//        return c.getTime();
//    }
//
//    /**
//     * 获取当前日期前 多少天时间
//     *
//     * @param date
//     * @param days
//     * @return
//     */
//    public static Date getDayBeforeBetween(Date date, int days) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day - days);
//        return c.getTime();
//    }
//
//    /**
//     *
//     * @Title: getCurrDayBeforeZero
//     * @Description: TODO(这里用一句话描述这个方法的作用)
//     * @param @return 设定文件
//     * @return Date 返回类型
//     * @throws
//     */
//
//
//    /**
//     * @param beforeDay
//     * @return Date 返回类型
//     * @throws
//     * @Title: getDayBeforeZero
//     * @Description: 获取前几天的零点时间[yyyy_MM_dd_00_00_00]
//     */
//    public static Date getDayBeforeZero(int beforeDay) {
//        Date dayBefore = null;
//        try {
//            Calendar now = Calendar.getInstance();
//            int day = now.get(Calendar.DATE);
//            now.set(Calendar.DATE, day - beforeDay);
//            SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd_00_00_00);
//            dayBefore = sdf.parse(sdf.format(now.getTime()));
//        } catch (ParseException e) {
//        }
//        return dayBefore;
//    }
//
//    // MILLIS_PER_HOUR
//    public static int getHoursByLong(long time) {
//        int d = (int) (time / MILLIS_PER_HOUR);
//        return d;
//    }
//
//    /**
//     * @return Date 返回类型
//     * @throws
//     * @Title: getYesterdayZero
//     * @Description: 获取前一天(昨天)的零点时间
//     */
//    public static Date getYesterdayZero() {
//        return getDayBeforeZero(1);
//    }
//
//
//    /**
//     * 获取指定日期后 n天  时间
//     *
//     * @param timeFormat
//     * @param dayStr
//     * @param days
//     * @return
//     */
//    public static String getDayAfterBetween(String timeFormat, String dayStr, int days) {
//        Calendar c = Calendar.getInstance();
//        Date date = TimeUtil.parse(timeFormat, dayStr);
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day + days);
//        String dayAfter = TimeUtil.formate(timeFormat, c.getTime());
//        return dayAfter;
//    }
//
//    public static Date getDayAfterBetween(Date date, int days) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day + days);
//        return c.getTime();
//    }
//
//    /**
//     * 获得指定日期的后一天
//     *
//     * @param dayStr
//     * @return
//     */
//    public static String getDayAfter(String timeFormat, String dayStr) {
//        Calendar c = Calendar.getInstance();
//        Date date = TimeUtil.parse(timeFormat, dayStr);
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day + 1);
//        String dayAfter = TimeUtil.formate(timeFormat, c.getTime());
//        return dayAfter;
//    }
//
//    //两时间相差多少天
//    public static int days(String startTime, String endTime) throws ParseException {
//
//        startTime = convertStr(startTime);
//        endTime = convertStr(endTime);
//        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
//        Long c = sf.parse(endTime).getTime() - sf.parse(startTime).getTime();
//        int d = (int) (c / 1000 / 60 / 60 / 24);
//        return d;
//
//    }
//
//    //转换时间格式
//    public static String convertStr(String oldTime) {
//        String newTime = oldTime.replace("-", "");
//        return newTime;
//    }
//
//    /**
//     * 计算date距时间起点的天数
//     *
//     * @param date
//     * @return
//     */
//    public static int daysCount(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date start = sdf.parse("1970-01-01");
//            date = sdf.parse(sdf.format(date));
//            long time1 = start.getTime();
//            long time2 = date.getTime();
//            long between_days = (time2 - time1) / (1000 * 3600 * 24);
//            return (int) between_days;
//        } catch (Exception e) {
//        }
//        return -1;
//    }
//
//    public static Date getDayAfter(Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int day = c.get(Calendar.DATE);
//        c.set(Calendar.DATE, day + 1);
//        return c.getTime();
//    }
//
//    public static boolean isBetween(Date begin, Date curr, Date end) {
//        // "2014-12-11 12:12:20".compareTo("2014-12-12 12:12:20") =-1
//        if (begin.compareTo(curr) <= 0 && curr.compareTo(end) <= 0) {
//            return true;
//        }
//        return false;
//    }
//
//
//    public static boolean isBeforeSomeHours(Date now, Date when, Double someHours) {
//        Double someHoursMs = DateUtils.MILLIS_PER_HOUR * someHours;
//        Long aftMs = when.getTime();
//        Long befMs = now.getTime();
//        return ((aftMs - befMs) > someHoursMs) ? true : false;
//    }
//
//    public static boolean isBeforeSomeMinutes(Date now, Date when, Long someMinutes) {
//        Long someHoursMs = DateUtils.MILLIS_PER_MINUTE * someMinutes;
//        Long aftMs = when.getTime();
//        Long befMs = now.getTime();
//        return ((aftMs - befMs) > someHoursMs) ? true : false;
//    }
//
//
//    public static boolean isBeforeSomeSeconds(Date now, Date when, Long seconds) {
//        Long someMs = DateUtils.MILLIS_PER_SECOND * seconds;
//        Long aftMs = when.getTime();
//        Long befMs = now.getTime();
//        return ((aftMs - befMs) > someMs) ? true : false;
//    }
//
//    /**
//     * 计算两个日期之间相差的天数
//     *
//     * @param smdate 较小的时间
//     * @param bdate  较大的时间
//     * @return 相差天数
//     * @throws ParseException
//     */
//    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        smdate = sdf.parse(sdf.format(smdate));
//        bdate = sdf.parse(sdf.format(bdate));
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(smdate);
//        long time1 = cal.getTimeInMillis();
//        cal.setTime(bdate);
//        long time2 = cal.getTimeInMillis();
//        long between_days = (time2 - time1) / (1000 * 3600 * 24);
//
//        return Integer.parseInt(String.valueOf(between_days));
//    }
//
//    /**
//     * 计算两个日期之间相差的分钟
//     *
//     * @param smdate 较小的时间
//     * @param bdate  较大的时间
//     * @return 相差的分钟
//     * @throws ParseException
//     */
//    public static int minuteBetween(Date smdate, Date bdate) {
//        long time1 = smdate.getTime();
//        long time2 = bdate.getTime();
//        long between_days = (time2 - time1) / (1000 * 60);
//
//        return Integer.parseInt(String.valueOf(between_days));
//    }
//
//    /**
//     * 时间time加minute分钟
//     *
//     * @param time
//     * @param minute
//     * @return
//     * @throws ParseException
//     */
//    public static String addMinuteForTime(Timestamp time, int minute) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Date date = null;
//        date = sdf.parse(sdf.format(time));
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(date);
//        ca.add(Calendar.MINUTE, minute);
//        return sdf.format(ca.getTime());
//    }
//
//
//    /**
//     * 时间Date减minute分钟
//     *
//     * @param time
//     * @param minute
//     * @return
//     * @throws ParseException
//     */
//    public static String dayAddMinuteForTime(Date time, int minute) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat(TimeUtil.yyyy_MM_dd_HH_mm);
//        Date date = null;
//        date = sdf.parse(sdf.format(time));
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(date);
//        ca.add(Calendar.MINUTE, minute);
//        return sdf.format(ca.getTime());
//    }
//
//    public static String MinuteForTime(Timestamp time) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Date date = null;
//        date = sdf.parse(sdf.format(time));
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(date);
//        return sdf.format(ca.getTime());
//    }
//
//    public static Date addHourForTime(Date time, int hour) {
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(time);
//        ca.add(Calendar.HOUR_OF_DAY, hour);
//        return ca.getTime();
//    }
//
//    public static Date addDayForTime(Date time, int day) {
//        Calendar calendar = new java.util.GregorianCalendar();
//        calendar.setTime(time);
//        calendar.add(Calendar.DATE, day);// 把日期往后增加一天.整数往后推,负数往前移动
//        time = calendar.getTime(); // 这个时间就是日期往后推一天的结果
//        return time;
//    }
//
//    /**
//     * 两个时间相差多少小时
//     *
//     * @param start
//     * @param end
//     * @return
//     * @throws ParseException
//     */
//    public static double dateDiff(Date start, Date end) throws ParseException {
//        long diff = end.getTime() - start.getTime();//这样得到的差值是微秒级别
//        BigDecimal a = new BigDecimal(diff);
//        BigDecimal hours = a.divide(new BigDecimal(3600000), 3, BigDecimal.
//                ROUND_HALF_UP);
//        return hours.doubleValue();
//    }
//
//    /**
//     * 两个时间是否为同一天
//     *
//     * @param date1
//     * @param date2
//     * @return
//     */
//    public static boolean isSameDate(Date date1, Date date2) {
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(date1);
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(date2);
//
//        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
//                .get(Calendar.YEAR);
//        boolean isSameMonth = isSameYear
//                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
//        boolean isSameDate = isSameMonth
//                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
//                .get(Calendar.DAY_OF_MONTH);
//
//        return isSameDate;
//    }
//
//    /**
//     * 与当前时间相比，HH:mm
//     * 当前时间小为true
//     * 当前时间大为false
//     *
//     * @param time
//     * @return
//     * @throws Exception
//     */
//    public static boolean isAcceptTime(String time) throws Exception {
//        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
//        Date now = new Date();
//        now = sd.parse(sd.format(now));
//        long nowT = now.getTime();
//        long nowL = sd.parse(time).getTime();
//        return nowT < nowL;
//    }
//
//    //获取毫秒
//    public static long getMillisecond(String time) {
//        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
//        try {
//            return sd.parse(time).getTime();
//        } catch (ParseException e) {
//            LOGGER.error("getMillisecond error", e);
//        }
//        return 0;
//    }
//
//    public static long getMillisecondWithFormat(String time, String formatter) {
//        SimpleDateFormat sd = new SimpleDateFormat(formatter);
//        try {
//            return sd.parse(time).getTime();
//        } catch (ParseException e) {
//            LOGGER.error("getMillisecondWithFormat error", e);
//        }
//        return 0;
//    }
//
//    public static String getMillisecondToStr(long milliSecond) {
//        Date dattimeDate = new Date(milliSecond);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dattimeDate);
//        SimpleDateFormat formattwo = new SimpleDateFormat("HH:mm");
//        String nowtime = formattwo.format(calendar.getTime());
//        return nowtime;
//    }
//
//    /**
//     * 判断当前日期是星期几
//     *
//     * @param pTime 修要判断的时间
//     * @return dayForWeek 判断结果
//     * @Exception 发生异常
//     */
//    public static int dayForWeek(Date pTime) throws Exception {
//        Calendar c = Calendar.getInstance();
//        c.setTime(pTime);
//        int dayForWeek = 0;
//        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
//            dayForWeek = 7;
//        } else {
//            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
//        }
//        return dayForWeek;
//    }
//
//    /**
//     * date----Calendar
//     *
//     * @param date
//     * @return
//     */
//    public static Calendar getCalendar(Date date) {
//        Calendar cl = Calendar.getInstance();
//
//        cl.setTime(date);
//        return cl;
//    }
//
//    public static boolean duringDatePeriod(Date startTime, Date endTime, Date descTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String _startTime = sdf.format(startTime);
//        String _endTime = sdf.format(endTime);
//        String _descTime = sdf.format(descTime);
//        return duringDatePeriod(_startTime, _endTime, _descTime);
//    }
//
//
//    public static boolean duringDatePeriod(String startTime, String endTime, String descTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date _descTime;
//        Date _startTime;
//        Date _endTime;
//        try {
//            _descTime = sdf.parse(descTime);
//            _startTime = sdf.parse(startTime);
//            _endTime = sdf.parse(endTime);
//            return _descTime.getTime() <= _endTime.getTime() && _descTime.getTime() >= _startTime.getTime();
//        } catch (ParseException e) {
//            LOGGER.error("duringDatePeriod error", e);
//        }
//        return false;
//    }
//
//    public static boolean duringDatePeriod(String startTime, String endTime, Date descTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String _descTime = sdf.format(descTime);
//        return duringDatePeriod(startTime, endTime, _descTime);
//    }
//
//    /**
//     * Description: 指定日期加指定分钟
//     *
//     * @param date
//     * @param minute
//     * @return
//     */
//    public static Date addMinute(Date date, int minute) {
//        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(getMillis(date) + ((long) minute) * 60 * 1000);
//        return c.getTime();
//    }
//
//    public static long getMillis(Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        return c.getTimeInMillis();
//    }
//
//    public static String dealDateFormat(String oldDateStr) {
//        try {
//
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            Date date = df.parse(oldDateStr);
//            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
//            Date date1 = df1.parse(date.toString());
//            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            return df2.format(date1);
//        } catch (Exception e) {
//            LOGGER.error("dealDateFormat error", e);
//        }
//        return null;
//    }
//
//    /**
//     * 获取当前日期是星期几<br>
//     *
//     * @param dt
//     * @return 当前日期是星期几
//     */
//    public static String getWeekOfDate(Date dt) {
//        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(dt);
//        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (w < 0)
//            w = 0;
//
//        return weekDays[w];
//    }
//
//
//    /**
//     * 功能描述:
//     *
//     * @param: 获取当前时间的毫秒数
//     * @return:
//     * @auther: zhou
//     * @date: 2019/2/22 下午6:02
//     */
//    public static long getMilliSecond() {
//        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    }
//
//
//    /**
//     * 功能描述:
//     *
//     * @param: 获取当前时间的毫秒数
//     * @return:
//     * @auther: zhou
//     * @date: 2019/2/22 下午6:02
//     */
//    public static long getMilliSecond(LocalDateTime time) {
//        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    }
//
//
//
//}
