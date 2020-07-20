import java.util.Calendar;
import java.util.GregorianCalendar;

public class getAge {
    public static String getAge(String date, String nowTime)
    {
        if (TextUtils.isEmpty(date)||TextUtils.isEmpty(nowTime)){
            return "";
        }
        String[] data = date.split("-");
        String[] nowData = nowTime.split("-");
        if (data.length < 3 || nowData.length < 3)
            return "";

        Calendar birthday = new GregorianCalendar(Integer.valueOf(data[0]),
                Integer.valueOf(data[1]), Integer.valueOf(data[2]));

        Calendar now = new GregorianCalendar(Integer.valueOf(nowData[0]),
                Integer.valueOf(nowData[1]), Integer.valueOf(nowData[2]));
        int day = now.get(Calendar.DAY_OF_MONTH)
                - birthday.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        // 按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
        if (day < 0)
        {
            month -= 1;
            now.add(Calendar.MONTH, -1);// 得到上一个月，用来得到上个月的天数。
            day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (month < 0)
        {
            month = (month + 12) % 12;
            year--;
        }
        System.out.println("年龄：" + year + "岁" + month + "月" + day + "天");
        StringBuffer tag = new StringBuffer();
        if (year > 0)
        {
            tag.append(year + "岁");
        }
        if (month > 0)
        {
            tag.append(month + "个月");
        }
        if (day > 0)
        {
            tag.append(day + "天");
        }
        if (year == 0 && month == 0 && day == 0)
        {
            tag.append("今日出生");
        }
        return String.valueOf(tag);
    }
}
