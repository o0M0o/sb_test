@file:Suppress("unused")
package com.wxm.demo.common.date

import java.sql.Timestamp
import java.text.ParseException
import java.util.*

/**
 * calendar extend
 * @author      WangXM
 * @version     create：2018/5/24
 */

fun Calendar.getYear():Int {
    return this.get(Calendar.YEAR)
}

/**
 * get month for calendar, range is [1-12]
 */
fun Calendar.getMonth():Int {
    return this.get(Calendar.MONTH) + 1
}

/**
 * get day in month, start with 1
 */
fun Calendar.getDayInMonth():Int {
    return this.get(Calendar.DAY_OF_MONTH)
}

/**
 * get day in week as string
 */
fun Calendar.getDayInWeekStr():String {
    return when (this.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> "星期日"
        Calendar.MONDAY -> "星期一"
        Calendar.TUESDAY -> "星期二"
        Calendar.WEDNESDAY -> "星期三"
        Calendar.THURSDAY -> "星期四"
        Calendar.FRIDAY -> "星期五"
        Calendar.SATURDAY -> "星期六"
        else -> ""
    }
}

/**
 * get string for hour&minute
 */
fun Calendar.getHourMinuteStr():String   {
    return String.format(Locale.CHINA, "%02d:%02d",
            this.get(Calendar.HOUR_OF_DAY), this.get(Calendar.MINUTE))
}

/**
 * translate to timestamp
 */
fun Calendar.toTimestamp():Timestamp    {
    return Timestamp(this.timeInMillis)
}

/**
 * date string to Timestamp
 * string must be :
 * "2016-08-06",
 * "2016年08月06日"
 * "2016-08-06 12:00:00",
 * "2016-08-06 12:00",
 * "2016年08月06日 12:00:00"
 * "2016年08月06日 12:00"
 *
 * @return  Calendar
 * @throws ParseException parse failure
 */
@Throws(ParseException::class)
fun String.toCalendar(): Calendar {
    return this.toTimestamp().toCalendar()
}
