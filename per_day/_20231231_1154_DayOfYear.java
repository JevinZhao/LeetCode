/**
 *给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 * 思路：分割字符串，将字符串转换成数字，判断是否为润年
 */
public class _20231231_1154_DayOfYear {

    public int dayOfYear(String date) {
        //字符串切割年，月，日
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        if (month==1){
            return day;
        }
        if(month==2){
            return 31+day;
        }
        if (month>=3&&(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            if (month%2==0){
                return 31*(month/2)+30*(month/2-2)+29+day;
            }else {
                return 31*((month-1)/2)+30*((month-1)/2-1)+29+day;
            }
        }
        else {

            if (month%2==0){
                return 31*(month/2)+30*(month/2-2)+28+day;
            }else {
                return 31*((month-1)/2)+30*((month-1)/2-1)+28+day;
            }
        }
    }

    /**
     * 问题：自己通过递推公式算出啦，有些结果不符，7,8月都是31天，我是按7月31天，8月30天计算
     * 还不如枚举
     */
    public int dayOfYear2(String date) {
        //字符串切割年，月，日
        int result = 0;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] data = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //以月份为循环次数，进行累加，遇到润年2月份加1
        for (int i = 0; i < month-1; i++) {
            result = result+data[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))&&month>2) {
            return result + 1+day;
        }else {
            return result+day;
        }
    }
    public static void main(String[] args) {
        _20231231_1154_DayOfYear dayOfYear = new _20231231_1154_DayOfYear();
        System.out.println(dayOfYear.dayOfYear2("2012-01-02"));
    }
}
