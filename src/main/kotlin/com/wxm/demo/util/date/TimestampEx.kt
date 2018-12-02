@file:Suppress("unused")
package com.wxm.demo.util.date

import java.lang.Exception
import java.sql.Timestamp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * helper for timestamp
 * @author      WangXM
 * @version     create：2018/5/25
 */

const val ONE_MINUTE_MS = 1000L * 60L
const val ONE_HOUR_MS = 1000L * 3600L
const val ONE_HOUR_SECOND = ONE_HOUR_MS / 1000L
const val ONE_DAY_MS = ONE_HOUR_MS * 24L
const val ONE_DAY_SECOND = ONE_DAY_MS / 1000L

private val FORMATTER_YEAR = CalendarUtility(SimpleDateFormat("yyyy", Locale.CHINA))
private val FORMATTER_YEAR_MONTH = CalendarUtility(SimpleDateFormat("yyyy-MM", Locale.CHINA))
private val FORMATTER_YEAR_MONTH_DAY = CalendarUtility(SimpleDateFormat("yyyy-MM-dd", Locale.CHINA))

/**
 * translator to calendar
 */
fun Timestamp.toCalendar(): Calendar {
    return this.let { Calendar.getInstance().apply { timeInMillis = it.time } }
}

/**
 * clone self
 */
fun Timestamp.toClone(): Timestamp  {
    return Timestamp(this.time)
}

fun Timestamp.now() {
    set(System.currentTimeMillis())
}

/**
 * use [a] set self
 */
fun Timestamp.set(a: Any) {
    time = a.toTimeStamp().time
}

/**
 * translate Any to TimeStamp
 * if fail, return Timestamp(0)
 */
fun Any.toTimeStamp(): Timestamp    {
    return when(this) {
        is Timestamp -> this
        is Long -> Timestamp(this)
        is String -> this.toTimestamp()
        else -> Timestamp(0)
    }
}

/**
 * if Any can translate to Timestamp return true else false
 */
fun Any.tryToTimeStamp(): Boolean   {
    try {
        this.toTimeStamp()
    } catch (e: Exception)  {
        return false
    }

    return true
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
 * @return      timestamp
 * @throws ParseException parse failure
 */
@Throws(ParseException::class)
fun String.toTimestamp(): Timestamp {
    var valstr = this.replace("年", "-").replace("月", "-")
            .replace("日", "")
    if (valstr.length == "yyyy-MM-dd".length) {
        valstr += " 00:00:00"
    } else if (valstr.length == "yyyy-MM-dd HH:mm".length) {
        valstr += ":00"
    }

    return Timestamp(SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
            .parse(valstr)!!.time)
}


/**
 * get hour&minute string for timestamp
 * example : 2018-06-06 12:30:45 -> 12:30
 */
fun Timestamp.toHourMinuteStr(): String {
    return this.toCalendar().let {
        String.format(Locale.CHINA, "%02d:%02d",
                it.get(Calendar.HOUR_OF_DAY), it.get(Calendar.MINUTE))
    }
}

/**
 * get day string for timestamp
 * example : 2018-06-06 12:30:45 -> 2018年06月06日
 */
fun Timestamp.toDayStr(): String {
    return this.toCalendar().let {
        String.format(Locale.CHINA, "%04d年%02d月%02d日",
                it.get(Calendar.YEAR), it.get(Calendar.MONTH) + 1, it.get(Calendar.DAY_OF_MONTH))
    }
}

/**
 * get day-hour-minute for timestamp
 * example : 2018-06-06 12:30:45 -> 2018年06月06日 12:30
 */
fun Timestamp.toDayHourMinuteStr(): String {
    return this.toCalendar().let {
        String.format(Locale.CHINA, "%04d年%02d月%02d日 %02d:%02d",
                it.get(Calendar.YEAR), it.get(Calendar.MONTH) + 1, it.get(Calendar.DAY_OF_MONTH),
                it.get(Calendar.HOUR_OF_DAY), it.get(Calendar.MINUTE))
    }
}

/**
 * get day in week string[星期一， 星期日]
 */
fun Timestamp.toDayInWeekStr(): String = this.toCalendar().getDayInWeekStr()

/**
 * get diff days for [otherTs] from self
 * -- #self is early than [otherTs] return negative days
 * -- #self is later than [otherTs] return positive days
 * -- #self is in same day for [otherTs] return zero
 */
fun Timestamp.diffCalendarDays(otherTs: Timestamp): Int {
    val my = this.toCalendar()
    val you = otherTs.toCalendar()

    return if(my.getYear() == you.getYear() && my.getMonth() == you.getMonth()
            && my.getDayInMonth() == you.getDayInMonth())  {
        0
    } else {
        ((this.time - otherTs.time) / ONE_DAY_MS).toInt()
    }
}

fun Timestamp.diffDays(otherTs: Timestamp): Int {
    return (diffHours(otherTs) / 24)
}

fun Timestamp.diffHours(otherTs: Timestamp): Int {
    return (diffSecond(otherTs) / 3600)
}

fun Timestamp.diffSecond(otherTs: Timestamp): Int {
    return ((this.time - otherTs.time) / 1000).toInt()
}

/**
 * if self after [milliSeconds] return true, else false
 */
fun Timestamp.after(milliSeconds: Long): Boolean   {
    return after(Timestamp(milliSeconds))
}

/**
 * get new Timestamp after [milliSeconds]
 */
fun Timestamp.addMilliSeconds(milliSeconds: Number): Timestamp    {
    return Timestamp(this.time + milliSeconds.toLong())
}

/**
 * get new Timestamp after [seconds]
 */
fun Timestamp.addSeconds(seconds: Number): Timestamp    {
    return Timestamp(this.time + seconds.toLong() * 1000)
}

/**
 * get new Timestamp after [minutes]
 */
fun Timestamp.addMinutes(minutes: Number): Timestamp    {
    return Timestamp(this.time + minutes.toLong() * ONE_MINUTE_MS)
}

/**
 * get new Timestamp after [hours]
 */
fun Timestamp.addHours(hours: Number): Timestamp    {
    return Timestamp(this.time + hours.toLong() * ONE_HOUR_MS)
}

/**
 * get new Timestamp after [days]
 */
fun Timestamp.addDays(days: Number): Timestamp    {
    return Timestamp(this.time + days.toLong() * ONE_DAY_MS)
}

/**
 * if self between [a] to [b] return true else false
 */
fun Timestamp.between(a: Timestamp, b: Timestamp): Boolean  {
    return if(a.after(b))  {
        time in b.time .. a.time
    } else  {
        time in a.time .. b.time
    }
}

/**
 * for tag use
 * example :
 */
fun Timestamp.toYearTag(): String = FORMATTER_YEAR.format(this)
fun Timestamp.toYearMonthTag(): String = FORMATTER_YEAR_MONTH.format(this)
fun Timestamp.toYearMonthDayTag(): String = FORMATTER_YEAR_MONTH_DAY.format(this)
fun Timestamp.toYearMonthDayHourMinuteTag(): String
        = CalendarUtility.SDF_YEAR_MONTH_DAY_HOUR_MINUTE.format(this)
fun Timestamp.toFullTag(): String
        = CalendarUtility.SDF_FULL.format(this)