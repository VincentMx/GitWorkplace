package cn.lix.TimerTask;

import com.lix.util.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : lix
 * @desc :测试定时器
 * @time : 15:402018/8/20
 * @modify by :
 */
public class TestTimerTask {

    public static void main(String[]  args){
        timer1();
        timer2();
        timer3();
        timer4();
    }

    /**
      *@method: 这个只跑了一次、不太好
      *@author: lix
      *@desc：
      *@Date: 14:49 2018/9/19
      *@param:
      *@return:
      *
      */
    public static void timer1() {
         Timer timer = new Timer();
         timer.schedule(new TimerTask() {
              public void run() {
                      System.out.println("-------设定要指定任务1--------");
              }
          }, 2000);// 设定指定的时间time,此处为2000毫秒
    }




    /**
      *@method: 有循环的特征、可以使用
      *@author: lix
      *@desc： 
      *@Date: 14:48 2018/9/19
      *@param: 
      *@return:   
      *
      */
    public static void timer2() {
     Timer timer = new Timer();
     timer.schedule(new TimerTask() {
       public void run() {
         System.out.println("-------设定要指定任务2--------" + DateUtils.getCurrDateTime());
       }
     }, 1000, 5000);
   }


   /**
     *@method: 以固定频率的、可以用
     *@author: lix
     *@desc： 
     *@Date: 14:53 2018/9/19
     *@param: 
     *@return:   
     *
     */
    public static void timer3() {
     Timer timer = new Timer();
     timer.scheduleAtFixedRate(new TimerTask() {
       public void run() {
         System.out.println("-------设定要指定任务3--------"+ DateUtils.getCurrDateTime());
       }
     }, 1000, 2000);
   }

   // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
   // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
    
    /**
      *@method: 指定时间、每天执行一次、、可以考虑
      *@author: lix
      *@desc： 
      *@Date: 14:54 2018/9/19
      *@param: 
      *@return:   
      *
      */
   public static void timer4() {
     Calendar calendar = Calendar.getInstance();
     calendar.set(Calendar.HOUR_OF_DAY, 14); // 控制时
     calendar.set(Calendar.MINUTE, 56);    // 控制分
     calendar.set(Calendar.SECOND, 0);    // 控制秒

     Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00

     Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
       public void run() {
         System.out.println("-------设定要指定任务4--------");
      }
     }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
   }






}
